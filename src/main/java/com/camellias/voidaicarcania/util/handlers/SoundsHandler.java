package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class SoundsHandler
{
	public static SoundEvent VOID_THEME;
	public static SoundEvent VOID_REMNANTS;
	
	public static void registerSounds()
	{
		VOID_THEME = registerSound("voiddim.entry");
		VOID_REMNANTS = registerSound("voiddim.ambient");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		
		ForgeRegistries.SOUND_EVENTS.register(event);
		
		return event;
	}
} 
