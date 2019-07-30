package com.camellias.voidaicarcania.common.blocks.magic;

import java.util.Random;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.common.blocks.BlockBaseGeneric;
import com.camellias.voidaicarcania.common.tileentities.altar.TileVoidaicAltar;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.init.ModItems;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BlockVoidaicAltar extends BlockBaseGeneric
{
	public BlockVoidaicAltar(Material material, String name)
	{
		super(material, name);
		this.setHardness(2.0F);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			TileVoidaicAltar altar = (TileVoidaicAltar) world.getTileEntity(pos);
			
			if(!player.getHeldItem(hand).isEmpty()
				&& player.getHeldItem(hand).getItem() != ModItems.WHITEWOOD_STAFF)
			{
				if(!player.isCreative())
				{
					if(altar.handler.getStackInSlot(0).getCount() < 1)
						altar.handler.setStackInSlot(0, player.getHeldItem(hand).splitStack(1));
					
					if(altar.handler.getStackInSlot(1).getCount() < 1 && altar.handler.getStackInSlot(0).getCount() > 0)
						altar.handler.setStackInSlot(1, player.getHeldItem(hand).splitStack(1));
					
					if(altar.handler.getStackInSlot(2).getCount() < 1 && altar.handler.getStackInSlot(1).getCount() > 0)
						altar.handler.setStackInSlot(2, player.getHeldItem(hand).splitStack(1));
					
					if(altar.handler.getStackInSlot(3).getCount() < 1 && altar.handler.getStackInSlot(2).getCount() > 0)
						altar.handler.setStackInSlot(3, player.getHeldItem(hand).splitStack(1));
				}
				else
				{
					ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem(), 1, player.getHeldItem(hand).getMetadata());
					
					if(altar.handler.getStackInSlot(0).getCount() < 1)
						altar.handler.setStackInSlot(0, stack);
					
					if(altar.handler.getStackInSlot(1).getCount() < 1 && altar.handler.getStackInSlot(0).getCount() > 0)
						altar.handler.setStackInSlot(1, stack);
					
					if(altar.handler.getStackInSlot(2).getCount() < 1 && altar.handler.getStackInSlot(1).getCount() > 0)
						altar.handler.setStackInSlot(2, stack);
					
					if(altar.handler.getStackInSlot(3).getCount() < 1 && altar.handler.getStackInSlot(2).getCount() > 0)
						altar.handler.setStackInSlot(3, stack);
				}
			}
			else if(player.getHeldItem(hand).isEmpty())
			{
				if(altar.handler.getStackInSlot(3).getCount() > 0)
					player.inventory.addItemStackToInventory(altar.handler.getStackInSlot(3));
				
				if(altar.handler.getStackInSlot(2).getCount() > 0 && altar.handler.getStackInSlot(3).getCount() < 1)
					player.inventory.addItemStackToInventory(altar.handler.getStackInSlot(2));
				
				if(altar.handler.getStackInSlot(1).getCount() > 0 && altar.handler.getStackInSlot(2).getCount() < 1)
					player.inventory.addItemStackToInventory(altar.handler.getStackInSlot(1));
				
				if(altar.handler.getStackInSlot(0).getCount() > 0 && altar.handler.getStackInSlot(1).getCount() < 1)
					player.inventory.addItemStackToInventory(altar.handler.getStackInSlot(0));
			}
			else if(player.getHeldItem(hand).getItem() == ModItems.WHITEWOOD_STAFF)
			{
				if(!altar.isCasting()) altar.startCasting(player);
				else altar.stopCasting();
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
		return new TileVoidaicAltar();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.ALTAR);
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		TileVoidaicAltar pedestal = (TileVoidaicAltar) world.getTileEntity(pos);
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
