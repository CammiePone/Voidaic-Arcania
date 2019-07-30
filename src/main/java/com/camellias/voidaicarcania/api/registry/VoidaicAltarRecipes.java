package com.camellias.voidaicarcania.api.registry;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

public class VoidaicAltarRecipes
{
	private final HashMap<Entry<ItemStack[], Integer>, ItemStack> recipes = new HashMap<>();
	private int voidEssenceCost;
	public static final VoidaicAltarRecipes INSTANCE = new VoidaicAltarRecipes();
	
	/**
	 * Used to add recipes to the Voidaic Altar.
	 * 
	 * @param stack1 - The first ingredient.
	 * @param stack2 - The second ingredient.
	 * @param stack3 - The third ingredient.
	 * @param stack4 - The fourth ingredient.
	 * @param voidEssenceCost - How much Void Essence the recipe requires. Has to be higher than 0, else the recipe won't work.
	 * @param result - The resulting ItemStack of the recipe.
	 * @return
	 */
	public HashMap<Entry<ItemStack[], Integer>, ItemStack> addRecipe(ItemStack stack1, 
		ItemStack stack2, ItemStack stack3, ItemStack stack4, int voidEssenceCost, ItemStack result)
	{
		ItemStack[] ingredients = {stack1, stack2, stack3, stack4};
		SimpleEntry recipeCost = new SimpleEntry(ingredients, voidEssenceCost);
		
		this.voidEssenceCost = voidEssenceCost;
		recipes.put(recipeCost, result);
		
		return recipes;
	}
	
	public ItemStack getRecipeResult(ItemStack stack1, ItemStack stack2, ItemStack stack3, ItemStack stack4, int voidEssenceCost)
	{
		ItemStack[] ingredients = {stack1, stack2, stack3, stack4};
		SimpleEntry recipeCost = new SimpleEntry(ingredients, voidEssenceCost);
		
		return recipes.get(recipeCost);
	}
	
	public int getVoidEssenceCost()
	{
		return voidEssenceCost;
	}
	
	public boolean isCraftingItemOrSpell(boolean hasSpellPaper)
	{
		return hasSpellPaper;
	}
	
	public HashMap<Entry<ItemStack[], Integer>, ItemStack> getRecipes()
	{
		return recipes;
	}
}
