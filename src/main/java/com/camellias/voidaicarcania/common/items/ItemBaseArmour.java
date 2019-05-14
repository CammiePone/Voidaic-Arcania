package com.camellias.voidaicarcania.common.items;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.core.init.ModCreativeTabs;
import com.camellias.voidaicarcania.core.init.ModItems;
import com.camellias.voidaicarcania.core.util.IHasModel;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemBaseArmour extends ItemArmor implements IHasModel
{
	public ItemBaseArmour(String name, ArmorMaterial material, int index, EntityEquipmentSlot slot)
	{
		super(material, index, slot);
		this.setTranslationKey(Reference.MODID + "." + name);         
		this.setRegistryName(name);
		this.setCreativeTab(ModCreativeTabs.VA_TAB_MAIN);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
