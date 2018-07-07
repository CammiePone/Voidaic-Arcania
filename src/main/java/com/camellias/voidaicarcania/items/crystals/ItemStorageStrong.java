package com.camellias.voidaicarcania.items.crystals;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.items.ItemVoidCrystal;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemStorageStrong extends Item implements IHasModel
{
	public ItemStorageStrong(String name)
	{
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		this.setMaxDamage(5000);
		this.setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		if (!world.isRemote)
        {
        	ItemStack itemstack = player.getHeldItem(hand);
        	ItemStack stack = this.findRepair(player);
            
            if(player.inventory.hasItemStack(stack) && itemstack.getItemDamage() != 0)
            {
            	setDamage(itemstack, getDamage(itemstack) - 100);
            	stack.shrink(1);
            }
        }
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
	
	private ItemStack findRepair(EntityPlayer player)
    {
        if(this.isCrystal(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if(this.isCrystal(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for(int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
                
                if(this.isCrystal(itemstack))
                {
                	return itemstack;
                }
            }
            
            return ItemStack.EMPTY;
        }
    }

    protected boolean isCrystal(ItemStack stack)
    {
        return stack.getItem() instanceof ItemVoidCrystal;
    }
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
