package com.camellias.voidaicarcania.init;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.enchants.EnchantAlchemy;
import com.camellias.voidaicarcania.enchants.EnchantCloudStep;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModEnchants
{
	public static final Enchantment ALCHEMY = new EnchantAlchemy("enchant_alchemy", Rarity.VERY_RARE, EntityEquipmentSlot.MAINHAND);
	
	public static final Enchantment CLOUDSTEP = new EnchantCloudStep("enchant_cloudstep", Rarity.VERY_RARE, EntityEquipmentSlot.FEET);
	
	@SubscribeEvent
	public static void registerEnchants(Register<Enchantment> event)
	{
		event.getRegistry().registerAll(ALCHEMY, CLOUDSTEP);
	}
}
