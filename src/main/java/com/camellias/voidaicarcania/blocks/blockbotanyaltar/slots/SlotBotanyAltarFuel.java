package com.camellias.voidaicarcania.blocks.blockbotanyaltar.slots;

import com.camellias.voidaicarcania.blocks.blockbotanyaltar.TileEntityBotanyAltar;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBotanyAltarFuel extends Slot
{
	public SlotBotanyAltarFuel(IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return TileEntityBotanyAltar.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack)
	{
		return super.getItemStackLimit(stack);
	}
}
