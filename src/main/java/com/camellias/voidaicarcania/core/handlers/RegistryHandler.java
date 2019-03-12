package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.api.VoidEssenceList;
import com.camellias.voidaicarcania.client.renderer.hud.OverlayRenderer;
import com.camellias.voidaicarcania.core.init.ModBiomes;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.init.ModCapabilities;
import com.camellias.voidaicarcania.core.init.ModDimensions;
import com.camellias.voidaicarcania.core.init.ModItems;
import com.camellias.voidaicarcania.core.kofi.Donators;
import com.camellias.voidaicarcania.core.network.NetworkHandler;
import com.camellias.voidaicarcania.core.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[1]));
		TileEntityHandler.registerTileEntities();
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

	public static void serverRegistries(FMLServerStartingEvent event)
	{

	}

	public static void otherRegistries()
	{
		ModCapabilities.init();
		ModBiomes.registerBiome();
		Blocks.DRAGON_EGG.setCreativeTab(CreativeTabs.DECORATIONS);
		Blocks.COMMAND_BLOCK.setCreativeTab(CreativeTabs.REDSTONE);
	}

	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		NetworkHandler.init();
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(new CapabilitiesHandler());
		MinecraftForge.EVENT_BUS.register(OverlayRenderer.instance);
		Donators.addDonators();
		ModDimensions.registerDimension();
	}
	
	public static void initRegistries()
	{
		VoidEssenceList.init();
	}
}
