package com.camellias.voidaicarcania.util.infostorage;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerPropertyEvents
{
	public static final PlayerPropertyEvents INSTANCE = new PlayerPropertyEvents();
	
	@SubscribeEvent
	public void onEntityConstructing(AttachCapabilitiesEvent<Entity> event)
	{
		ResourceLocation void_essence = new ResourceLocation(Reference.MODID, "Essence");
		ResourceLocation void_corruption = new ResourceLocation(Reference.MODID, "Corruption");
		
		if(event.getObject() instanceof EntityPlayer)
		{
			if(!event.getObject().hasCapability(PlayerProperties.VOID_CORRUPTION, null))
			{
				event.addCapability(void_corruption, new PropertiesDispatcher());
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerCloned(PlayerEvent.Clone event)
	{
		if(event.isWasDeath())
		{
			if(event.getOriginal().hasCapability(PlayerProperties.VOID_CORRUPTION, null))
			{
				VoidCorruptionCapability oldStore = event.getOriginal().getCapability(PlayerProperties.VOID_CORRUPTION, null);
				VoidCorruptionCapability newStore = PlayerProperties.getPlayerCorruption(event.getEntityPlayer());
				
				newStore.copyFrom(oldStore);
			}
		}
	}
}
