package com.camellias.voidaicarcania.items.foodstuff.cookies;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCookieFeather extends ItemFood implements IHasModel
{
	public ItemCookieFeather(String name, int healAmount)
	{
		super(healAmount, false);
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		if(!worldIn.isRemote)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 5*20, 5, false, true));
		}
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
