package com.camellias.voidaicarcania.items.baubles.charms;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLuckCharmActive extends ItemLuckCharm
{
	public ItemLuckCharmActive(String name)
	{
		super(name);
		
		this.setMaxDamage(1);
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
