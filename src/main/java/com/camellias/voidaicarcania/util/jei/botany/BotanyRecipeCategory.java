package com.camellias.voidaicarcania.util.jei.botany;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.util.jei.RecipeCategories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;

public class BotanyRecipeCategory extends AbstractBotanyRecipeCategory<BotanyRecipe>
{
	private final IDrawable background;
	private final String name;
	
	public BotanyRecipeCategory(IGuiHelper helper)
	{
		super(helper);
		
		this.background = helper.createDrawable(TEXTURES, 4, 4, 170, 78);
		this.name = "Botany Altar";
	}
	
	@Override
	public IDrawable getBackground()
	{
		return background;
	}
	
	@Override
	public String getUid()
	{
		return RecipeCategories.BOTANY;
	}
	
	@Override
	public String getTitle()
	{
		return name;
	}
	
	@Override
	public String getModName()
	{
		return Reference.NAME;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, BotanyRecipe recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 21, 20);
		stacks.init(input2, true, 51, 20);
		stacks.init(output, false, 109, 34);
		stacks.set(ingredients);
	};
}
