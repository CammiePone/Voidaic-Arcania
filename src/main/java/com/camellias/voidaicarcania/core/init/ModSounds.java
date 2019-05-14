package com.camellias.voidaicarcania.core.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModSounds
{
	public static final List<SoundEvent> SOUNDS = new ArrayList<>();
	
	public static final SoundEvent VOID_WRAITH_IDLE = createSoundEvent("void_wraith_idle");
	
	private static final SoundEvent createSoundEvent(String name)
	{
		ResourceLocation id = new ResourceLocation(Reference.MODID, name);
		SoundEvent event = new SoundEvent(id).setRegistryName(id);
		
		SOUNDS.add(event);
		
		return event;
	}
} 
