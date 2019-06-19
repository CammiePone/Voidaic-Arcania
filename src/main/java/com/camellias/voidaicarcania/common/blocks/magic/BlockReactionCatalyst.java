package com.camellias.voidaicarcania.common.blocks.magic;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.common.blocks.BlockBaseGeneric;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTripWireHook;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockReactionCatalyst extends BlockBaseGeneric
{
	public static final PropertyBool ATTACHED = PropertyBool.create("attached");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	protected static final AxisAlignedBB CATALYST_AABB = new AxisAlignedBB(0.0D, 0.0625D, 0.0D, 1.0D, 0.15625D, 1.0D);
	
	public BlockReactionCatalyst(Material material, String name)
	{
		super(material, name);
		this.setDefaultState(this.blockState.getBaseState()
				.withProperty(ATTACHED, Boolean.valueOf(false))
				.withProperty(NORTH, Boolean.valueOf(false))
				.withProperty(EAST, Boolean.valueOf(false))
				.withProperty(SOUTH, Boolean.valueOf(false))
				.withProperty(WEST, Boolean.valueOf(false)));
		this.setTickRandomly(true);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return CATALYST_AABB;
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		return state.withProperty(NORTH, Boolean.valueOf(isConnectedTo(world, pos, state, EnumFacing.NORTH)))
				.withProperty(EAST, Boolean.valueOf(isConnectedTo(world, pos, state, EnumFacing.EAST)))
				.withProperty(SOUTH, Boolean.valueOf(isConnectedTo(world, pos, state, EnumFacing.SOUTH)))
				.withProperty(WEST, Boolean.valueOf(isConnectedTo(world, pos, state, EnumFacing.WEST)));
	}
	
	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess world, BlockPos pos)
	{
		return NULL_AABB;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.STRING;
	}
	
	public ItemStack getItem(World world, BlockPos pos, IBlockState state)
	{
		return new ItemStack(Items.STRING);
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		world.setBlockState(pos, state, 3);
		this.notifyHook(world, pos, state);
	}
	
	private void notifyHook(World world, BlockPos pos, IBlockState state)
	{
		for(EnumFacing enumfacing : new EnumFacing[] {EnumFacing.SOUTH, EnumFacing.WEST})
		{
			for(int i = 1; i < 42; ++i)
			{
				BlockPos blockpos = pos.offset(enumfacing, i);
				IBlockState iblockstate = world.getBlockState(blockpos);
				
				if(iblockstate.getBlock() != ModBlocks.CATALYST)
				{
					break;
				}
			}
		}
	}
	
	@Override
	public void randomTick(World world, BlockPos pos, IBlockState state, Random random)
	{
		
	}
	
	private void updateState(World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		boolean flag1 = false;
		List<? extends Entity > list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, state.getBoundingBox(world, pos).offset(pos));
		
		if(!list.isEmpty())
		{
			for(Entity entity : list)
			{
				if(!entity.doesEntityNotTriggerPressurePlate())
				{
					flag1 = true;
					break;
				}
			}
		}
		
		if(flag1)
		{
			world.scheduleUpdate(new BlockPos(pos), this, this.tickRate(world));
		}
	}
	
	public static boolean isConnectedTo(IBlockAccess world, BlockPos pos, IBlockState state, EnumFacing direction)
	{
		BlockPos blockpos = pos.offset(direction);
		IBlockState iblockstate = world.getBlockState(blockpos);
		Block block = iblockstate.getBlock();
		
		return block == ModBlocks.CATALYST;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(ATTACHED, Boolean.valueOf((meta & 4) > 0));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		
		if(((Boolean)state.getValue(ATTACHED)).booleanValue())
		{
			i |= 4;
		}
		
		return i;
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		switch(rot)
		{
			case CLOCKWISE_180:
				return state.withProperty(NORTH, state.getValue(SOUTH))
						.withProperty(EAST, state.getValue(WEST))
						.withProperty(SOUTH, state.getValue(NORTH))
						.withProperty(WEST, state.getValue(EAST));
			
			case COUNTERCLOCKWISE_90:
				return state.withProperty(NORTH, state.getValue(EAST))
						.withProperty(EAST, state.getValue(SOUTH))
						.withProperty(SOUTH, state.getValue(WEST))
						.withProperty(WEST, state.getValue(NORTH));
			
			case CLOCKWISE_90:
				return state.withProperty(NORTH, state.getValue(WEST))
						.withProperty(EAST, state.getValue(NORTH))
						.withProperty(SOUTH, state.getValue(EAST))
						.withProperty(WEST, state.getValue(SOUTH));
			
			default:
				return state;
		}
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror)
	{
		switch(mirror)
		{
			case LEFT_RIGHT:
				return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(SOUTH, state.getValue(NORTH));
			
			case FRONT_BACK:
				return state.withProperty(EAST, state.getValue(WEST)).withProperty(WEST, state.getValue(EAST));
			
			default:
				return state.withMirror(mirror);
		}
	}
	
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {ATTACHED, NORTH, EAST, WEST, SOUTH});
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}
}
