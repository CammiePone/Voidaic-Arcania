package com.camellias.voidaicarcania.handlers;

import java.util.List;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.VoidEssenceList;
import com.camellias.voidaicarcania.api.capabilities.Corruption.CorruptionProvider;
import com.camellias.voidaicarcania.api.capabilities.Corruption.DefaultCorruptionCapability;
import com.camellias.voidaicarcania.api.capabilities.Corruption.ICorruption;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.DefaultEssenceCapability;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.EssenceProvider;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.IEssence;
import com.camellias.voidaicarcania.api.capabilities.Infused.DefaultInfusedCapability;
import com.camellias.voidaicarcania.api.capabilities.Infused.IInfused;
import com.camellias.voidaicarcania.api.capabilities.Infused.InfusedProvider;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CapabilitiesHandler
{
	/**
	 * Something here broke, and is spamming console with something that's returning null when referring to the player.
	 */

	@SubscribeEvent
	public void onAddEntityCapabilites(AttachCapabilitiesEvent<Entity> event)
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
		if(VoidEssenceList.LIST.containsKey(event.getObject()))
		{
			if(!event.getObject().hasCapability(EssenceProvider.essenceCapability, null))
			{
				ItemStack stack = event.getObject();
				int essence = VoidEssenceList.LIST.get(stack);
				boolean effect = false;
				IEssence itemEssence = new DefaultEssenceCapability(essence, effect);
				event.addCapability(new ResourceLocation(Reference.MODID, "Essence"), new EssenceProvider(itemEssence));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onTooltipRender(ItemTooltipEvent event)
	{
		if(event.getItemStack().hasCapability(EssenceProvider.essenceCapability, null))
		{
			ItemStack stack = event.getItemStack();
			ITooltipFlag flag = event.getFlags();
			List<String> tooltip = event.getToolTip();
			String info = TextFormatting.DARK_GRAY + I18n.format(Reference.MODID + ".voidEssence");
			int essence = stack.getCapability(EssenceProvider.essenceCapability, null).essence();
			tooltip.add(info + ": " + TextFormatting.GRAY + essence);
		}
	}
}
