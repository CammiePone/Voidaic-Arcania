package com.camellias.voidaicarcania.common.items.spells;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;
import com.camellias.voidaicarcania.util.handlers.ConfigHandler;
import com.camellias.voidaicarcania.util.handlers.GuiHandler;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.camellias.voidaicarcania.util.handlers.GuiHandler;

public class ItemSpellBook extends Item implements IHasModel {

	public ItemSpellBook(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer p, EnumHand handIn, BlockPos pos)
	{    	
        ItemStack itemstack = p.getHeldItem(handIn);
        
        if(!world.isRemote) {
        	p.openGui(Main.instance, ConfigHandler.GUI_SPELLBOOK, world, pos.getX(), pos.getY(), pos.getZ());
        }
        
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
}
