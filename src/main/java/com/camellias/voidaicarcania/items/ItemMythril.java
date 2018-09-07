package com.camellias.voidaicarcania.items;

import java.util.List;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ItemMythril extends Item implements IHasModel
{
	public ItemMythril(String name)
	{
		
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.metaltab);
		
		ModItems.ITEMS.add(this);
	}
	
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("\u00A76A strong, arcane alloy");
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
