package com.camellias.voidaicarcania;

import java.io.File;

import com.camellias.voidaicarcania.init.ModSmelting;
import com.camellias.voidaicarcania.proxy.ClientProxy;
import com.camellias.voidaicarcania.proxy.CommonProxy;
import com.camellias.voidaicarcania.tabs.VoidicAlchemyTab;
import com.camellias.voidaicarcania.tabs.VoidicMetallurgyTab;
import com.camellias.voidaicarcania.tabs.VoidicTab;
import com.camellias.voidaicarcania.util.handlers.RegistryHandler;

import baubles.common.Baubles;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
	modid = Reference.MODID, 
	name = Reference.NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTEDVERSIONS, 
	dependencies = "required-after:forge@[14.23.4.2759,];" + "required-after:baubles@[1.5.2,];")
public class Main 
{
	public static File config;
	public static boolean voidcraftLoaded = false;
	public static boolean thaumcraftLoaded = false;
	
	@Instance
	public static Main instance;
	
	public static final CreativeTabs voidictab = new VoidicTab("voidictab");
	public static final CreativeTabs alchemytab = new VoidicAlchemyTab("alchemytab");
	public static final CreativeTabs metaltab = new VoidicMetallurgyTab("metaltab");
	
	//Proxy
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	//Initialization
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		if(Loader.isModLoaded("voidcraft"))
		{
			voidcraftLoaded = true;
		}
		
		if(Loader.isModLoaded("thaumcraft"))
		{
			thaumcraftLoaded = true;
		}
		
		RegistryHandler.otherRegistries();
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries();
		ModSmelting.init();	
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("Voidaic Arcania checking in!");
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
	{
		RegistryHandler.serverRegistries(event);
		
		System.out.println("Voidaic Arcania checking in!");
	}
}
