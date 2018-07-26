package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ArmourEventsHandler
{
	@SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) 
	{
		EntityEquipmentSlot head = EntityEquipmentSlot.HEAD;
		EntityEquipmentSlot body = EntityEquipmentSlot.CHEST;
		EntityEquipmentSlot legs = EntityEquipmentSlot.LEGS;
		EntityEquipmentSlot feet = EntityEquipmentSlot.FEET;
		
		if(event.getEntityLiving() instanceof EntityLivingBase)
		{
			EntityLivingBase entity = event.getEntityLiving();
			
			if(entity.getItemStackFromSlot(head) == new ItemStack(ModItems.MYTHRIL_HELM)
					&& entity.getItemStackFromSlot(body) == new ItemStack(ModItems.MYTHRIL_CHEST)
					&& entity.getItemStackFromSlot(legs) == new ItemStack(ModItems.MYTHRIL_LEGS)
					&& entity.getItemStackFromSlot(feet) == new ItemStack(ModItems.MYTHRIL_BOOTS)
					&& event.getSource().isMagicDamage())
			{
				event.setAmount(event.getAmount() / 2.0F);
			}
		}
		
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			if(player.getItemStackFromSlot(head) == new ItemStack(ModItems.MYTHRIL_HELM)
					&& player.getItemStackFromSlot(body) == new ItemStack(ModItems.MYTHRIL_CHEST)
					&& player.getItemStackFromSlot(legs) == new ItemStack(ModItems.MYTHRIL_LEGS)
					&& player.getItemStackFromSlot(feet) == new ItemStack(ModItems.MYTHRIL_BOOTS)
					&& event.getSource().isMagicDamage())
			{
				event.setAmount(event.getAmount() / 2.0F);
			}
		}
	}
}
