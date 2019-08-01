package com.camellias.voidaicarcania.core.compat.crafttweaker;

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
	public static void addRecipe(IIngredient input1, IIngredient input2, IIngredient input3, int voidEssenceCost, IIngredient output)
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
	public static void removeRecipe(IIngredient input1, IIngredient input2, IIngredient input3)
	{
		for(IItemStack istack1 : input1.getItems())
		{
			for(IItemStack istack2 : input2.getItems())
			{
				for(IItemStack istack3 : input3.getItems())
				{
					ItemStack stack1 = ((ItemStack) istack1.getInternal()) != null ?
							((ItemStack) istack1.getInternal()) :
							((ItemStack) istack2.getInternal()) != null ?
							((ItemStack) istack2.getInternal()) :
							((ItemStack) istack3.getInternal()) != null ?
							((ItemStack) istack3.getInternal()) : new ItemStack(Items.AIR);
					ItemStack stack2 = ((ItemStack) istack1.getInternal()) != null ?
							((ItemStack) istack1.getInternal()) :
							((ItemStack) istack2.getInternal()) != null ?
							((ItemStack) istack2.getInternal()) :
							((ItemStack) istack3.getInternal()) != null ?
							((ItemStack) istack3.getInternal()) : new ItemStack(Items.AIR);
					ItemStack stack3 = ((ItemStack) istack1.getInternal()) != null ?
							((ItemStack) istack1.getInternal()) :
							((ItemStack) istack2.getInternal()) != null ?
							((ItemStack) istack2.getInternal()) :
							((ItemStack) istack3.getInternal()) != null ?
							((ItemStack) istack3.getInternal()) : new ItemStack(Items.AIR);
					VoidaicAltarRecipes.INSTANCE.removeItemRecipe(stack1, stack2, stack3);
				}
			}
		}
	}
}
