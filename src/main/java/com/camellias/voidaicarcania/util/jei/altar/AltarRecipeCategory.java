package com.camellias.voidaicarcania.util.jei.altar;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.util.jei.RecipeCategories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;

public class AltarRecipeCategory extends AbstractAltarRecipeCategory<AltarRecipe>
{
	private final IDrawable background;
	private final String name;
	
	public AltarRecipeCategory(IGuiHelper helper)
	{
		super(helper);
		background = helper.createDrawable(TEXTURES, 4, 4, 169, 78);
		name = "Altar";
	}
	
	@Override
	public IDrawable getBackground()
	{
		return background;
	}
	
	@Override
	public void drawExtras(Minecraft minecraft)
	{
		animatedFlame.draw(minecraft, 64, 42);
		animatedArrow.draw(minecraft, 105, 10);
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
	public String getUid()
	{
		return RecipeCategories.ALTAR;
	}
	
	public void setRecipe(IRecipeLayout recipeLayout, AltarRecipe recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 64, 9);
		stacks.init(input2, true, 86, 9);
		stacks.init(output, false, 136, 9);
		stacks.set(ingredients);
	};
}
