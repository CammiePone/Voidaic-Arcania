package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.commands.CommandDimTeleport;
import com.camellias.voidaicarcania.init.ModBiomes;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModDimensions;
import com.camellias.voidaicarcania.init.ModEntities;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.AspectRegistry;
import com.camellias.voidaicarcania.util.IHasModel;
import com.camellias.voidaicarcania.util.OreDictionaryCompatibility;
import com.camellias.voidaicarcania.world.gen.WorldGenCustomOres;
import com.camellias.voidaicarcania.world.gen.WorldGenCustomStructures;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

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
		event.registerServerCommand(new CommandDimTeleport());
	}
	
	public static void otherRegistries()
	{
		ModBiomes.registerBiomes();
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		ModDimensions.registerDimension();
		ModEntities.registerEntities();
		
		if(event.getSide() == Side.CLIENT)
		{
			RenderHandler.registerEntityRenders();
		}
		ConfigHandler.registerConfig(event);
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
	}
	
	public static void initRegistries()
	{
		OreDictionaryCompatibility.registerOres();
		
		if(Main.thaumcraftLoaded == true)
		{
			AspectRegistry.registry();
		}
		
		SoundsHandler.registerSounds();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
}
