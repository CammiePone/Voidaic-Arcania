package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModDamageTypes;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber
public class PotionHandler 
{
	@SubscribeEvent
	public static void onPlayerAttack(AttackEntityEvent event)
	{
		EntityPlayer player = event.getEntityPlayer();
		
		if(event.getEntityPlayer() instanceof EntityPlayer)
		{
			if(player.isPotionActive(Main.LIFESTEAL))
			{
				player.heal(1.0F);
			}
		}
		
		if(event.getTarget() instanceof EntityPlayer)
		{
			EntityPlayer targetPlayer = (EntityPlayer) event.getTarget();
			
			if(player.isPotionActive(Main.VOIDTOUCH))
			{
				targetPlayer.attackEntityFrom(ModDamageTypes.VoidTouch, 2.0F);
			}
		}
		
		if(event.getTarget() instanceof EntityLiving)
		{
			EntityLiving targetMob = (EntityLiving) event.getTarget();
			
			if(player.isPotionActive(Main.VOIDTOUCH))
			{
				targetMob.attackEntityFrom(ModDamageTypes.VoidTouch, 2.0F);
			}
		}
	}
	
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		
		if(player.isPotionActive(Main.VOIDTOUCH) && !player.world.isRemote)
		{
			if(player.ticksExisted % 40 == 0)
			{
				EnumDifficulty difficulty = player.world.getDifficulty();
				
				if(difficulty.EASY != null || difficulty.NORMAL != null || difficulty.HARD != null || difficulty.PEACEFUL != null)
				{
					player.attackEntityFrom(ModDamageTypes.VoidTouch, 1.0F);
				}
			}
		}
	}
}
