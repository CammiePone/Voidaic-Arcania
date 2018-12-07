package com.camellias.voidaicarcania.common.blocks.machines.blockmortalcentrifuge.slots;

import com.camellias.voidaicarcania.common.blocks.machines.blockmortalcentrifuge.TileEntityMortalCentrifuge;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMortalCentrifugeFuel extends Slot
{
	public SlotMortalCentrifugeFuel(IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return TileEntityMortalCentrifuge.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack)
	{
		return super.getItemStackLimit(stack);
	}
}
