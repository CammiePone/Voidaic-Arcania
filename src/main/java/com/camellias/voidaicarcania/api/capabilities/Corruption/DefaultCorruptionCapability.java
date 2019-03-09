package com.camellias.voidaicarcania.api.capabilities.Corruption;

import net.minecraft.nbt.NBTTagCompound;

public class DefaultCorruptionCapability implements ICorruption {

	int corruption = -1;
	boolean corrupted = false;

	public DefaultCorruptionCapability(){

	}

	public DefaultCorruptionCapability(int amount, boolean value) {
		this.corruption = amount;
		this.corrupted = value;
	}

	@Override
	public boolean corrupted() {
		return this.corrupted;
	}

	@Override
	public void setCorrupted(boolean value) {
		if(this.corrupted != value) {
			this.corrupted = value;
		}
	}
	@Override
	public int corruption() {
		return this.corruption;
	}

	@Override
	public void setCorruption(int amount) {
		if (this.corruption != amount) {
			this.corruption = amount;
		}
	}

	@Override
	public NBTTagCompound saveNBT() {
		return (NBTTagCompound) CorruptionStorage.storage.writeNBT(CorruptionProvider.corruptionCapability, this, null);
	}

	@Override
	public void loadNBT(NBTTagCompound compound) {
		CorruptionStorage.storage.readNBT(CorruptionProvider.corruptionCapability, this, null, compound);
	}
}
