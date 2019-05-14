package com.camellias.voidaicarcania.common.blocks;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.init.ModCreativeTabs;
import com.camellias.voidaicarcania.core.init.ModItems;
import com.camellias.voidaicarcania.core.util.IHasModel;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBaseStairs extends BlockStairs implements IHasModel
{
	public BlockBaseStairs(IBlockState state, String name) 
	{
		super(state);
		this.setTranslationKey(Reference.MODID + "." + name);
		this.setRegistryName(name);
		this.useNeighborBrightness = true;
		this.setCreativeTab(ModCreativeTabs.VA_TAB_MAIN);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
