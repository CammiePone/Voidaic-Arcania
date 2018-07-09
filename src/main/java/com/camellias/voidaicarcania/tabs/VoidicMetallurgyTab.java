package com.camellias.voidaicarcania.tabs;

import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VoidicMetallurgyTab extends CreativeTabs 
{
	public VoidicMetallurgyTab(String label)
	{
		super("voidictab");
		this.setBackgroundImageName("voidic.png");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModItems.INFUSED_INGOT);
	}
}
