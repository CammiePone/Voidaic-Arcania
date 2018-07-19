package com.camellias.voidaicarcania.util.jei.mortalfurnace;

import com.camellias.voidaicarcania.Reference;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractMortalFurnaceRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T>
{
	protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/gui_mortal_furnace.png");
	
	protected static int input1 = 0;
	protected static int input2 = 1;
	protected static int fuel = 2;
	protected static int output = 3;
	
	protected final IDrawableAnimated animatedArrow;
	
	public AbstractMortalFurnaceRecipeCategory(IGuiHelper helper)
	{
		IDrawableStatic staticArrow = helper.createDrawable(TEXTURES, 176, 3, 46, 28);
		animatedArrow = helper.createAnimatedDrawable(staticArrow, 40, IDrawableAnimated.StartDirection.TOP, false);
	}
}
