package com.camellias.voidaicarcania.common.blocks.plants.trees;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.init.ModItems;
import com.camellias.voidaicarcania.core.util.IHasModel;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockWhitewoodStairs extends BlockStairs implements IHasModel
{
	public BlockWhitewoodStairs(IBlockState state, String name) 
	{
		super(state);
		
		this.setTranslationKey(name);
		this.setHardness(2.0F);
		this.setRegistryName(name);
		this.useNeighborBrightness = true;
		this.setSoundType(SoundType.WOOD);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
