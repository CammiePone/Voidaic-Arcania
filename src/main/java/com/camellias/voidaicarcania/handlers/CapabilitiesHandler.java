package com.camellias.voidaicarcania.handlers;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.capabilities.Corruption.CorruptionProvider;
import com.camellias.voidaicarcania.api.capabilities.Corruption.DefaultCorruptionCapability;
import com.camellias.voidaicarcania.api.capabilities.Corruption.ICorruption;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.DefaultEssenceCapability;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.EssenceProvider;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.IEssence;
import com.camellias.voidaicarcania.api.capabilities.Infused.DefaultInfusedCapability;
import com.camellias.voidaicarcania.api.capabilities.Infused.IInfused;
import com.camellias.voidaicarcania.api.capabilities.Infused.InfusedProvider;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilitiesHandler {

	@SubscribeEvent
	public void onAddCapabilites(AttachCapabilitiesEvent<Entity> event)
	{
		if((event.getObject() instanceof EntityLivingBase))
		{
			final EntityLivingBase entity = (EntityLivingBase) event.getObject();

			if(!entity.hasCapability(InfusedProvider.infusedCapability, null))
			{
				boolean isInfused = false;
				IInfused infused = new DefaultInfusedCapability(isInfused);
				event.addCapability(new ResourceLocation(Reference.MODID, "Infused"), new InfusedProvider(infused));
			}

			if(!entity.hasCapability(CorruptionProvider.corruptionCapability, null))
			{
				int amount = 0;
				boolean corrupted = false;
				ICorruption corruption = new DefaultCorruptionCapability(amount, corrupted);
				event.addCapability(new ResourceLocation(Reference.MODID, "Corruption"), new CorruptionProvider(corruption));
			}
		}
	}

	@SubscribeEvent
	public void onAddItemCapabilites(AttachCapabilitiesEvent<ItemStack> event)
	{
		if((event.getObject() != null) && !event.getObject().hasCapability(EssenceProvider.essenceCapability, null))
		{
			ItemStack stack = event.getObject();
			int essence = 0;
			boolean effect = false;
			IEssence itemEssence = new DefaultEssenceCapability(essence, effect);
			event.addCapability(new ResourceLocation(Reference.MODID, "Essence"), new EssenceProvider(itemEssence));

		}
	}
}
