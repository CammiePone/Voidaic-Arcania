package com.camellias.voidaicarcania.util.jei;

import java.util.IllegalFormatException;

import com.camellias.voidaicarcania.blocks.blockaltar.ContainerAltar;
import com.camellias.voidaicarcania.blocks.blockaltar.GuiAltar;
import com.camellias.voidaicarcania.blocks.blockbotanyaltar.ContainerBotanyAltar;
import com.camellias.voidaicarcania.blocks.blockbotanyaltar.GuiBotanyAltar;
import com.camellias.voidaicarcania.blocks.blockmortalcentrifuge.ContainerMortalCentrifuge;
import com.camellias.voidaicarcania.blocks.blockmortalcentrifuge.GuiMortalCentrifuge;
import com.camellias.voidaicarcania.util.jei.altar.AltarRecipeCategory;
import com.camellias.voidaicarcania.util.jei.altar.AltarRecipeMaker;
import com.camellias.voidaicarcania.util.jei.botany.BotanyRecipeCategory;
import com.camellias.voidaicarcania.util.jei.botany.BotanyRecipeMaker;
import com.camellias.voidaicarcania.util.jei.mortalfurnace.MortalFurnaceRecipeCategory;
import com.camellias.voidaicarcania.util.jei.mortalfurnace.MortalFurnaceRecipeMaker;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
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
		registry.addRecipeCategories(new BotanyRecipeCategory(gui));
		registry.addRecipeCategories(new MortalFurnaceRecipeCategory(gui));
	}
	
	@Override
	public void register(IModRegistry registry)
	{
		final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
		final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
		
		registry.addRecipes(AltarRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.ALTAR);
		registry.addRecipeClickArea(GuiAltar.class, 109, 14, 24, 17, RecipeCategories.ALTAR);
		recipeTransfer.addRecipeTransferHandler(ContainerAltar.class, RecipeCategories.ALTAR, 0, 1, 3, 36);
		
		registry.addRecipes(BotanyRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.BOTANY);
		registry.addRecipeClickArea(GuiBotanyAltar.class, 79, 40, 24, 17, RecipeCategories.BOTANY);
		recipeTransfer.addRecipeTransferHandler(ContainerBotanyAltar.class, RecipeCategories.BOTANY, 0, 1, 3, 36);
		
		registry.addRecipes(MortalFurnaceRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.MORTAL);
		registry.addRecipeClickArea(GuiMortalCentrifuge.class, 64, 56, 46, 10, RecipeCategories.MORTAL);
		recipeTransfer.addRecipeTransferHandler(ContainerMortalCentrifuge.class, RecipeCategories.MORTAL, 0, 1, 3, 36);
	}
	
	public static String translateToLocal(String key)
	{
		if(I18n.canTranslate(key))
		{
			return I18n.translateToLocal(key);
		}
		
		else
		{
			return I18n.translateToFallback(key);
		}
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
