package com.camellias.voidaicarcania.core.handlers;

import java.util.UUID;

import com.camellias.voidaicarcania.api.capabilities.corruption.player.PlayerCorruptionCapability;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class KharoniteTransformationHandler
{
	private static AttributeModifier health_attrib = new AttributeModifier(UUID.fromString("ccdec1ff-1a29-4229-9dfa-30f0d6072b4a"), "KHealth", 20, 0);
	private static AttributeModifier armour_attrib = new AttributeModifier(UUID.fromString("731f0315-7a37-43db-b8d5-493fb9d4cc81"), "KArmour", 10, 0);
	private static AttributeModifier damage_attrib = new AttributeModifier(UUID.fromString("6cf394bb-b874-4b15-af85-66ef0d885e65"), "KDamage", 3, 0);
	
	@SubscribeEvent
	public void handleAbilities(PlayerTickEvent event)
	{
		if(!event.player.world.isRemote)
		{
			EntityPlayer player = event.player;
			
			if(!player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && event.phase == Phase.START)
			{
				if(player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() < 1200)
				{
					player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).setCorruption(player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() + 1);
				}
			}
			
			boolean shouldHaveAttribs = (player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() >= 1200);
			
			if(shouldHaveAttribs)
			{
				//-----Apply Attributes-----//
				if(player.ticksExisted % 20 == 0 && !player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(health_attrib))
				{
					player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(health_attrib);
					player.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(armour_attrib);
					player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(damage_attrib);
				}
				
				//-----Armour Handling-----//
				if(player.hasItemInSlot(EntityEquipmentSlot.HEAD) || player.hasItemInSlot(EntityEquipmentSlot.CHEST) ||
						player.hasItemInSlot(EntityEquipmentSlot.LEGS) || player.hasItemInSlot(EntityEquipmentSlot.FEET))
				{
					ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
					ItemStack body = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
					ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
					ItemStack feet = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
					
					player.entityDropItem(head, 1);
					player.entityDropItem(body, 1);
					player.entityDropItem(legs, 1);
					player.entityDropItem(feet, 1);
					player.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.AIR));
					player.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.AIR));
					player.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.AIR));
					player.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.AIR));
				}
			}
			else if(player.ticksExisted % 20 == 0 && player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(health_attrib))
			{
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(health_attrib);
				player.getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(armour_attrib);
				player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).removeModifier(damage_attrib);
			}
		}
	}
}
