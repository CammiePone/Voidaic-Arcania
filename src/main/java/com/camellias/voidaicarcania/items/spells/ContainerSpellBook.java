package com.camellias.voidaicarcania.items.spells;

import com.camellias.voidaicarcania.blocks.blockaltar.TileEntityAltar;
import com.camellias.voidaicarcania.blocks.blockaltar.slots.SlotAltarFuel;
import com.camellias.voidaicarcania.blocks.blockaltar.slots.SlotAltarOutput;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerSpellBook extends Container
{
	private final TileEntitySpellBook tileentity;
	
	public ContainerSpellBook(InventoryPlayer player, TileEntitySpellBook tileEntitySpellBook) 
	{
		this.tileentity = tileEntitySpellBook;
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(player, x + y*9 + 9, 8 + x*18, 84 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return true;
	}
}
