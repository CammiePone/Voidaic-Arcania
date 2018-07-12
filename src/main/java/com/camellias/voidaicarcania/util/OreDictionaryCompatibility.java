package com.camellias.voidaicarcania.util;

import com.camellias.voidaicarcania.init.ModItems;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryCompatibility 
{
	public static void registerOres()
	{
		OreDictionary.registerOre("itemQuicksilver", ModItems.MERCURY);
		OreDictionary.registerOre("itemMercury", ModItems.MERCURY);
	}
}
