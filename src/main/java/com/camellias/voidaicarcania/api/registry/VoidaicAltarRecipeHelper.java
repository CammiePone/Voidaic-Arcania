package com.camellias.voidaicarcania.api.registry;

import net.minecraft.item.ItemStack;

public class VoidaicAltarRecipeHelper
{
	public ItemStack ingredient1;
	public ItemStack ingredient2;
	public ItemStack ingredient3;
	
	public Integer voidEssenceCost;
	public ItemStack result;
	
	public VoidaicAltarRecipeHelper(ItemStack input1, ItemStack input2, ItemStack input3, Integer voidEssenceCost, ItemStack result)
	{
		this.ingredient1 = input1;
		this.ingredient2 = input2;
		this.ingredient3 = input3;
		
		this.voidEssenceCost = voidEssenceCost;
		this.result = result;
	}
}