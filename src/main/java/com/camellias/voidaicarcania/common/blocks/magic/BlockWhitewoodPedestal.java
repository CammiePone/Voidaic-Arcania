package com.camellias.voidaicarcania.common.blocks.magic;

import java.util.Random;

import com.camellias.voidaicarcania.common.blocks.BlockBaseGeneric;
import com.camellias.voidaicarcania.common.tileentities.altar.TileVoidaicAltar;
import com.camellias.voidaicarcania.common.tileentities.altar.TileWhitewoodPedestal;
import com.camellias.voidaicarcania.core.init.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWhitewoodPedestal extends BlockBaseGeneric
{
	protected static final AxisAlignedBB PEDESTAL_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.875D, 0.75D);
	
	public BlockWhitewoodPedestal(Material material, String name)
	{
		super(material, name);
		this.setHardness(2.0F);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return PEDESTAL_AABB;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(pos);
			
			if(!player.getHeldItem(hand).isEmpty() && pedestal.handler.getStackInSlot(0).getCount() < 1)
			{
				if(!player.isCreative())
				{
					pedestal.handler.setStackInSlot(0, player.getHeldItem(hand).splitStack(1));
				}
				else
				{
					ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem(), 1, player.getHeldItem(hand).getMetadata());
					pedestal.handler.setStackInSlot(0, stack);
				}
			}
			else if(player.getHeldItem(hand).isEmpty() && pedestal.handler.getStackInSlot(0).getCount() > 0)
			{
				player.inventory.addItemStackToInventory(pedestal.handler.getStackInSlot(0));
			}
		}
		
		state = world.getBlockState(pos);
		
		world.notifyBlockUpdate(pos, state, state, 2);
		
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileWhitewoodPedestal();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.PEDESTAL);
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		Iterable<MutableBlockPos> blocksWithin = BlockPos.getAllInBoxMutable(pos.getX() - 3, pos.getY(), pos.getZ() - 3, pos.getX() + 3, pos.getY(), pos.getZ() + 3);
		for(BlockPos blockPos : blocksWithin)
		{
			if(world.getTileEntity(blockPos) instanceof TileVoidaicAltar)
			{
				TileVoidaicAltar altar = (TileVoidaicAltar) world.getTileEntity(blockPos);
				altar.shouldStopAltar();
			}
		}
		
		TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(pos);
		ItemStack stack = pedestal.handler.getStackInSlot(0);
		
		EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
		world.spawnEntity(entityItem);
		super.breakBlock(world, pos, state);
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
}
