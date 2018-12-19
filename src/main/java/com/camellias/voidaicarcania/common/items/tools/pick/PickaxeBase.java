package com.camellias.voidaicarcania.common.items.tools.pick;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.item.ItemPickaxe;

public class PickaxeBase extends ItemPickaxe implements IHasModel
{
	public PickaxeBase(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.voidictab);
		setHarvestLevel("pickaxe", 3);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
