package com.camellias.voidaicarcania.core.init;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials
{
	public static final ArmorMaterial RESONATOR = EnumHelper.addArmorMaterial("void_resonator_material",
			Reference.MODID + ":void_resonator", 0, new int[]{0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);
}
