package com.camellias.voidaicarcania;

import java.io.File;

import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipes;
import com.camellias.voidaicarcania.core.handlers.RegistryHandler;
import com.camellias.voidaicarcania.core.init.ModItems;
import com.camellias.voidaicarcania.core.proxy.CommonProxy;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(
	modid = Reference.MODID, 
	name = Reference.NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTEDVERSIONS, 
	dependencies = Reference.DEPENDENCIES)
public class Main 
{
	public static File config;
	
	@Instance
	public static Main instance;
	public static boolean isThaumcraftLoaded = false;
	
	//Proxy
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	//Initialization
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		if(Loader.isModLoaded("thaumcraft"))
		{
			isThaumcraftLoaded = true;
		}
		
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("Voidaic Arcania checking in!");
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
	{
		System.out.println("Voidaic Arcania checking in!");
	}
}
