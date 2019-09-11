package com.camellias.voidaicarcania.common.blocks;

import com.camellias.voidaicarcania.core.init.ModItems;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;

public class BlockFullSlabBase extends BlockSlabBase
{
	public BlockFullSlabBase(Material material, String name, BlockSlab half)
	{
		super(material, name, half);
		this.setTranslationKey(name);
		this.setRegistryName(name);
		ModItems.ITEMS.add(new ItemSlab(this, half, this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean isDouble()
	{
		return true;
	}
}
