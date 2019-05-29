package com.camellias.voidaicarcania.common.blocks.plants.trees;

import com.camellias.voidaicarcania.common.blocks.BlockBaseRotateable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWhitewoodLog extends BlockBaseRotateable
{
	public BlockWhitewoodLog(Material material, String name)
	{
		super(material, name);
		this.setHardness(2.0F);
		this.setSoundType(SoundType.WOOD);
	}
}
