package com.camellias.voidaicarcania.common.items;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.core.init.ModItems;
import com.camellias.voidaicarcania.core.util.IHasModel;

import net.minecraft.item.Item;

public class ItemWhitewoodStaff extends Item implements IHasModel
{
	public ItemWhitewoodStaff(String name)
	{
		this.setTranslationKey(name);         
		this.setRegistryName(name);
		this.maxStackSize = 1;
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
