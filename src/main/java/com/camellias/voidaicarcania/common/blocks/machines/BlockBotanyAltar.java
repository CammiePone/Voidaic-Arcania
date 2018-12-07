package com.camellias.voidaicarcania.common.blocks.machines;

import java.util.Random;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.common.blocks.machines.blockaltar.TileEntityAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockbotanyaltar.TileEntityBotanyAltar;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;
import com.camellias.voidaicarcania.util.handlers.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBotanyAltar extends Block implements IHasModel
{
	public BlockBotanyAltar(String name, Material material) 
	{
		super(material);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public static void setState(boolean active, World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		TileEntity tileEntity = world.getTileEntity(pos);
		
		if(tileEntity != null)
		{
			tileEntity.validate();
			world.setTileEntity(pos, tileEntity);
		}
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.BLOCK_BOTANY_ALTAR);
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		TileEntityBotanyAltar tileEntity = (TileEntityBotanyAltar)world.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(world, pos, tileEntity);
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public ItemStack getItem(World world, BlockPos pos, IBlockState state)
	{
		return new ItemStack(ModBlocks.BLOCK_BOTANY_ALTAR);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, 
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			player.openGui(Main.instance, ConfigHandler.GUI_BOTANY_ALTAR, world, pos.getX(), pos.getY(), pos.getZ());
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
		return new TileEntityBotanyAltar();
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
