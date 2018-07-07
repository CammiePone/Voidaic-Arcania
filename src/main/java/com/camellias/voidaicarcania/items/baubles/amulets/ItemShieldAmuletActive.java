package com.camellias.voidaicarcania.items.baubles.amulets;

import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.items.crystals.ItemStorageMid;
import com.camellias.voidaicarcania.items.crystals.ItemStorageStrong;
import com.camellias.voidaicarcania.items.crystals.ItemStorageWeak;

import baubles.api.BaublesApi;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemShieldAmuletActive extends ItemShieldAmulet
{
	int shieldRegen = 10 * 20;

	public ItemShieldAmuletActive(String name)
	{
		super(name);
		
		this.setMaxDamage(5);
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int itemSlot, boolean isSelected)
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack stack = this.findCrystals(player);
			
			if(player.inventory.hasItemStack(stack) && stack.getItemDamage() <= stack.getMaxDamage() - 1000)
			{
				if(itemstack.getItemDamage() <= 5 && itemstack.getItemDamage() != 0 && entity.ticksExisted % shieldRegen == 0)
				{
					itemstack.setItemDamage(itemstack.getItemDamage() - 1);
					stack.setItemDamage(stack.getItemDamage() + 1000);
				}
			}
		}
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player)
	{
		if(player instanceof EntityPlayer)
		{
			EntityPlayer player1 = (EntityPlayer) player;
			ItemStack stack = this.findCrystals(player1);
			
			if(player1.inventory.hasItemStack(stack) && stack.getItemDamage() <= stack.getMaxDamage() - 1000)
			{
				if(itemstack.getItemDamage() <= 5 && itemstack.getItemDamage() != 0 && player1.ticksExisted % shieldRegen == 0)
				{
					itemstack.setItemDamage(itemstack.getItemDamage() - 1);
					stack.setItemDamage(stack.getItemDamage() + 1000);
				}
			}
		}
	}
	
	private ItemStack findCrystals(EntityPlayer player)
    {
        if(this.isCrystal(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if(this.isCrystal(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for(int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
                
                if(itemstack.getItemDamage() < itemstack.getMaxDamage())
                {
                	if(this.isCrystal(itemstack))
                	{
                		return itemstack;
                	}
                }
            }
            
            return ItemStack.EMPTY;
        }
    }

    protected boolean isCrystal(ItemStack stack)
    {
        return stack.getItem() instanceof ItemStorageMid || stack.getItem() instanceof ItemStorageStrong;
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
