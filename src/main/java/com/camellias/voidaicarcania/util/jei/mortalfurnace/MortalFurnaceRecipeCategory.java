package com.camellias.voidaicarcania.util.jei.mortalfurnace;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.util.jei.RecipeCategories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;

public class MortalFurnaceRecipeCategory extends AbstractMortalFurnaceRecipeCategory<MortalFurnaceRecipe>
{
	private final IDrawable background;
	private final String name;
	
	public MortalFurnaceRecipeCategory(IGuiHelper helper)
	{
		super(helper);
		
		this.background = helper.createDrawable(TEXTURES, 4, 4, 168, 100);
		this.name = "Mortal Furnace";
	}
	
	@Override
	public IDrawable getBackground()
	{
		return background;
	}
	
	@Override
	public void drawExtras(Minecraft minecraft)
	{
		animatedArrow.draw(minecraft, 60, 36);
	}
	
	@Override
	public String getUid()
	{
		return RecipeCategories.MORTAL;
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
	public void setRecipe(IRecipeLayout recipeLayout, MortalFurnaceRecipe recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 53, 18);
		stacks.init(input2, true, 95, 18);
		stacks.init(output, false, 74, 67);
		stacks.set(ingredients);
	};
}
