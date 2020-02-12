package com.camellias.voidaicarcania;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.camellias.voidaicarcania.core.handlers.RegistryHandler;
import com.camellias.voidaicarcania.core.proxy.CommonProxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
	modid = Reference.MODID, 
	name = Reference.NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTEDVERSIONS, 
	dependencies = Reference.DEPENDENCIES)
public class Main 
{
	public static File config;
	private static final Logger LOGGER = LogManager.getLogger(Reference.NAME);
	
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
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public static void print(String input)
	{
		System.out.println(input);
	}
	
	public static void print(float input)
	{
		System.out.println(input);
	}
	
	public static void print(double input)
	{
		System.out.println(input);
	}
	
	public static void print(int input)
	{
		System.out.println(input);
	}
	
	public static void print(byte input)
	{
		System.out.println(input);
	}
	
	public static void print(char input)
	{
		System.out.println(input);
	}
	
	public static void print(long input)
	{
		System.out.println(input);
	}
	
	public static void print(short input)
	{
		System.out.println(input);
	}
	
	public static void print(boolean input)
	{
		System.out.println(input);
	}
	
	public static void print()
	{
		System.out.println();
	}
	
	public static void log(String input)
	{
		LOGGER.info(input);
	}
	
	public static void log(float input)
	{
		LOGGER.info(input);
	}
	
	public static void log(double input)
	{
		LOGGER.info(input);
	}
	
	public static void log(int input)
	{
		LOGGER.info(input);
	}
	
	public static void log(byte input)
	{
		LOGGER.info(input);
	}
	
	public static void log(char input)
	{
		LOGGER.info(input);
	}
	
	public static void log(long input)
	{
		LOGGER.info(input);
	}
	
	public static void log(short input)
	{
		LOGGER.info(input);
	}
	
	public static void log(boolean input)
	{
		LOGGER.info(input);
	}
	
	public static void log()
	{
		LOGGER.info("");
	}
	
	public static void warn(String input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn(float input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn(double input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn(int input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn(byte input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn(char input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn(long input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn(short input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn(boolean input)
	{
		LOGGER.warn(input);
	}
	
	public static void warn()
	{
		LOGGER.warn("");
	}
}
