package com.camellias.voidaicarcania.tabs;

import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VoidicAlchemyTab extends CreativeTabs 
{
	public VoidicAlchemyTab(String label)
	{
		super("alchemytab");
		this.setBackgroundImageName("voidic.png");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModBlocks.BLOCK_BOTANY_ALTAR);
	}
}
