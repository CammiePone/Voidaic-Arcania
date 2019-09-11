package com.camellias.voidaicarcania.common.blocks;

import com.camellias.voidaicarcania.core.init.ModItems;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;

public class BlockHalfSlabBase extends BlockSlabBase
{
	public BlockHalfSlabBase(Material material, String name, BlockSlab half, BlockSlab doubleSlab)
	{
		super(material, name, half);
		this.setTranslationKey(name);
		this.setRegistryName(name);
		ModItems.ITEMS.add(new ItemSlab(this, this, doubleSlab).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean isDouble()
	{
		return false;
	}
}
