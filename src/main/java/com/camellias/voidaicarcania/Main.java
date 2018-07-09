package com.camellias.voidaicarcania;

import java.io.File;

import com.camellias.voidaicarcania.potions.PotionLifeSteal;
import com.camellias.voidaicarcania.potions.PotionVoidTouch;
import com.camellias.voidaicarcania.proxy.CommonProxy;
import com.camellias.voidaicarcania.tabs.VoidicAlchemyTab;
import com.camellias.voidaicarcania.tabs.VoidicMetallurgyTab;
import com.camellias.voidaicarcania.tabs.VoidicTab;
import com.camellias.voidaicarcania.util.handlers.RegistryHandler;
import com.camellias.voidaicarcania.util.handlers.SoundsHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTEDVERSIONS)
public class Main 
{
	public static File config;
	public static boolean voidcraftLoaded = false;
	
	public static final Potion LIFESTEAL = new PotionLifeSteal("lifesteal");
	public static final Potion VOIDTOUCH = new PotionVoidTouch("voidtouch");
	
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
		if(Loader.isModLoaded("voidcraftLoaded"))
		{
			voidcraftLoaded = true;
		}
		
		RegistryHandler.otherRegistries();
		RegistryHandler.preInitRegistries(event);
		
		ForgeRegistries.POTIONS.registerAll(LIFESTEAL, VOIDTOUCH);
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
		RegistryHandler.serverRegistries(event);
		
		System.out.println("Voidaic Arcania checking in!");
	}
}
