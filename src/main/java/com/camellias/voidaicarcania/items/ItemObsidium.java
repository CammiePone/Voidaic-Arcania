package com.camellias.voidaicarcania.items;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.item.Item;

public class ItemObsidium extends Item implements IHasModel
{
	public ItemObsidium(String name)
	{
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.metaltab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
