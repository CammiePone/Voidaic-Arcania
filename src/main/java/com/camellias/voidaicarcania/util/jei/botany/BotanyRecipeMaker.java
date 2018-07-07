package com.camellias.voidaicarcania.util.jei.botany;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.camellias.voidaicarcania.blocks.blockbotanyaltar.BotanyAltarRecipes;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class BotanyRecipeMaker
{
	public static List<BotanyRecipe> getRecipes(IJeiHelpers helpers)
	{
		IStackHelper stackhelper = helpers.getStackHelper();
		BotanyAltarRecipes instance = BotanyAltarRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		List<BotanyRecipe> jeiRecipes = Lists.newArrayList();
		
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet())
		{
			for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
			{
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getValue();
				
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				BotanyRecipe recipe = new BotanyRecipe(inputs, output);
				jeiRecipes.add(recipe);
			}
		}
		
		return jeiRecipes;
	}
}
