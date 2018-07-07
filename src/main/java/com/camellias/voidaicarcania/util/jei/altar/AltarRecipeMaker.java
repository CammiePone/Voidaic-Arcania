package com.camellias.voidaicarcania.util.jei.altar;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.camellias.voidaicarcania.blocks.blockaltar.AltarRecipes;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class AltarRecipeMaker
{
	public static List<AltarRecipe> getRecipes(IJeiHelpers helpers)
	{
		IStackHelper stackhelper = helpers.getStackHelper();
		AltarRecipes instance = AltarRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		List<AltarRecipe> jeiRecipes = Lists.newArrayList();
		
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet())
		{
			for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
			{
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getValue();
				
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				AltarRecipe recipe = new AltarRecipe(inputs, output);
				jeiRecipes.add(recipe);
			}
		}
		
		return jeiRecipes;
	}
}
