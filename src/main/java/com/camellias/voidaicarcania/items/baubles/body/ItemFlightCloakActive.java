package com.camellias.voidaicarcania.items.baubles.body;

import com.camellias.voidaicarcania.items.crystals.ItemStorageMid;
import com.camellias.voidaicarcania.items.crystals.ItemStorageStrong;
import com.camellias.voidaicarcania.items.crystals.ItemStorageWeak;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

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
			ItemStack stack = this.findCrystals(player1);
			
			player.fallDistance = 0.0F;
			
			if(player1.inventory.hasItemStack(stack))
			{
				player1.capabilities.allowFlying = true;
				
				if(player1.capabilities.isFlying && player1.ticksExisted % 80 == 0 && stack.getItemDamage() <= stack.getMaxDamage() - 50)
				{
					stack.setItemDamage(stack.getItemDamage() + 50);
				}
			}
			else
			{
				player1.capabilities.allowFlying = false;
				player1.capabilities.isFlying = false;
			}
		}
	}
	
	private ItemStack findCrystals(EntityPlayer player)
    {
        if (this.isCrystal(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isCrystal(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
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
        return stack.getItem() instanceof ItemStorageWeak || stack.getItem() instanceof ItemStorageMid || stack.getItem() instanceof ItemStorageStrong;
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
