package com.camellias.voidaicarcania.core.compat.crafttweaker;

import com.camellias.voidaicarcania.api.registry.VoidEssenceList;
import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipeHelper;
import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipes;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.voidaicarcania.CraftTweakerCompat")
public class CraftTweakerCompat
{
	@ZenMethod
	public static void addItemAltarRecipe(IIngredient input1, IIngredient input2, IIngredient input3, int voidEssenceCost, IIngredient output)
	{
		for(IItemStack istack1 : input1.getItems())
		{
			for(IItemStack istack2 : input2.getItems())
			{
				for(IItemStack istack3 : input3.getItems())
				{
					for(IItemStack iresult : output.getItems())
					{
						ItemStack stack1 = (ItemStack) istack1.getInternal();
						ItemStack stack2 = (ItemStack) istack2.getInternal();
						ItemStack stack3 = (ItemStack) istack3.getInternal();
						ItemStack result = (ItemStack) iresult.getInternal();
						VoidaicAltarRecipes.INSTANCE.addItemRecipe(stack1, stack2, stack3, voidEssenceCost, result);
					}
				}
			}
		}
	}
	
	@ZenMethod
	public static void removeItemAltarRecipe(IIngredient input1, IIngredient input2, IIngredient input3, int voidEssenceCost, IIngredient output)
	{
		for(IItemStack istack1 : input1.getItems())
		{
			for(IItemStack istack2 : input2.getItems())
			{
				for(IItemStack istack3 : input3.getItems())
				{
					for(IItemStack iresult : output.getItems())
					{
						ItemStack stack1 = (ItemStack) istack1.getInternal();
						ItemStack stack2 = (ItemStack) istack2.getInternal();
						ItemStack stack3 = (ItemStack) istack3.getInternal();
						ItemStack result = (ItemStack) iresult.getInternal();
						VoidaicAltarRecipeHelper abc = VoidaicAltarRecipes.INSTANCE.getRecipe(stack1, stack2, stack3);
						VoidaicAltarRecipeHelper acb = VoidaicAltarRecipes.INSTANCE.getRecipe(stack1, stack3, stack2);
						VoidaicAltarRecipeHelper bca = VoidaicAltarRecipes.INSTANCE.getRecipe(stack2, stack3, stack1);
						VoidaicAltarRecipeHelper bac = VoidaicAltarRecipes.INSTANCE.getRecipe(stack2, stack1, stack3);
						VoidaicAltarRecipeHelper cab = VoidaicAltarRecipes.INSTANCE.getRecipe(stack3, stack1, stack2);
						VoidaicAltarRecipeHelper cba = VoidaicAltarRecipes.INSTANCE.getRecipe(stack3, stack2, stack1);
						
						VoidaicAltarRecipeHelper recipe = abc != null ? abc : acb != null ? acb :
								bca != null ? bca : bac != null ? bac :
										cab != null ? cab : cba;
						
						VoidaicAltarRecipes.INSTANCE.removeItemRecipe(recipe.ingredient1, recipe.ingredient2, recipe.ingredient3, voidEssenceCost, result);
					}
				}
			}
		}
	}
	
	@ZenMethod
	public static void addEssenceToItem(IIngredient input, int essence)
	{
		for(IItemStack istack : input.getItems())
		{
			ItemStack stack = (ItemStack) istack.getInternal();
			VoidEssenceList.addToList(stack, essence);
		}
	}
}
