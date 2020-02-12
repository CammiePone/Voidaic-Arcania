package com.camellias.voidaicarcania.api.registry;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.spells.SpellComponent;
import com.camellias.voidaicarcania.common.spells.foci.FocusAOE;
import com.camellias.voidaicarcania.common.spells.foci.FocusBeam;
import com.camellias.voidaicarcania.common.spells.foci.FocusChain;
import com.camellias.voidaicarcania.common.spells.foci.FocusLob;
import com.camellias.voidaicarcania.common.spells.foci.FocusProjectile;
import com.camellias.voidaicarcania.common.spells.foci.FocusTouch;
import com.camellias.voidaicarcania.common.spells.foci.FocusTrap;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;

public class Registry
{
	private static final RegistryNamespaced<ResourceLocation, SpellComponent> REGISTRY = new RegistryNamespaced<ResourceLocation, SpellComponent>();
	private static int id = 0;
	
	/**
	 * Use a Mixin to inject into the RETURN of this method when registering classes that extend {@link com.camellias.voidaicarcania.api.spells.FocusType}.
	 */
	public static void registerFocusTypes()
	{
		register("beam_focus", new FocusBeam());
		register("projectile_focus", new FocusProjectile());
		register("touch_focus", new FocusTouch());
		register("chain_focus", new FocusChain());
		register("trap_focus", new FocusTrap());
		register("aoe_focus", new FocusAOE());
		register("lob_focus", new FocusLob());
	}
	
	/**
	 * Use a Mixin to inject into the RETURN of this method when registering classes that extend {@link com.camellias.voidaicarcania.api.spells.SpellType}.
	 */
	public static void registerSpellTypes()
	{
		
	}
	
	/**
	 * Use a Mixin to inject into the RETURN of this method when registering classes that extend {@link com.camellias.voidaicarcania.api.spells.ModifierType}.
	 */
	public static void registerModifierTypes()
	{
		
	}
	
	/**
	 * Do not use this method, ever! Use {@link #registerSpellComponents()}
	 * @param key
	 * @param value
	 */
	private static void register(String key, SpellComponent value)
	{
		ResourceLocation resource = new ResourceLocation(Reference.MODID, key);
		
		REGISTRY.register(id, resource, value);
		Main.log("Setting " + resource + " to ID: " + id);
		id++;
	}
}
