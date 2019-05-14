package com.camellias.voidaicarcania.common.blocks.plants.trees;

import com.camellias.voidaicarcania.common.blocks.BlockBaseStairs;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;

public class BlockWhitewoodStairs extends BlockBaseStairs
{
	public BlockWhitewoodStairs(IBlockState state, String name) 
	{
		super(state, name);
		this.setHardness(2.0F);
		this.setSoundType(SoundType.WOOD);
	}
}
