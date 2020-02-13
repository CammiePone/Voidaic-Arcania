package com.camellias.voidaicarcania.api.spells;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.registry.Registry;

import net.minecraft.util.ResourceLocation;

public interface SpellComponent
{
	@Nullable
	public static SpellComponent getSpellComponentByID(String registryName)
	{
		SpellComponent component = Registry.REGISTRY.getObject(new ResourceLocation(Reference.MODID, registryName));
		
		if(component == null)
		{
			try
			{
				return Registry.REGISTRY.getObjectById(Integer.parseInt(registryName));
			}
			catch(NumberFormatException e)
			{
				;
			}
		}
		
		return component;
	}
}
