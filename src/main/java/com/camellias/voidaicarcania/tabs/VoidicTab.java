package com.camellias.voidaicarcania.tabs;

import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VoidicTab extends CreativeTabs 
{
	public VoidicTab(String label)
	{
		super("voidictab");
		this.setBackgroundImageName("voidic.png");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModItems.VOID_BOTTLE);
	}
}
