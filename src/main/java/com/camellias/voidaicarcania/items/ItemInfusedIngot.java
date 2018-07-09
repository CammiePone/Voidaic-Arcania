package com.camellias.voidaicarcania.items;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ItemInfusedIngot extends Item implements IHasModel
{
	public ItemInfusedIngot(String name)
	{
		
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.metaltab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
