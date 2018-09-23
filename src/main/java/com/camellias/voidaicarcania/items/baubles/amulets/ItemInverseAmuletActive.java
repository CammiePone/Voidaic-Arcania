package com.camellias.voidaicarcania.items.baubles.amulets;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInverseAmuletActive extends ItemInverseAmulet
{
	public ItemInverseAmuletActive(String name)
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
			
			if(player.isPotionActive(MobEffects.POISON) || player.isPotionActive(MobEffects.WITHER))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20 * 15, 1, true, true));
				player.removePotionEffect(MobEffects.POISON);
			}
			
			if(player.isPotionActive(MobEffects.BLINDNESS))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20 * 15, 1, true, true));
				player.removePotionEffect(MobEffects.BLINDNESS);
			}
			
			if(player.isPotionActive(MobEffects.HUNGER))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 20 * 15, 1, true, true));
				player.removePotionEffect(MobEffects.HUNGER);
			}
			
			if(player.isPotionActive(MobEffects.MINING_FATIGUE))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 20 * 15, 1, true, true));
				player.removePotionEffect(MobEffects.MINING_FATIGUE);
			}
			
			if(player.isPotionActive(MobEffects.SLOWNESS))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20 * 15, 1, true, true));
				player.removePotionEffect(MobEffects.SLOWNESS);
			}
			
			if(player.isPotionActive(MobEffects.UNLUCK))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 20 * 15, 1, true, true));
				player.removePotionEffect(MobEffects.UNLUCK);
			}
			
			if(player.isPotionActive(MobEffects.WEAKNESS))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 * 15, 1, true, true));
				player.removePotionEffect(MobEffects.WEAKNESS);
			}
			
			if(player.isPotionActive(MobEffects.GLOWING))
			{
				player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20 * 15, 1, true, true));
				player.removePotionEffect(MobEffects.GLOWING);
			}
			
			if(player.isPotionActive(MobEffects.NAUSEA))
			{
				player.removePotionEffect(MobEffects.NAUSEA);
			}
		}
	}
}
