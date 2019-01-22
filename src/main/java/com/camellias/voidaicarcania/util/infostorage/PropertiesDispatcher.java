package com.camellias.voidaicarcania.util.infostorage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PropertiesDispatcher implements ICapabilitySerializable<NBTTagCompound>
{
	private VoidCorruptionCapability playerCorruption = new VoidCorruptionCapability();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == PlayerProperties.VOID_CORRUPTION;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if(capability == PlayerProperties.VOID_CORRUPTION)
		{
			return (T) playerCorruption;
		}
		
		return null;
	}
	
	@Override
	public NBTTagCompound serializeNBT()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		playerCorruption.writeToNBT(nbt);
		
		return nbt;
	}
	
	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		playerCorruption.readFromNBT(nbt);
	}
}
