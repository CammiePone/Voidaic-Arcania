package com.camellias.voidaicarcania.util.jei.botany;

import com.camellias.voidaicarcania.Reference;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractBotanyRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T>
{
	protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/gui_botany.png");
	
	protected static int input1 = 0;
	protected static int input2 = 1;
	protected static int fuel = 2;
	protected static int output = 3;
	
	public AbstractBotanyRecipeCategory(IGuiHelper helper)
	{
		
	}
}
