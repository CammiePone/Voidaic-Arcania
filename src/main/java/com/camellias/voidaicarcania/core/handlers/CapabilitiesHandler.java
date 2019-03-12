package com.camellias.voidaicarcania.core.handlers;

import java.util.List;
import java.util.Random;

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
import com.camellias.voidaicarcania.core.util.ItemStackWrapper;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CapabilitiesHandler
{
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
				event.addCapability(new ResourceLocation(Reference.MODID, "PlayerCorruption"), new CorruptionProvider(corruption));
			}
		}
	}

	@SubscribeEvent
	public void onAddItemCapabilites(AttachCapabilitiesEvent<ItemStack> event)
	{
		ItemStack stack = event.getObject();
		ItemStackWrapper wrapper = new ItemStackWrapper(stack.getItem(), stack.getMetadata());
		if(VoidEssenceList.LIST.containsKey(wrapper))
		{
			if(!event.getObject().hasCapability(EssenceProvider.essenceCapability, null))
			{
				int essence = VoidEssenceList.LIST.get(wrapper);
				boolean effect = false;
				IEssence itemEssence = new DefaultEssenceCapability(essence, effect);
				event.addCapability(new ResourceLocation(Reference.MODID, "ItemEssence"), new EssenceProvider(itemEssence));
			}
		}
	}
	
	@SubscribeEvent
	public void onAddChunkCapabilities(AttachCapabilitiesEvent<Chunk> event)
	{
		Chunk chunk = event.getObject();
		if(!event.getObject().hasCapability(EssenceProvider.essenceCapability, null))
		{
			int essence = 0;
			boolean effect = false;
			IEssence chunkEssence = new DefaultEssenceCapability(essence, effect);
			event.addCapability(new ResourceLocation(Reference.MODID, "ChunkEssence"), new EssenceProvider(chunkEssence));
		}
		if(!chunk.hasCapability(CorruptionProvider.corruptionCapability, null))
		{
			int amount = 0;
			boolean corrupted = false;
			ICorruption corruption = new DefaultCorruptionCapability(amount, corrupted);
			event.addCapability(new ResourceLocation(Reference.MODID, "ChunkCorruption"), new CorruptionProvider(corruption));
		}
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onChunkPopulate(PopulateChunkEvent.Post event)
	{
		World world = event.getWorld();
		Chunk chunk = world.getChunk(event.getChunkX(), event.getChunkZ());
		Random rand = new Random();
		
		if(chunk.hasCapability(EssenceProvider.essenceCapability, null))
		{
			chunk.getCapability(EssenceProvider.essenceCapability, null).setEssence(rand.nextInt(1600));
		}
		if(chunk.hasCapability(CorruptionProvider.corruptionCapability, null))
		{
			chunk.getCapability(CorruptionProvider.corruptionCapability, null).setCorruption(rand.nextInt(1000));
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
			String itemInfo = TextFormatting.DARK_GRAY + I18n.format(Reference.MODID + ".voidEssenceItem");
			String stackInfo = TextFormatting.DARK_GRAY + I18n.format(Reference.MODID + ".voidEssenceStack");
			int essence = stack.getCapability(EssenceProvider.essenceCapability, null).essence();
			tooltip.add(itemInfo + ": " + TextFormatting.GRAY + essence);
			tooltip.add(stackInfo + ": " + TextFormatting.GRAY + (essence * stack.getCount()));
		}
	}
}
