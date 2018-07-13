package com.camellias.voidaicarcania.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.blocks.BlockAltar;
import com.camellias.voidaicarcania.blocks.BlockArcaneEarth;
import com.camellias.voidaicarcania.blocks.BlockBotanyAltar;
import com.camellias.voidaicarcania.blocks.BlockConstruct;
import com.camellias.voidaicarcania.blocks.BlockDarkBrick;
import com.camellias.voidaicarcania.blocks.BlockDarkBrickChiseled;
import com.camellias.voidaicarcania.blocks.BlockDwarfBrick;
import com.camellias.voidaicarcania.blocks.BlockDwarvenStairs;
import com.camellias.voidaicarcania.blocks.BlockFeatherweed;
import com.camellias.voidaicarcania.blocks.BlockFloatshroom;
import com.camellias.voidaicarcania.blocks.BlockGlowgrowth;
import com.camellias.voidaicarcania.blocks.BlockIdfk;
import com.camellias.voidaicarcania.blocks.BlockLantern;
import com.camellias.voidaicarcania.blocks.BlockMoonMint;
import com.camellias.voidaicarcania.blocks.BlockMortalCentrifuge;
import com.camellias.voidaicarcania.blocks.BlockNeddlesprout;
import com.camellias.voidaicarcania.blocks.BlockStarbloom;
import com.camellias.voidaicarcania.blocks.BlockStem;
import com.camellias.voidaicarcania.blocks.BlockVoidCloud;
import com.camellias.voidaicarcania.blocks.BlockVoidCrop;
import com.camellias.voidaicarcania.blocks.BlockVoidEye;
import com.camellias.voidaicarcania.blocks.BlockVoidFlower;
import com.camellias.voidaicarcania.blocks.BlockVoidGlass;
import com.camellias.voidaicarcania.blocks.BlockVoidMelon;
import com.camellias.voidaicarcania.blocks.BlockVoidMelonCrop;
import com.camellias.voidaicarcania.blocks.BlockVoidSand;
import com.camellias.voidaicarcania.blocks.BlockVoidStone;
import com.camellias.voidaicarcania.blocks.BlockVoidStonePillar;
import com.camellias.voidaicarcania.blocks.BlockVoidStoneSmooth;
import com.camellias.voidaicarcania.blocks.BlockVoidStoneTiles;
import com.camellias.voidaicarcania.blocks.BlockVoidStoneTilesCracked;
import com.camellias.voidaicarcania.blocks.BlockVoidTea;
import com.camellias.voidaicarcania.blocks.BlockVoidWeed;
import com.camellias.voidaicarcania.blocks.BlockWhiteWood;
import com.camellias.voidaicarcania.blocks.BlockWhiteWoodLeaves;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	//-----Block list-----//
	public static final List<Block> BLOCKS = new ArrayList<Block>();
			
	public static final Block BLOCK_ALTAR = new BlockAltar("block_altar", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE = new BlockVoidStone("block_voidrock", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE_PILLAR = new BlockVoidStonePillar("block_voidrock_pillar", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE_TILES = new BlockVoidStoneTiles("block_voidrock_tiles", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE_TILES_CRACKED = new BlockVoidStoneTilesCracked("block_voidrock_tiles_cracked", Material.ROCK);
	public static final Block BLOCK_VOIDSTONE_SMOOTH = new BlockVoidStoneSmooth("block_voidrock_smooth", Material.ROCK);
	public static final Block BLOCK_VOIDGLASS = new BlockVoidGlass("block_voidglass", Material.GLASS);
	public static final Block BLOCK_VOIDSAND = new BlockVoidSand("block_voidsand", Material.SAND);
	public static final Block BLOCK_ARCANE_EARTH = new BlockArcaneEarth("block_arcane_earth", Material.GROUND);
	public static final Block BLOCK_LANTERN = new BlockLantern("block_lantern", Material.GLASS);
	public static final Block BLOCK_DWARFBRICK = new BlockDwarfBrick("block_dwarf_brick", Material.ROCK);
	public static final Block BLOCK_DWARF_STAIRS = new BlockDwarvenStairs("block_dwarf_stairs", BLOCK_DWARFBRICK.getDefaultState());
	public static final Block BLOCK_DARK_BRICK = new BlockDarkBrick("block_dark_brick", Material.ROCK);
	public static final Block BLOCK_DARK_BRICK_CHISELED = new BlockDarkBrickChiseled("block_dark_brick_chiseled", Material.ROCK);
	public static final Block BLOCK_IDFK = new BlockIdfk("block_idfk", Material.WOOD);
	public static final Block BLOCK_WHITEWOOD = new BlockWhiteWood("block_whitewood", Material.WOOD);
	public static final Block BLOCK_WHITEWOOD_LEAVES = new BlockWhiteWoodLeaves("block_whitewood_leaves", Material.LEAVES);
	public static final Block BLOCK_BOTANY_ALTAR = new BlockBotanyAltar("block_botany_altar", Material.ROCK);
	public static final Block BLOCK_STEM = new BlockStem("block_stem", Material.IRON);
	public static final Block BLOCK_CONSTRUCT = new BlockConstruct("block_construct", Material.PISTON);
	public static final Block BLOCK_EYE = new BlockVoidEye("block_voideye", Material.ROCK);
	public static final Block BLOCK_VOID_MELON = new BlockVoidMelon("block_void_melon", Material.GOURD); //Not actual block, but melon
	public static final Block BLOCK_VOIDCLOUD = new BlockVoidCloud("block_voidcloud", Material.CARPET);
	public static final Block BLOCK_MORTAL_FURNACE = new BlockMortalCentrifuge("block_mortal_furnace", Material.ROCK);
	
	//-----Plants-----//
	public static final Block BLOCK_VOID_FLOWER = new BlockVoidFlower("block_void_flower", Material.PLANTS);
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
}
