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
	/*public static SoundEvent VOID_THEME;
	
	private static int size = 0;
	
	public static void init()
	{
		size = SoundEvent.REGISTRY.getKeys().size();
		
		//Sound Events
		VOID_THEME = register("voidic.ambient");
	}
	
	@SubscribeEvent
	public static SoundEvent register(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent e = new SoundEvent(location);
		
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		
		System.out.println("Sound Registered: " + name);
		
		return e;
	}*/
	
	/*public static final SoundEvent VOIDIC_AMBIENT = registerSound("voidic.ambient");
	
	private static SoundEvent registerSound(String soundName) 
	{
		final ResourceLocation soundID = new ResourceLocation(Reference.MODID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}
	
	@Mod.EventBusSubscriber(modid = Reference.MODID)
	public static class RegistrationHandler
	{
		@SubscribeEvent
		public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event)
		{
			event.getRegistry().registerAll(VOIDIC_AMBIENT);
			
			System.out.println("Sounds Registered");
		}
	}
	
}*/

	public static SoundEvent VOID_ENTRY_AMBIENT;
	
	public static void registerSounds() 
	{
		VOID_ENTRY_AMBIENT = registerSound("voidic.ambient");
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
