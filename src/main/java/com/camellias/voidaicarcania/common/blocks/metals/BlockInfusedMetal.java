package com.camellias.voidaicarcania.common.blocks.metals;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockInfusedMetal extends Block implements IHasModel
{
	public BlockInfusedMetal(String name, Material material) 
	{
		super(material);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(5.0F);
		this.setResistance(30.0F);
		this.setHarvestLevel("pickaxe", 2);
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
