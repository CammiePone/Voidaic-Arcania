package com.camellias.voidaicarcania.api.capabilities.corruption.chunk;

import net.minecraft.nbt.NBTTagCompound;

public class DefaultChunkCorruptionCapability implements IChunkCorruption
{
	int corruption = -1;
	boolean corrupted = false;
	
	public DefaultChunkCorruptionCapability()
	{
		
	}
	
	public DefaultChunkCorruptionCapability(int amount, boolean value)
	{
		this.corruption = amount;
		this.corrupted = value;
	}
	
	@Override
	public boolean isCorrupted()
	{
		return this.corrupted;
	}
	
	@Override
	public void setCorrupted(boolean value)
	{
		if(this.corrupted != value)
		{
			this.corrupted = value;
		}
	}
	
	@Override
	public int getCorruption()
	{
		return this.corruption;
	}
	
	@Override
	public void setCorruption(int amount)
	{
		if(this.corruption != amount)
		{
			this.corruption = amount;
		}
	}
	
	@Override
	public NBTTagCompound saveNBT()
	{
		return (NBTTagCompound) ChunkCorruptionStorage.storage.writeNBT(ChunkCorruptionProvider.corruptionCapability, this, null);
	}
	
	@Override
	public void loadNBT(NBTTagCompound compound)
	{
		ChunkCorruptionStorage.storage.readNBT(ChunkCorruptionProvider.corruptionCapability, this, null, compound);
	}
}
