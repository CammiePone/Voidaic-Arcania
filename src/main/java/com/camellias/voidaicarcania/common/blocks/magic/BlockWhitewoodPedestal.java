package com.camellias.voidaicarcania.common.blocks.magic;

import java.util.Random;

import com.camellias.voidaicarcania.common.blocks.BlockBaseGeneric;
import com.camellias.voidaicarcania.common.tileentities.altar.TileWhitewoodPedestal;
import com.camellias.voidaicarcania.core.init.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWhitewoodPedestal extends BlockBaseGeneric
{
	public BlockWhitewoodPedestal(Material material, String name)
	{
		super(material, name);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(pos);
			
			if(!player.getHeldItem(hand).isEmpty() && pedestal.handler.getStackInSlot(0).getCount() < 1)
			{
				pedestal.handler.setStackInSlot(0, player.getHeldItem(hand).splitStack(1));
			}
		}
		
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
		TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(pos);
		//InventoryHelper.dropInventoryItems(world, pos, tileEntity);
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}
