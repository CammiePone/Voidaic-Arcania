package com.camellias.voidaicarcania.api.spells.items;

import com.camellias.voidaicarcania.api.spells.SpellComponent;
import com.camellias.voidaicarcania.common.items.ItemBaseGeneric;

public class ItemGlyphComponent extends ItemBaseGeneric implements SpellComponent
{
	private SpellComponent component;
	
	public ItemGlyphComponent(String name, SpellComponent spellComponent)
	{
		super(name);
		this.setTranslationKey(name);
		this.setRegistryName(name);
		this.component = spellComponent;
	}
	
	public SpellComponent getSpellComponent()
	{
		return this.component;
	}
}
