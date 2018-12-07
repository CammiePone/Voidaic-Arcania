package com.camellias.voidaicarcania.common.items.baubles.belts;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStrengthBeltActive extends ItemStrengthBelt
{
	UUID uuid = UUID.fromString("5017c7e0-413a-4023-b569-afcf57dbec18");
	
	public ItemStrengthBeltActive(String name)
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
	public void onEquipped(ItemStack itemstack, EntityLivingBase player)
	{
		if(!player.world.isRemote)
		{
			Multimap<String, AttributeModifier> attributes = HashMultimap.create();
			
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(uuid, "Strength Health", -2, 0));
			attributes.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(uuid, "Strength Belt", 10, 0));
			player.getAttributeMap().applyAttributeModifiers(attributes);
		}
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
	{
		if(!player.world.isRemote)
		{
			Multimap<String, AttributeModifier> attributes = HashMultimap.create();
			
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(uuid, "Strength Health", -2, 0));
			attributes.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(uuid, "Strength Belt", 10, 0));
			player.getAttributeMap().removeAttributeModifiers(attributes);
		}
	}
}
