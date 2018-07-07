package com.camellias.voidaicarcania.items.baubles.amulets;

import com.camellias.voidaicarcania.items.crystals.ItemStorageMid;
import com.camellias.voidaicarcania.items.crystals.ItemStorageStrong;
import com.camellias.voidaicarcania.items.crystals.ItemStorageWeak;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;

public class ItemInverseAmuletActive extends ItemInverseAmulet
{
	public ItemInverseAmuletActive(String name)
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
			
			if(player1.inventory.hasItemStack(stack))
			{
				if(player.isPotionActive(MobEffects.POISON) || player.isPotionActive(MobEffects.WITHER) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20 * 15, 1, true, true));
					player.removePotionEffect(MobEffects.POISON);
					player.removePotionEffect(MobEffects.WITHER);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
				}
				
				if(player.isPotionActive(MobEffects.BLINDNESS) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20 * 15, 1, true, true));
					player.removePotionEffect(MobEffects.BLINDNESS);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
				}
				
				if(player.isPotionActive(MobEffects.HUNGER) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 20 * 15, 1, true, true));
					player.removePotionEffect(MobEffects.HUNGER);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
				}
			
				if(player.isPotionActive(MobEffects.MINING_FATIGUE) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 20 * 15, 1, true, true));
					player.removePotionEffect(MobEffects.MINING_FATIGUE);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
				}
				
				if(player.isPotionActive(MobEffects.SLOWNESS) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20 * 15, 1, true, true));
					player.removePotionEffect(MobEffects.SLOWNESS);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
				}
				
				if(player.isPotionActive(MobEffects.UNLUCK) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 20 * 15, 1, true, true));
					player.removePotionEffect(MobEffects.UNLUCK);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
				}
				
				if(player.isPotionActive(MobEffects.WEAKNESS) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 * 15, 1, true, true));
					player.removePotionEffect(MobEffects.WEAKNESS);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
				}
				
				if(player.isPotionActive(MobEffects.GLOWING) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20 * 15, 1, true, true));
					player.removePotionEffect(MobEffects.GLOWING);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
				}
				
				if(player.isPotionActive(MobEffects.NAUSEA) && stack.getItemDamage() <= stack.getMaxDamage() - 100)
				{
					player.removePotionEffect(MobEffects.NAUSEA);
					
					stack.setItemDamage(stack.getItemDamage() + 100);
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
        return stack.getItem() instanceof ItemStorageWeak || stack.getItem() instanceof ItemStorageMid || stack.getItem() instanceof ItemStorageStrong;
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
}
