package com.camellias.voidaicarcania.core.compat.altar;

import java.awt.Color;
import java.util.List;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipes;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;

public class AltarRecipes implements IRecipeWrapper
{
	private final List<ItemStack> inputs;
	private final int voidEssence;
	private final ItemStack output;
	
	public AltarRecipes(List<ItemStack> inputs, int voidEssence, ItemStack output)
	{
		this.inputs = inputs;
		this.voidEssence = voidEssence;
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
		minecraft.fontRenderer.drawString("VE: " + voidEssence, recipeWidth / 2, recipeHeight / 2, Color.black.getRGB());
		VoidaicAltarRecipes recipes = VoidaicAltarRecipes.INSTANCE;
	}
}