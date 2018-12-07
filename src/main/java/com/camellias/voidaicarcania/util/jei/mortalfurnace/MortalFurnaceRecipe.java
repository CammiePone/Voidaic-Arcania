package com.camellias.voidaicarcania.util.jei.mortalfurnace;

import java.util.List;

import com.camellias.voidaicarcania.common.blocks.machines.blockmortalcentrifuge.MortalCentrifugeRecipes;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class MortalFurnaceRecipe implements IRecipeWrapper
{
	private final List<ItemStack> inputs;
	private final ItemStack output;
	
	public MortalFurnaceRecipe(List<ItemStack> inputs, ItemStack output)
	{
		this.inputs = inputs;
		this.output = output;
	}
	
	@Override
	public void getIngredients(IIngredients ingredients)
	{
		ingredients.setInputs(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
	{
		MortalCentrifugeRecipes recipes = MortalCentrifugeRecipes.getInstance();
	}
}
