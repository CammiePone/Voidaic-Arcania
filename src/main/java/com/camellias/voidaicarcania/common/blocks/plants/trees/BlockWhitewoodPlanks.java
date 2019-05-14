package com.camellias.voidaicarcania.common.blocks.plants.trees;

import com.camellias.voidaicarcania.common.blocks.BlockBaseGeneric;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWhitewoodPlanks extends BlockBaseGeneric
{
	public BlockWhitewoodPlanks(Material material, String name) 
	{
		super(material, name);
		this.setHardness(2.0F);
		this.setSoundType(SoundType.WOOD);
	}
}
