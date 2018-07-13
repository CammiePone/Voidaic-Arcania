package com.camellias.voidaicarcania.blocks;

import java.util.Random;

import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockVoidMelonCrop extends BlockCrops 
{
	
	//ItemBlock item = (ItemBlock) ModBlocks.BLOCK_VOID_MELON;
	//Block melon = Block.getBlockFromItem(item);
	
	private static final AxisAlignedBB[] bulb = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), 
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), 
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D), 
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), 
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
	
	public BlockVoidMelonCrop(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote)
		{
			Random rand = world.rand;
			
			if(this.isMaxAge(state))
			{
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Item.getItemFromBlock(ModBlocks.BLOCK_VOID_MELON), 1)));
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(rand.nextInt(10) == 0 ? ModItems.TRANSROOT : ModBlocks.BLOCK_MELON_CROP.getItemDropped(state, rand, 0))));
				world.setBlockState(pos, this.withAge(0));
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected Item getSeed() 
	{
		return ModItems.MELON_SEED;
	}
	
	@Override
	protected Item getCrop() 
	{
		return Item.getItemFromBlock(ModBlocks.BLOCK_VOID_MELON);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return bulb[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}
}