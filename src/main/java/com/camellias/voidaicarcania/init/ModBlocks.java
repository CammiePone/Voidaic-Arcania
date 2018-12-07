package com.camellias.voidaicarcania.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.common.blocks.BlockArcaneEarth;
import com.camellias.voidaicarcania.common.blocks.BlockIdfk;
import com.camellias.voidaicarcania.common.blocks.dwarven.BlockDarkBrick;
import com.camellias.voidaicarcania.common.blocks.dwarven.BlockDarkBrickChiseled;
import com.camellias.voidaicarcania.common.blocks.dwarven.BlockDarkMarble;
import com.camellias.voidaicarcania.common.blocks.dwarven.BlockDwarfBrick;
import com.camellias.voidaicarcania.common.blocks.dwarven.BlockDwarfLantern;
import com.camellias.voidaicarcania.common.blocks.dwarven.BlockDwarvenStairs;
import com.camellias.voidaicarcania.common.blocks.machines.BlockAltar;
import com.camellias.voidaicarcania.common.blocks.machines.BlockBotanyAltar;
import com.camellias.voidaicarcania.common.blocks.machines.BlockMortalCentrifuge;
import com.camellias.voidaicarcania.common.blocks.machines.BlockReflectionPool;
import com.camellias.voidaicarcania.common.blocks.metals.BlockAstraliteMetal;
import com.camellias.voidaicarcania.common.blocks.metals.BlockDemonMetal;
import com.camellias.voidaicarcania.common.blocks.metals.BlockEnargiteMetal;
import com.camellias.voidaicarcania.common.blocks.metals.BlockFrozenMercury;
import com.camellias.voidaicarcania.common.blocks.metals.BlockInfusedMetal;
import com.camellias.voidaicarcania.common.blocks.metals.BlockMythrilMetal;
import com.camellias.voidaicarcania.common.blocks.ores.BlockBorniteOre;
import com.camellias.voidaicarcania.common.blocks.ores.BlockCinnibarOre;
import com.camellias.voidaicarcania.common.blocks.ores.BlockNetherheartOre;
import com.camellias.voidaicarcania.common.blocks.plants.BlockFeatherweed;
import com.camellias.voidaicarcania.common.blocks.plants.BlockFloatshroom;
import com.camellias.voidaicarcania.common.blocks.plants.BlockGlowgrowth;
import com.camellias.voidaicarcania.common.blocks.plants.BlockMoonMint;
import com.camellias.voidaicarcania.common.blocks.plants.BlockNeddlesprout;
import com.camellias.voidaicarcania.common.blocks.plants.BlockStarbloom;
import com.camellias.voidaicarcania.common.blocks.plants.BlockVoidCrop;
import com.camellias.voidaicarcania.common.blocks.plants.BlockVoidFlower;
import com.camellias.voidaicarcania.common.blocks.plants.BlockVoidMelon;
import com.camellias.voidaicarcania.common.blocks.plants.BlockVoidMelonCrop;
import com.camellias.voidaicarcania.common.blocks.plants.BlockVoidTea;
import com.camellias.voidaicarcania.common.blocks.plants.BlockVoidWeed;
import com.camellias.voidaicarcania.common.blocks.plants.BlockVoidWeedTall;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockConstruct;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockLantern;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockStem;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidCloud;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidCrystal;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidEye;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidGlass;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidMass;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidSand;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidStone;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidStonePillar;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidStoneSmooth;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidStoneTiles;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidStoneTilesCracked;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockVoidTotem;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockWhiteWood;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockWhiteWoodLeaves;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockWhiteWoodPlanks;
import com.camellias.voidaicarcania.common.blocks.voidic.BlockWhiteWoodStairs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	//-----Block list-----//
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//-----Machines-----//
	public static final Block BLOCK_ALTAR = new BlockAltar("block_altar", Material.ROCK);
	public static final Block BLOCK_BOTANY_ALTAR = new BlockBotanyAltar("block_botany_altar", Material.ROCK);
	public static final Block BLOCK_MORTAL_FURNACE = new BlockMortalCentrifuge("block_mortal_furnace", Material.ROCK);
	public static final Block BLOCK_REFLECTION_POOL = new BlockReflectionPool("block_reflection_pool", Material.ROCK);
	
	//-----Voidic-----//
	public static final Block BLOCK_VOIDSTONE = new BlockVoidStone("block_voidrock", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE_PILLAR = new BlockVoidStonePillar("block_voidrock_pillar", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE_TILES = new BlockVoidStoneTiles("block_voidrock_tiles", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE_TILES_CRACKED = new BlockVoidStoneTilesCracked("block_voidrock_tiles_cracked", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE_SMOOTH = new BlockVoidStoneSmooth("block_voidrock_smooth", Material.ROCK);
	public static final Block BLOCK_CONSTRUCT = new BlockConstruct("block_construct", Material.ROCK);
	public static final Block BLOCK_EYE = new BlockVoidEye("block_voideye", Material.ROCK);
	public static final Block BLOCK_VOIDGLASS = new BlockVoidGlass("block_voidglass", Material.GLASS);
	public static final Block BLOCK_LANTERN = new BlockLantern("block_lantern", Material.GLASS);
	public static final Block BLOCK_STEM = new BlockStem("block_stem", Material.IRON);
	public static final Block VOID_TOTEM = new BlockVoidTotem("block_void_totem", Material.GLASS);
	public static final Block BLOCK_VOIDMASS = new BlockVoidMass("block_voidmass", Material.GOURD);
	public static final Block BLOCK_VOIDSAND = new BlockVoidSand("block_voidsand", Material.SAND);
	public static final Block BLOCK_ARCANE_EARTH = new BlockArcaneEarth("block_arcane_earth", Material.GROUND);
	public static final Block BLOCK_VOIDCLOUD = new BlockVoidCloud("block_voidcloud", Material.CARPET);
	public static final Block BLOCK_WHITEWOOD = new BlockWhiteWood("block_whitewood", Material.WOOD);
	public static final Block BLOCK_WHITEWOOD_PLANKS = new BlockWhiteWoodPlanks("block_whitewood_planks", Material.WOOD);
	public static final Block BLOCK_WHITEWOOD_STAIRS = new BlockWhiteWoodStairs("block_whitewood_stairs", BLOCK_WHITEWOOD_PLANKS.getDefaultState());
	//public static final Block BLOCK_WHITEWOOD_SLAB = new BlockWhiteWoodSlab("block_whitewood_slab", Material.WOOD);
	public static final Block BLOCK_WHITEWOOD_LEAVES = new BlockWhiteWoodLeaves("block_whitewood_leaves", Material.LEAVES);
	
	//-----Dwarven-----//
	public static final Block BLOCK_DWARFBRICK = new BlockDwarfBrick("block_dwarf_brick", Material.ROCK);
	public static final Block BLOCK_DWARF_STAIRS = new BlockDwarvenStairs("block_dwarf_stairs", BLOCK_DWARFBRICK.getDefaultState());
	public static final Block BLOCK_DARK_BRICK = new BlockDarkBrick("block_dark_brick", Material.ROCK);
	public static final Block BLOCK_DARK_BRICK_CHISELED = new BlockDarkBrickChiseled("block_dark_brick_chiseled", Material.ROCK);
	public static final Block BLOCK_DARK_MARBLE = new BlockDarkMarble("block_dark_marble", Material.ROCK);
	public static final Block BLOCK_DWARF_LANTERN = new BlockDwarfLantern("block_dwarf_lantern", Material.GLASS);
	
	//-----Ores & Metals-----//
	public static final Block BLOCK_CINNIBAR_ORE = new BlockCinnibarOre("block_cinnibar_ore", Material.ROCK);
	public static final Block BLOCK_BORNITE_ORE = new BlockBorniteOre("block_peacock_ore", Material.ROCK);
	public static final Block BLOCK_NETHERHEART_ORE = new BlockNetherheartOre("block_netherheart_ore", Material.ROCK);
	public static final Block BLOCK_INFUSED_METAL = new BlockInfusedMetal("block_infused_metal", Material.IRON);
	public static final Block BLOCK_MYTHRIL_METAL = new BlockMythrilMetal("block_mythril_metal", Material.IRON);
	public static final Block BLOCK_ASTRALITE_METAL = new BlockAstraliteMetal("block_astralite_metal", Material.IRON);
	public static final Block BLOCK_ENARGITE_METAL = new BlockEnargiteMetal("block_enargite_metal", Material.IRON);
	public static final Block BLOCK_MERCURY = new BlockFrozenMercury("block_frozen_mercury", Material.IRON);
	public static final Block BLOCK_DEMONIRON = new BlockDemonMetal("block_demon_metal", Material.IRON);
	public static final Block BLOCK_VOID_CRYSTAL = new BlockVoidCrystal("block_void_crystal", Material.GLASS);
	
	//-----Plants-----//
	public static final Block BLOCK_VOID_MELON = new BlockVoidMelon("block_void_melon", Material.GOURD); //Not actual block, but melon
	public static final Block BLOCK_VOID_FLOWER = new BlockVoidFlower("block_void_flower", Material.PLANTS);
	public static final Block BLOCK_WEED_TALL = new BlockVoidWeedTall("block_tall_weed", Material.PLANTS);
	public static final Block BLOCK_VOID_WEED = new BlockVoidWeed("block_void_weed", Material.PLANTS);
	public static final Block BLOCK_VOID_CROP = new BlockVoidCrop("block_void_crop");
	public static final Block BLOCK_FLOATSHROOM = new BlockFloatshroom("block_floatshroom");
	public static final Block BLOCK_GLOWGROWTH = new BlockGlowgrowth("block_glowgrowth");
	public static final Block BLOCK_VOIDTEA = new BlockVoidTea("block_voidtea");
	public static final Block BLOCK_MELON_CROP = new BlockVoidMelonCrop("block_melon_crop");
	public static final Block BLOCK_FEATHERWEED = new BlockFeatherweed("block_featherweed");
	public static final Block BLOCK_MOON_MINT = new BlockMoonMint("block_moonmint");
	public static final Block BLOCK_STARBLOOM = new BlockStarbloom("block_starbloom");
	public static final Block BLOCK_NEDDLESPROUT = new BlockNeddlesprout("block_neddlesprout");
	
	//-----Random-----//
	public static final Block BLOCK_IDFK = new BlockIdfk("block_idfk", Material.WOOD);
}
