package com.camellias.voidaicarcania.core.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.common.blocks.BlockFullSlabBase;
import com.camellias.voidaicarcania.common.blocks.BlockHalfSlabBase;
import com.camellias.voidaicarcania.common.blocks.deco.BlockFungalStem;
import com.camellias.voidaicarcania.common.blocks.deco.BlockFungalWall;
import com.camellias.voidaicarcania.common.blocks.deco.BlockLanternBulb;
import com.camellias.voidaicarcania.common.blocks.deco.BlockLanternStem;
import com.camellias.voidaicarcania.common.blocks.deco.BlockWhitewoodStairs;
import com.camellias.voidaicarcania.common.blocks.magic.BlockReactionCatalyst;
import com.camellias.voidaicarcania.common.blocks.magic.BlockRift;
import com.camellias.voidaicarcania.common.blocks.magic.BlockVoidaicAltar;
import com.camellias.voidaicarcania.common.blocks.magic.BlockWhitewoodPedestal;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodLeaves;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodLog;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodPlanks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	//-----Block list-----//
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Magic
	public static final Block RIFT = new BlockRift(Material.PORTAL, "void_rift");
	public static final Block CATALYST = new BlockReactionCatalyst(Material.CIRCUITS, "catalyzing_powder");
	public static final Block PEDESTAL = new BlockWhitewoodPedestal(Material.WOOD, "underwood_pedestal");
	public static final Block ALTAR = new BlockVoidaicAltar(Material.WOOD, "voidaic_altar");
	
	//Underwood
	public static final Block UNDERWOOD_LOG = new BlockWhitewoodLog(Material.WOOD, "underwood_log");
	public static final Block UNDERWOOD_LEAVES = new BlockWhitewoodLeaves(Material.PLANTS, "underwood_leaves");
	public static final Block UNDERWOOD_PLANKS = new BlockWhitewoodPlanks(Material.WOOD, "underwood_planks");
	public static final BlockSlab UNDERWOOD_SLAB_FULL = new BlockFullSlabBase(Material.WOOD, "underwood_full_slab", ModBlocks.UNDERWOOD_SLAB, null, 0, SoundType.WOOD, 2F, 0F);
	public static final BlockSlab UNDERWOOD_SLAB = new BlockHalfSlabBase(Material.WOOD, "underwood_half_slab", ModBlocks.UNDERWOOD_SLAB, ModBlocks.UNDERWOOD_SLAB_FULL, null, 0, SoundType.WOOD, 2F, 0F);
	public static final Block UNDERWOOD_STAIRS = new BlockWhitewoodStairs(UNDERWOOD_PLANKS.getDefaultState(), "underwood_stairs");
	
	//Decoration
	public static final Block FUNGAL_WALL = new BlockFungalWall(Material.GOURD, "fungal_wall");
	public static final Block FUNGAL_STEM = new BlockFungalStem(Material.GOURD, "fungal_stem");
	public static final Block LANTERN_STEM = new BlockLanternStem(Material.PLANTS, "lantern_stem");
	public static final Block LANTERN_BULB = new BlockLanternBulb(Material.PLANTS, "lantern_bulb");
}
