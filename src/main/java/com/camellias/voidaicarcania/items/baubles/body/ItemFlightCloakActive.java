package com.camellias.voidaicarcania.items.baubles.body;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlightCloakActive extends ItemFlightCloak
{
	public ItemFlightCloakActive(String name)
	{
		super(name);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return true;
	}
		
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player)
	{
		if(player instanceof EntityPlayer)
		{
			EntityPlayer player1 = (EntityPlayer) player;
			
			player.fallDistance = 0.0F;
			player1.capabilities.allowFlying = true;
		}
	}
	
	/*@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player)
	{
		player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() - 2);
	}*/
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
	{
		if(player instanceof EntityPlayer)
		{
			EntityPlayer player1 = (EntityPlayer) player;
			
			if(!player1.capabilities.isCreativeMode)
			{
				player1.capabilities.allowFlying = false;
				player1.capabilities.isFlying = false;
			}
		}
		
		//player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() + 2);
	}
}
