package com.camellias.voidaicarcania.core.handlers;

import java.util.UUID;

import com.camellias.voidaicarcania.api.capabilities.corruption.player.PlayerCorruptionCapability;
import com.camellias.voidaicarcania.common.entities.mobs.EntityKharonite;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class KharoniteTransformationHandler
{
	private static AttributeModifier health_attrib = new AttributeModifier(UUID.fromString("ccdec1ff-1a29-4229-9dfa-30f0d6072b4a"), "KHealth", 20, 0);
	private static AttributeModifier armour_attrib = new AttributeModifier(UUID.fromString("731f0315-7a37-43db-b8d5-493fb9d4cc81"), "KArmour", 10, 0);
	private static AttributeModifier damage_attrib = new AttributeModifier(UUID.fromString("6cf394bb-b874-4b15-af85-66ef0d885e65"), "KDamage", 9, 0);
	
	@SubscribeEvent
	public void handleAbilities(PlayerTickEvent event)
	{
		if(!event.player.world.isRemote)
		{
			EntityPlayer player = event.player;
			World world = player.world;
			boolean shouldHaveAttribs = (player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() >= 1200);
			
			//-----for debug purposes-----//
			if(!shouldHaveAttribs && !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty())
			{
				player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).setCorruption(player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() + 1);
			}
			
			if(shouldHaveAttribs)
			{
				//-----Do Sun Damage-----//
				if(player.isEntityUndead() && world.isDaytime() && !world.isRaining() && !player.capabilities.isCreativeMode)
				{
					float brightness = player.getBrightness();
					
					if(brightness > 0.5F && world.rand.nextFloat() * 30.0F < (brightness - 0.4F) * 2.0F &&
							world.canSeeSky(new BlockPos(player.posX,player.posY + (double) player.getEyeHeight(), player.posZ)))
					{
						player.setFire(8);
					}
				}
				
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
	
	@SubscribeEvent
	public void onPotionApplied(PotionApplicableEvent event)
	{
		if(!event.getEntityLiving().world.isRemote)
		{
			EntityLivingBase entity = event.getEntityLiving();
			World world = entity.world;
			
			//-----Disallow Kharonites From Having Potions-----//
			if(entity instanceof EntityPlayer)
			{
				boolean shouldHaveAttribs = (entity.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() >= 1200);
				
				if(shouldHaveAttribs)
				{
					event.setResult(Result.DENY);
				}
			}
			
			if(entity instanceof EntityKharonite)
			{
				event.setResult(Result.DENY);
			}
		}
	}
	
	@SubscribeEvent
	public void onAttack(LivingHurtEvent event)
	{
		if(!event.getEntityLiving().world.isRemote)
		{
			if(event.getSource().getImmediateSource() instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) event.getSource().getImmediateSource();
				World world = player.world;
				boolean shouldHaveAttribs = (player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() >= 1200);
				
				if(shouldHaveAttribs && !player.getHeldItemMainhand().isEmpty())
				{
					Item weapon = player.getHeldItemMainhand().getItem();
					
					for(AttributeModifier attributes : weapon.getItemAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()))
					{
						event.setAmount((float) (event.getAmount() - attributes.getAmount()));
					}
				}
			}
		}
	}
}
