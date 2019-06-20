package com.camellias.voidaicarcania.common.tileentities.altar;

import com.camellias.voidaicarcania.core.network.NetworkHandler;
import com.camellias.voidaicarcania.core.network.packets.SyncTileToClientMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileWhitewoodPedestal extends TileEntity
{
	public static final int SLOTS = 1;
	
	public ItemStackHandler handler = new ItemStackHandler(SLOTS)
	{
		@Override
		protected void onContentsChanged(int slot)
		{
			for(EntityPlayer player : world.playerEntities)
			{
				if(player instanceof EntityPlayerMP)
				{
					EntityPlayerMP players = (EntityPlayerMP) player;
					
					NetworkHandler.INSTANCE.sendTo(new SyncTileToClientMessage(handler.getStackInSlot(0)), players);
				}
			}
			
			TileWhitewoodPedestal.this.markDirty();
		}
	};
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		if(nbt.hasKey("items"))
		{
			handler.deserializeNBT((NBTTagCompound) nbt.getTag("items"));
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setTag("items", handler.serializeNBT());
		
		return nbt;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return true;
		}
		
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(handler);
		}
		
		return super.getCapability(capability, facing);
	}
	
	public boolean canInteractWith(EntityPlayer player)
	{
		return !isInvalid() && player.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	}
}
