package com.camellias.voidaicarcania.common.items.tools.sword;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class MythrilSword extends ItemSword implements IHasModel
{
	public MythrilSword(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.voidictab);
		
		ModItems.ITEMS.add(this);
	}
	
	/*@SubscribeEvent
	public static void onAttack(AttackEntityEvent event)
	{
		EntityPlayer player = event.getEntityPlayer();
		EntityLivingBase target = (EntityLivingBase) event.getTarget();
		
		if(player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ModItems.MYTHRIL_SWORD)
		{
			target.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE));
			
			System.out.println("Mythril Sword Attack");
		}
	}*/
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
