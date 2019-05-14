package com.camellias.voidaicarcania.common.creativetabs;

import com.camellias.voidaicarcania.core.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class VACreativeTabMain extends CreativeTabs
{
	public VACreativeTabMain(String name)
	{
		super(name);
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ModItems.VOID_RESONATOR);
	}
}
