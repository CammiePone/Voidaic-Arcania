package com.camellias.voidaicarcania.items;

import java.util.List;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ItemLunaOrb extends Item implements IHasModel
{
	public ItemLunaOrb(String name)
	{
		
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("\u00A76The light of the moon, encased in a crescent");
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
