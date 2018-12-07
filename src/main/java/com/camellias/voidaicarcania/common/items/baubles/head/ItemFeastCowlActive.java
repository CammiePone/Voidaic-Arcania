package com.camellias.voidaicarcania.common.items.baubles.head;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import org.jline.utils.Log;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFeastCowlActive extends ItemFeastCowl
{
	UUID uuid = UUID.fromString("4fbfb7c8-b92a-43d5-8e04-5855851ee77b");
	
	public static final Field saturationLevel = ObfuscationReflectionHelper.findField(FoodStats.class, "field_75125_b");
	
	public ItemFeastCowlActive(String name)
	{
		super(name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("\u00A7aActivated");
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
			FoodStats food = player1.getFoodStats();
			
			if(player1.ticksExisted % 100 == 0)
			{
				food.setFoodLevel(20);
				
				if(food.getSaturationLevel() == 0)
				{
					try
					{
						saturationLevel.set(food, 10);
					}
					catch(IllegalAccessException e)
					{
						Log.error("Reflection on Player Saturation Level Failed");
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player)
	{
		if(!player.world.isRemote)
		{
			Multimap<String, AttributeModifier> attributes = HashMultimap.create();
			
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(uuid, "Feast Cowl", -2, 0));
			player.getAttributeMap().applyAttributeModifiers(attributes);
		}
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
	{
		if(!player.world.isRemote)
		{
			Multimap<String, AttributeModifier> attributes = HashMultimap.create();
			
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(uuid, "Feast Cowl", -2, 0));
			player.getAttributeMap().removeAttributeModifiers(attributes);
		}
	}
}
