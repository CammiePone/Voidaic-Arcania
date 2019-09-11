package com.camellias.voidaicarcania.common.blocks;

import com.camellias.voidaicarcania.core.init.ModItems;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;

public class BlockHalfSlabBase extends BlockSlabBase
{
	public BlockHalfSlabBase(Material material, String name, BlockSlab half, BlockSlab doubleSlab, String tool, int level, SoundType sound, float hardness, float resistance)
	{
		super(material, name, half);
		if(tool != null) this.setHarvestLevel(tool, level);
		this.setSoundType(sound);
		this.setHardness(hardness);
		this.setResistance(resistance);
		
		ModItems.ITEMS.add(new ItemSlab(this, this, doubleSlab).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean isDouble()
	{
		return false;
	}
}
