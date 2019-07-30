package com.camellias.voidaicarcania.core.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.common.items.ItemBaseGeneric;
import com.camellias.voidaicarcania.common.items.magic.ItemVoidDetector;
import com.camellias.voidaicarcania.common.items.magic.ItemWhitewoodStaff;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

public class ModItems 
{
	//-----Item list-----//
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item WHITEWOOD_STAFF = new ItemWhitewoodStaff("whitewood_staff");
	public static final Item VOID_RESONATOR = new ItemVoidDetector("void_resonator", ModMaterials.RESONATOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item SPELL_PAPER = new ItemBaseGeneric("spell_paper");
}
