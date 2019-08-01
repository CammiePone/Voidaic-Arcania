package com.camellias.voidaicarcania.core.compat.jei.altar;

import com.camellias.voidaicarcania.Reference;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractAltarRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T>
{
	protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/jei_voidaic_altar.png");
	
	protected static final int input1 = 0;
	protected static final int input2 = 1;
	protected static final int input3 = 2;
	protected static final int output = 3;
	
	public AbstractAltarRecipeCategory(IGuiHelper helper)
	{
		
	}
}