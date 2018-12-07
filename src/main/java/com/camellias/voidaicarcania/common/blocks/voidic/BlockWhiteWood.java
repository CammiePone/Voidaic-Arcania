package com.camellias.voidaicarcania.common.blocks.voidic;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockWhiteWood extends BlockRotatedPillar implements IHasModel
{
	public BlockWhiteWood(String name, Material material) 
	{
		super(material);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(2.0F);
		this.setCreativeTab(Main.voidictab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
