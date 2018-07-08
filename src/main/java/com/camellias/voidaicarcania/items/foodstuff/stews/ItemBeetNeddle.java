package com.camellias.voidaicarcania.items.foodstuff.stews;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemBeetNeddle extends ItemSoup implements IHasModel
{
	public ItemBeetNeddle(String name, int healAmount)
	{
		super(healAmount);
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		if(!worldIn.isRemote)
		{
			player.attackEntityFrom(DamageSource.CACTUS, 1.0F);
		}
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
