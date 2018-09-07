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
	
	public static boolean spawnVoidBiomeOverworld;
	
	public static int COAL_TRANS_ORB = 2;
	public static int IRON_TRANS_ORB = 6;
	public static int PEARL_TRANS_ORB = 100;
	public static int REDSTONE_TRANS_ORB = 2;
	public static int LAPIS_TRANS_ORB = 4;
	public static int GLOWSTONE_TRANS_ORB = 4;
	
	public static int COAL_VOID_ORB = 1;
	public static int IRON_VOID_ORB = 3;
	public static int PEARL_VOID_ORB = 50;
	public static int REDSTONE_VOID_ORB = 1;
	public static int LAPIS_VOID_ORB = 2;
	public static int GLOWSTONE_VOID_ORB = 2;
	public static int GOLD_VOID_ORB = 25;
	public static int DIAMOND_VOID_ORB = 200;
	public static int EMERALD_VOID_ORB = 400;
	
	public static int VOID_BOTTLE = 800;
	public static int DWARF_BRICK = 2;
	
	public static int SHIELD_AMULET = 5000;
	public static int INVERSE_AMULET = 2500;
	public static int STRENGTH_BELT = 5000;
	public static int RESISTANCE_BELT = 2500;
	public static int FEAST_COWL = 5000;
	public static int REAPER_COWL = 5000;
	public static int FLIGHT_CLOAK = 5000;
	public static int INVIS_CLOAK = 5000;
	public static int LUCK_CHARM = 2500;
	public static int VOID_CHARM = 2500;
	
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
		GUI_MORTAL_FURNACE = config.getInt("Mortal Furnace GUI ID", category, 2, 2, 3000, "Mortal Furnace GUI ID");
		GUI_SPELLBOOK = config.getInt("Spell Book GUI ID", category, 2, 0, 3000, "Spell Book GUI ID");
		
		category = "Biomes";
		config.addCustomCategoryComment(category, "Spawn Void biome in Overworld");
		
		spawnVoidBiomeOverworld = config.getBoolean("Spawn Void biome in Overworld", category, false, "Spawn Void biome in the Overworld");
		
		category = "Fuel Costs";
		config.addCustomCategoryComment(category, "Set how much fuel it costs to use the altar with specific items");
		
		COAL_TRANS_ORB = config.getInt("Coal & Transmutation Orb", category, 2, 0, 100000, 
				"Cost to make coal with an orb of transmutation");
		IRON_TRANS_ORB = config.getInt("Iron & Transmutation Orb", category, 6, 0, 100000, 
				"Cost to make iron ingots with an orb of transmutation");
		PEARL_TRANS_ORB = config.getInt("Ender Pearl & Transmutation Orb", category, 100, 0, 100000, 
				"Cost to make ender pearls with an orb of transmutation");
		REDSTONE_TRANS_ORB = config.getInt("Redstone & Transmutation Orb", category, 2, 0, 100000, 
				"Cost to make redstone dust with an orb of transmutation");
		LAPIS_TRANS_ORB = config.getInt("Lapis Lazuli & Transmutation Orb", category, 4, 0, 100000, 
				"Cost to make lapis lazuli with an orb of transmutation");
		GLOWSTONE_TRANS_ORB = config.getInt("Glowstone Dust & Transmutation Orb", category, 4, 0, 100000, 
				"Cost to make glowstone dust with an orb of transmutation");
		
		COAL_VOID_ORB = config.getInt("Coal & Void Orb", category, 2, 0, 100000, 
				"Cost to make coal with a voidic orb of transmutation");
		IRON_VOID_ORB = config.getInt("Iron & Void Orb", category, 3, 0, 100000, 
				"Cost to make iron ingots with a voidic orb of transmutation");
		PEARL_VOID_ORB = config.getInt("Ender Pearl & Void Orb", category, 50, 0, 100000, 
				"Cost to make ender pearls with a voidic orb of transmutation");
		REDSTONE_VOID_ORB = config.getInt("Redstone & Voidic Orb", category, 1, 0, 100000, 
				"Cost to make redstone dust with a voidic orb of transmutation");
		LAPIS_VOID_ORB = config.getInt("Lapis Lazuli & Void Orb", category, 2, 0, 100000, 
				"Cost to make lapis lazuli with a voidic orb of transmutation");
		GLOWSTONE_VOID_ORB = config.getInt("Glowstone Dust & Void Orb", category, 2, 0, 100000, 
				"Cost to make glowstone dust with a voidic orb of transmutation");
		GOLD_VOID_ORB = config.getInt("Gold & Void Orb", category, 25, 0, 100000, 
				"Cost to make gold ingots with a voidic orb of transmutation");
		DIAMOND_VOID_ORB = config.getInt("Diamond & Void Orb", category, 200, 0, 100000, 
				"Cost to make diamonds with a voidic orb of transmutation");
		EMERALD_VOID_ORB = config.getInt("Emerald & Void Orb", category, 400, 0, 100000, 
				"Cost to make emeralds with a voidic orb of transmutation");
		
		VOID_BOTTLE = config.getInt("Dragon Breath to Bottled Void Essence", category, 800, 0, 100000, 
				"Cost to make bottled void essense from dragons breath");
		DWARF_BRICK = config.getInt("Recipe to make Dwarven Bricks", category, 2, 0, 100000, 
				"Cost to make Dwarven Bricks");
		
		SHIELD_AMULET = config.getInt("Recipe to make the Inert Shield Amulet", category, 5000, 0, 100000, 
				"Cost to make the Inert Shield Amulet");
		INVERSE_AMULET = config.getInt("Recipe to make the Inert Inverse Amulet", category, 2500, 0, 100000, 
				"Cost to make the Inert Inverse Amulet");
		STRENGTH_BELT = config.getInt("Recipe to make the Inert Strength Belt", category, 5000, 0, 100000, 
				"Cost to make the Inert Strength Belt");
		RESISTANCE_BELT = config.getInt("Recipe to make the Inert Resistance Belt", category, 2500, 0, 100000, 
				"Cost to make the Inert Resistance Belt");
		FEAST_COWL = config.getInt("Recipe to make the Inert Feast Cowl", category, 5000, 0, 100000, 
				"Cost to make the Inert Feast Cowl");
		REAPER_COWL = config.getInt("Recipe to make the Inert Reaper Cowl", category, 5000, 0, 100000, 
				"Cost to make the Inert Reaper Cowl");
		FLIGHT_CLOAK = config.getInt("Recipe to make the Inert Flight Cloak", category, 5000, 0, 100000, 
				"Cost to make the Inert Flight Cloak");
		INVIS_CLOAK = config.getInt("Recipe to make the Inert Invisibility Cloak", category, 5000, 0, 100000, 
				"Cost to make the Inert Invisibility Cloak");
		LUCK_CHARM = config.getInt("Recipe to make the Inert Luck Charm", category, 2500, 0, 100000, 
				"Cost to make the Inert Luck Charm");
		VOID_CHARM = config.getInt("Recipe to make the Inert Void Charm", category, 2500, 0, 100000, 
				"Cost to make the Inert Void Charm");
		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MODID + ".cfg"));
	}
}
