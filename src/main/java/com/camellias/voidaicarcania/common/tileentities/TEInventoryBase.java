package com.camellias.voidaicarcania.common.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

public class TEInventoryBase extends TEGeneric implements ISidedInventory, ITickable
{
	private NonNullList<ItemStack> stacks = NonNullList.withSize(1, ItemStack.EMPTY);
	protected int[] syncedSlots = new int[0];
	private NonNullList<ItemStack> syncedStacks = NonNullList.withSize(1, ItemStack.EMPTY);
	protected String customName;
	private int[] faceSlots;
	
	public TEInventoryBase(int size)
	{
		stacks = NonNullList.withSize(size, ItemStack.EMPTY);
		syncedStacks = NonNullList.withSize(size, ItemStack.EMPTY);
		faceSlots = new int[size];
		
		for (int a = 0; a < size; a++)
		{
			faceSlots[a] = a;
		}
	}
	
	public ItemStack getSyncedStackInSlot(int index)
	{
		return (ItemStack) syncedStacks.get(index);
	}
	
	private boolean isSyncedSlot(int slot)
	{
		for(int s : syncedSlots)
		{
			if(s == slot) return true;
		}
		
		return false;
	}
	
	protected void syncSlots(EntityPlayerMP player)
	{
		if (syncedSlots.length > 0)
		{
			NBTTagCompound nbt = new NBTTagCompound();
			NBTTagList nbttaglist = new NBTTagList();
			
			for (int i = 0; i < stacks.size(); i++)
			{
				if ((!((ItemStack)stacks.get(i)).isEmpty()) && (isSyncedSlot(i)))
				{
					NBTTagCompound nbttagcompound1 = new NBTTagCompound();
					nbttagcompound1.setByte("Slot", (byte)i);
					((ItemStack)stacks.get(i)).writeToNBT(nbttagcompound1);
					nbttaglist.appendTag(nbttagcompound1);
				}
			}
			
			nbt.setTag("ItemsSynced", nbttaglist);
			sendMessageToClient(nbt, player);
		}
	}
	
	public void syncTile(boolean rerender)
	{
		super.syncTile(rerender);
		syncSlots(null);
	}
	
	public void messageFromClient(NBTTagCompound nbt, EntityPlayerMP player)
	{
		super.messageFromClient(nbt, player);
		if (nbt.hasKey("requestSync")) {
			syncSlots(player);
		}
	}
	
	public void messageFromServer(NBTTagCompound nbt)
	{
		super.messageFromServer(nbt);
		if (nbt.hasKey("ItemsSynced")) {
			syncedStacks = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
			NBTTagList nbttaglist = nbt.getTagList("ItemsSynced", 10);
			for (int i = 0; i < nbttaglist.tagCount(); i++)
			{
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				byte b0 = nbttagcompound1.getByte("Slot");
				if (isSyncedSlot(b0)) {
					syncedStacks.set(b0, new ItemStack(nbttagcompound1));
				}
			}
		}
	}
	
	@Override
	public int getSizeInventory()
	{
		return 0;
	}
	
	@Override
	public boolean isEmpty()
	{
		return false;
	}
	
	@Override
	public ItemStack getStackInSlot(int index)
	{
		return null;
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		return null;
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		return null;
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 0;
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player)
	{
		return false;
	}
	
	@Override
	public void openInventory(EntityPlayer player)
	{
		
	}
	
	@Override
	public void closeInventory(EntityPlayer player)
	{
		
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return false;
	}
	
	@Override
	public int getField(int id)
	{
		return 0;
	}
	
	@Override
	public void setField(int id, int value)
	{
		
	}
	
	@Override
	public int getFieldCount()
	{
		return 0;
	}
	
	@Override
	public void clear()
	{
		
	}
	
	@Override
	public String getName()
	{
		return null;
	}
	
	@Override
	public boolean hasCustomName()
	{
		return false;
	}
	
	@Override
	public void update()
	{
		
	}
	
	@Override
	public int[] getSlotsForFace(EnumFacing side)
	{
		return null;
	}
	
	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
		return false;
	}
	
	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
	{
		return false;
	}
}
