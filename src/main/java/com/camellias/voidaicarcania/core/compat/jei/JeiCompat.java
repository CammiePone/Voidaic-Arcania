package com.camellias.voidaicarcania.core.compat.jei;

import java.util.IllegalFormatException;

import com.camellias.voidaicarcania.core.compat.jei.altar.AltarRecipeCategory;
import com.camellias.voidaicarcania.core.compat.jei.altar.AltarRecipeMaker;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

@JEIPlugin
public class JeiCompat implements IModPlugin
{
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry)
	{
		final IJeiHelpers helpers = registry.getJeiHelpers();
		final IGuiHelper gui = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new AltarRecipeCategory(gui));
	}
	
	@Override
	public void register(IModRegistry registry)
	{
		final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
		final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
		
		registry.addRecipes(AltarRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.ALTAR);
	}
	
	public static String translateToLocal(String key)
	{
		return new TextComponentTranslation(key).getFormattedText();
	}
	
	public static String translateToLocalFormatted(String key, Object... format)
	{
		String string = translateToLocal(key);
		
		try
		{
			return String.format(string, format);
		}
		catch(IllegalFormatException exception)
		{
			return "FormatError: " + string;
		}
	}
}