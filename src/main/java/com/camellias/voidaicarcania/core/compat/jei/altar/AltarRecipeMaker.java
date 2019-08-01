package com.camellias.voidaicarcania.core.compat.jei.altar;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipeHelper;
import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipes;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class AltarRecipeMaker
{
	public static List<AltarRecipes> getRecipes(IJeiHelpers helpers)
	{
		IStackHelper stackhelper = helpers.getStackHelper();
		VoidaicAltarRecipes instance = VoidaicAltarRecipes.INSTANCE;
		Collection<VoidaicAltarRecipeHelper> recipes = instance.getRecipes();
		List<AltarRecipes> jeiRecipes = Lists.newArrayList();
		
		for(VoidaicAltarRecipeHelper helper : instance.getRecipes())
		{
			ItemStack input1 = helper.ingredient1;
			ItemStack input2 = helper.ingredient2;
			ItemStack input3 = helper.ingredient3;
			int voidEssence = helper.voidEssenceCost;
			ItemStack output = helper.result;
			
			List<ItemStack> inputs = Lists.newArrayList(input1, input2, input3);
			AltarRecipes recipe = new AltarRecipes(inputs, voidEssence, output);
			jeiRecipes.add(recipe);
		}
		
		return jeiRecipes;
	}
}