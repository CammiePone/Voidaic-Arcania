package com.camellias.voidaicarcania.items.baubles.amulets;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShieldAmuletActive extends ItemShieldAmulet
{
	int shieldRegen = 10 * 20;

	public ItemShieldAmuletActive(String name)
	{
		super(name);
		
		this.setMaxDamage(3);
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int itemSlot, boolean isSelected)
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			
			if(itemstack.getItemDamage() <= 3 && itemstack.getItemDamage() != 0 && entity.ticksExisted % shieldRegen == 0)
			{
				itemstack.setItemDamage(itemstack.getItemDamage() - 1);
			}
		}
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player)
	{
		if(player instanceof EntityPlayer)
		{
			EntityPlayer player1 = (EntityPlayer) player;
			
			if(itemstack.getItemDamage() <= 3 && itemstack.getItemDamage() != 0 && player.ticksExisted % shieldRegen == 0)
			{
				itemstack.setItemDamage(itemstack.getItemDamage() - 1);
			}
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return true;
	}
	
	/*@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player)
	{
		player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() - 2);
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
	{
		player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() + 2);
	}*/
	
	public static boolean isUsable(ItemStack stack)
    {
        return stack.getItemDamage() < stack.getMaxDamage() - 1;
    }
}
