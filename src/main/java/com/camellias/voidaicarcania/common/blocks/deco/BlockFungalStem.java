package com.camellias.voidaicarcania.common.blocks.deco;

import com.camellias.voidaicarcania.common.blocks.BlockBaseRotateable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockFungalStem extends BlockBaseRotateable
{
	public BlockFungalStem(Material material, String name)
	{
		super(material, name);
		this.setHardness(2.0F);
		this.setLightLevel(0.3F);
		this.setSoundType(SoundType.SLIME);
	}
}
