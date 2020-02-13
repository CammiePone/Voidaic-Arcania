package com.camellias.voidaicarcania.api.registry;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.spells.SpellComponent;
import com.camellias.voidaicarcania.common.spells.foci.FocusAOE;
import com.camellias.voidaicarcania.common.spells.foci.FocusBeam;
import com.camellias.voidaicarcania.common.spells.foci.FocusChain;
import com.camellias.voidaicarcania.common.spells.foci.FocusLob;
import com.camellias.voidaicarcania.common.spells.foci.FocusProjectile;
import com.camellias.voidaicarcania.common.spells.foci.FocusSelf;
import com.camellias.voidaicarcania.common.spells.foci.FocusTouch;
import com.camellias.voidaicarcania.common.spells.foci.FocusTrap;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierAir;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierDamage;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierDuration;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierEarth;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierFire;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierRange;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierSize;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierSplit;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierVoid;
import com.camellias.voidaicarcania.common.spells.modifiers.ModifierWater;
import com.camellias.voidaicarcania.common.spells.spells.SpellBreak;
import com.camellias.voidaicarcania.common.spells.spells.SpellCyclone;
import com.camellias.voidaicarcania.common.spells.spells.SpellDamage;
import com.camellias.voidaicarcania.common.spells.spells.SpellElement;
import com.camellias.voidaicarcania.common.spells.spells.SpellElemental;
import com.camellias.voidaicarcania.common.spells.spells.SpellGrapple;
import com.camellias.voidaicarcania.common.spells.spells.SpellJammer;
import com.camellias.voidaicarcania.common.spells.spells.SpellRend;
import com.camellias.voidaicarcania.common.spells.spells.SpellResistance;
import com.camellias.voidaicarcania.common.spells.spells.SpellShield;
import com.camellias.voidaicarcania.common.spells.spells.SpellSwap;
import com.camellias.voidaicarcania.common.spells.spells.SpellTelekinesis;
import com.camellias.voidaicarcania.common.spells.spells.SpellTeleport;
import com.camellias.voidaicarcania.common.spells.spells.SpellTemporal;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;

public class Registry
{
	public static final RegistryNamespaced<ResourceLocation, SpellComponent> REGISTRY = new RegistryNamespaced<ResourceLocation, SpellComponent>();
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
		register("self_focus", new FocusSelf());
	}
	
	/**
	 * Use a Mixin to inject into the RETURN of this method when registering classes that extend {@link com.camellias.voidaicarcania.api.spells.SpellType}.
	 */
	public static void registerSpellTypes()
	{
		register("damage_spell", new SpellDamage());
		register("break_spell", new SpellBreak());
		register("shield_spell", new SpellShield());
		register("spell_grapple", new SpellGrapple());
		register("teleport_spell", new SpellTeleport());
		register("swap_spell", new SpellSwap());
		register("conjure_element_spell", new SpellElement());
		register("rend_spell", new SpellRend());
		register("telekinesis_spell", new SpellTelekinesis());
		register("resistance_spell", new SpellResistance());
		register("jammer_spell", new SpellJammer());
		register("summon_elemental_spell", new SpellElemental());
		register("cyclone_spell", new SpellCyclone());
		register("temporal_spell", new SpellTemporal());
	}
	
	/**
	 * Use a Mixin to inject into the RETURN of this method when registering classes that extend {@link com.camellias.voidaicarcania.api.spells.ModifierType}.
	 */
	public static void registerModifierTypes()
	{
		register("damage_modifier", new ModifierDamage());
		register("duration_modifier", new ModifierDuration());
		register("range_modifier", new ModifierRange());
		register("size_modifier", new ModifierSize());
		register("split_modifier", new ModifierSplit());
		register("water_elemental_modifier", new ModifierWater());
		register("earth_elemental_modifier", new ModifierEarth());
		register("fire_elemental_modifier", new ModifierFire());
		register("air_elemental_modifier", new ModifierAir());
		register("void_elemental_modifier", new ModifierVoid());
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
