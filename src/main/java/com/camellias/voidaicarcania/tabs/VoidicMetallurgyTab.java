package com.camellias.voidaicarcania.tabs;

import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VoidicMetallurgyTab extends CreativeTabs 
{
	public VoidicMetallurgyTab(String label)
	{
		super("metaltab");
		this.setBackgroundImageName("voidic.png");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModBlocks.BLOCK_MORTAL_FURNACE);
	}
}
