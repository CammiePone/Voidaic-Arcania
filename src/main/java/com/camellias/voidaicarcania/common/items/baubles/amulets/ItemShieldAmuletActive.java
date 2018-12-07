package com.camellias.voidaicarcania.common.items.baubles.amulets;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShieldAmuletActive extends ItemShieldAmulet
{
	UUID uuid = UUID.fromString("53b8bb16-f51b-417f-8c67-07c5e590231f");

	public ItemShieldAmuletActive(String name)
	{
		super(name);
		
		//this.setMaxDamage(3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("\u00A7aActivated");
	}
	
	/*@Override
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
	}*/
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player)
	{
		if(!player.world.isRemote)
		{
			Multimap<String, AttributeModifier> attributes = HashMultimap.create();
			
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(uuid, "Shield Amulet", -2, 0));
			player.getAttributeMap().applyAttributeModifiers(attributes);
		}
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
	{
		if(!player.world.isRemote)
		{
			Multimap<String, AttributeModifier> attributes = HashMultimap.create();
			
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(uuid, "Shield Amulet", -2, 0));
			player.getAttributeMap().removeAttributeModifiers(attributes);
		}
	}
	
	/*public static boolean isUsable(ItemStack stack)
    {
        return stack.getItemDamage() < stack.getMaxDamage() - 1;
    }*/
}
