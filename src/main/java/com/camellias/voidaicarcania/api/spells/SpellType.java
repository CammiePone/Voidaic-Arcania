package com.camellias.voidaicarcania.api.spells;

public class SpellType
{
	protected String name;
	
	public String getName()
	{
		return name;
	}
	
	public String setName(String modid, String spellName)
	{
		name = modid + ":" + spellName;
		return name;
	}
}
