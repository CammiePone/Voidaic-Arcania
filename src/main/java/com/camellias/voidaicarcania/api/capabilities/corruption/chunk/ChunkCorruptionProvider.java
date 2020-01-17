package com.camellias.voidaicarcania.api.capabilities.corruption.chunk;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ChunkCorruptionProvider implements ICapabilitySerializable<NBTTagCompound>
{
	private IChunkCorruption capabilityCorruption = null;
	
	public ChunkCorruptionProvider()
	{
		this.capabilityCorruption = new DefaultChunkCorruptionCapability();
	}
	
	public ChunkCorruptionProvider(IChunkCorruption capability)
	{
		this.capabilityCorruption = capability;
	}
	
	@CapabilityInject(IChunkCorruption.class)
	public static final Capability<IChunkCorruption> corruptionCapability = null;
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == corruptionCapability;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if((corruptionCapability != null) && (capability == corruptionCapability))
		{
			return (T) this.capabilityCorruption;
		}
		
		return null;
	}
	
	@Override
	public NBTTagCompound serializeNBT()
	{
		return this.capabilityCorruption.saveNBT();
	}
	
	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		this.capabilityCorruption.loadNBT(nbt);
	}
}
