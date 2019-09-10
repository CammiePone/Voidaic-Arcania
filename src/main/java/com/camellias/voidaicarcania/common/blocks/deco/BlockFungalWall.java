package com.camellias.voidaicarcania.common.blocks.deco;

import com.camellias.voidaicarcania.common.blocks.BlockBaseGeneric;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockFungalWall extends BlockBaseGeneric
{

	public BlockFungalWall(Material material, String name) 
	{
		super(material, name);
		this.setHardness(3.0F);
		this.setSoundType(SoundType.SLIME);
	}

}
