package com.camellias.voidaicarcania.common.items;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemDwarfBrick extends Item implements IHasModel
{
	public ItemDwarfBrick(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
