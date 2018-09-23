package com.camellias.voidaicarcania.items.baubles.body;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFlightCloakActive extends ItemFlightCloak
{
	public ItemFlightCloakActive(String name)
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
