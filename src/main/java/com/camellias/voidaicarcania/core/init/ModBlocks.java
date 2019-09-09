package com.camellias.voidaicarcania.core.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.common.blocks.magic.BlockReactionCatalyst;
import com.camellias.voidaicarcania.common.blocks.magic.BlockRift;
import com.camellias.voidaicarcania.common.blocks.magic.BlockVoidaicAltar;
import com.camellias.voidaicarcania.common.blocks.magic.BlockWhitewoodPedestal;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodLeaves;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodLog;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodPlanks;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodStairs;

import net.minecraft.block.Block;
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
	
	public static final Block UNDERWOOD_LOG = new BlockWhitewoodLog(Material.WOOD, "underwood_log");
	public static final Block UNDERWOOD_LEAVES = new BlockWhitewoodLeaves(Material.PLANTS, "underwood_leaves");
	public static final Block UNDERWOOD_PLANKS = new BlockWhitewoodPlanks(Material.WOOD, "underwood_planks");
	public static final Block UNDERWOOD_STAIRS = new BlockWhitewoodStairs(UNDERWOOD_PLANKS.getDefaultState(), "underwood_stairs");
}
