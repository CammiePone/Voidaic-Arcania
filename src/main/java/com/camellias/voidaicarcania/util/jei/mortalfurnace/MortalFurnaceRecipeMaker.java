package com.camellias.voidaicarcania.util.jei.mortalfurnace;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.camellias.voidaicarcania.blocks.blockmortalcentrifuge.MortalCentrifugeRecipes;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class MortalFurnaceRecipeMaker
{
	public static List<MortalFurnaceRecipe> getRecipes(IJeiHelpers helpers)
	{
		IStackHelper stackhelper = helpers.getStackHelper();
		MortalCentrifugeRecipes instance = MortalCentrifugeRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		List<MortalFurnaceRecipe> jeiRecipes = Lists.newArrayList();
		
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet())
		{
			for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
			{
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getValue();
				
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				MortalFurnaceRecipe recipe = new MortalFurnaceRecipe(inputs, output);
				jeiRecipes.add(recipe);
			}
		}
		
		return jeiRecipes;
	}
}
