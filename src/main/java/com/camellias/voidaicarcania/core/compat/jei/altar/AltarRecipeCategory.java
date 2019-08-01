package com.camellias.voidaicarcania.core.compat.jei.altar;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.core.compat.jei.RecipeCategories;
import com.camellias.voidaicarcania.core.init.ModBlocks;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class AltarRecipeCategory extends AbstractAltarRecipeCategory<AltarRecipes>
{
	private final IDrawable background;
	private final String name;
	private final ItemStack renderStack = new ItemStack(ModBlocks.ALTAR);
	
	public AltarRecipeCategory(IGuiHelper helper)
	{
		super(helper);
		background = helper.createDrawable(TEXTURES, 4, 4, 168, 168);
		name = I18n.format(Reference.MODID + ".voidaicaltar.recipes");
	}
	
	@Override
	public IDrawable getBackground()
	{
		return background;
	}
	
	@Override
	public IDrawable getIcon()
	{
		return null;
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
	
	public void setRecipe(IRecipeLayout recipeLayout, AltarRecipes recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 44, 85);
		stacks.init(input2, true, 75, 38);
		stacks.init(input3, true, 106, 85);
		
		stacks.init(output, false, 75, 74);
		stacks.set(0, renderStack);
		stacks.set(ingredients);
	};
}