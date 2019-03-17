package com.camellias.voidaicarcania.core.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.common.blocks.BlockRift;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodLog;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodLeaves;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodPlanks;
import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodStairs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	//-----Block list-----//
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RIFT = new BlockRift(Material.PORTAL, "void_rift");
	public static final Block WHITEWOOD_LOG = new BlockWhitewoodLog(Material.WOOD, "whitewood_log");
	public static final Block WHITEWOOD_LEAVES = new BlockWhitewoodLeaves(Material.PLANTS, "whitewood_leaves");
	public static final Block WHITEWOOD_PLANKS = new BlockWhitewoodPlanks(Material.WOOD, "whitewood_planks");
	public static final Block WHITEWOOD_STAIRS = new BlockWhitewoodStairs(WHITEWOOD_PLANKS.getDefaultState(), "whitewood_stairs");
}
