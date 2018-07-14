package com.camellias.voidaicarcania.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmelting 
{
	public static void init()
	{
		GameRegistry.addSmelting(ModBlocks.BLOCK_CINNIBAR_ORE, new ItemStack(ModItems.CINNIBAR), 1.5F);
		GameRegistry.addSmelting(ModBlocks.BLOCK_BORNITE_ORE, new ItemStack(ModItems.ENARGITE), 2.0F);		
	}
}
