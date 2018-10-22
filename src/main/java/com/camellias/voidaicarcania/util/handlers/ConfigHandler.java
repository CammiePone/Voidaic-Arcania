package com.camellias.voidaicarcania.util.handlers;

import java.io.File;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler 
{
	public static Configuration config;
	
	public static int GUI_ALTAR = 0;
	public static int GUI_BOTANY_ALTAR = 1;
	public static int GUI_MORTAL_FURNACE = 2;
	public static int GUI_SPELLBOOK = 3;
	public static int ENTITY_VOID_WRAITH = 128;
	public static int ENTITY_VOID_CONSTRUCT = 129;
	public static int ENTITY_HEART_BOSS = 130;
	public static int ENTITY_HEART_PASSIVE = 131;
	public static int ENTITY_VOID_EYE = 132;
	public static int ENTITY_VOID_DAEMON = 133;
	
	public static boolean spawnVoidBiomeOverworld;
	
	public static void init(File file)
	{
		config = new Configuration(file);
		
		String category;
		
		category = "IDs";
		config.addCustomCategoryComment(category, "Set IDs for each entity and GUI");
		
		ENTITY_VOID_WRAITH = config.getInt("Entity Void Wraith ID", category, 128, 120, 3000, "Void Wraith ID");
		ENTITY_VOID_CONSTRUCT = config.getInt("Entity Voidic Construct ID", category, 129, 120, 3000, "Voidic Construct ID");
		ENTITY_HEART_BOSS = config.getInt("Entity Voidic Heart Boss ID", category, 130, 120, 3000, "Voidic Heart Boss ID");
		ENTITY_HEART_PASSIVE = config.getInt("Entity Voidic Heart Passive ID", category, 131, 120, 3000, "Voidic Heart Passive ID");
		ENTITY_VOID_EYE = config.getInt("Entity Void Eye ID", category, 132, 120, 3000, "Void Eye ID");
		
		GUI_ALTAR = config.getInt("Altar GUI ID", category, 0, 0, 3000, "Altar GUI ID");
		GUI_BOTANY_ALTAR = config.getInt("Botany Altar GUI ID", category, 1, 0, 3000, "Botany Altar GUI ID");
		GUI_MORTAL_FURNACE = config.getInt("Mortal Furnace GUI ID", category, 2, 0, 3000, "Mortal Furnace GUI ID");
		GUI_SPELLBOOK = config.getInt("Spell Book GUI ID", category, 3, 0, 3000, "Spell Book GUI ID");
		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MODID + ".cfg"));
	}
}
