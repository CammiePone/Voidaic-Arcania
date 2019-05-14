package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.api.VoidEssenceList;
import com.camellias.voidaicarcania.client.renderer.entity.mobs.RenderVoidCrawler;
import com.camellias.voidaicarcania.client.renderer.entity.mobs.RenderVoidWraith;
import com.camellias.voidaicarcania.client.renderer.hud.OverlayRenderer;
import com.camellias.voidaicarcania.common.entities.mobs.EntityVoidCrawler;
import com.camellias.voidaicarcania.common.entities.mobs.EntityVoidWraith;
import com.camellias.voidaicarcania.common.world.structures.WorldGenCustomStructures;
import com.camellias.voidaicarcania.core.init.ModBiomes;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.init.ModCapabilities;
import com.camellias.voidaicarcania.core.init.ModDimensions;
import com.camellias.voidaicarcania.core.init.ModItems;
import com.camellias.voidaicarcania.core.init.ModSounds;
import com.camellias.voidaicarcania.core.kofi.Donators;
import com.camellias.voidaicarcania.core.network.NetworkHandler;
import com.camellias.voidaicarcania.core.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		for(Item item : ModItems.ITEMS)
		{
			event.getRegistry().register(item);
		}
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		for(Block block : ModBlocks.BLOCKS)
		{
			event.getRegistry().register(block);
		}
		
		TileEntityHandler.registerTileEntities();
	}
	
	@SubscribeEvent
	public static void onSoundRegister(RegistryEvent.Register<SoundEvent> event)
	{
		for(SoundEvent sound : ModSounds.SOUNDS)
		{
			event.getRegistry().register(sound);
		}
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}

		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void clientRegistries(FMLPreInitializationEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidWraith.class, RenderVoidWraith::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidCrawler.class, RenderVoidCrawler::new);
	}

	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		NetworkHandler.init();
		ModCapabilities.init();
		ModBiomes.registerBiome();
		ModDimensions.registerDimension();
		Donators.addDonators();
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		
		MinecraftForge.EVENT_BUS.register(new TickHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(new CapabilitiesHandler());
		MinecraftForge.EVENT_BUS.register(OverlayRenderer.instance);
		
		Blocks.DRAGON_EGG.setCreativeTab(CreativeTabs.DECORATIONS);
		Blocks.COMMAND_BLOCK.setCreativeTab(CreativeTabs.REDSTONE);
	}
	
	public static void initRegistries()
	{
		VoidEssenceList.init();
	}
}
