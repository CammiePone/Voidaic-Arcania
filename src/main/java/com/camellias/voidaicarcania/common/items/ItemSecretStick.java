package com.camellias.voidaicarcania.common.items;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSecretStick extends Item implements IHasModel
{
	public ItemSecretStick(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		stack.addEnchantment(Enchantment.getEnchantmentByID(19), 10);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
