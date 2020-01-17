package com.camellias.voidaicarcania.api.capabilities.infused;

import net.minecraft.nbt.NBTTagCompound;

public class DefaultInfusedCapability implements IInfused {

	boolean infused = false;

	public DefaultInfusedCapability(){

	}

	public DefaultInfusedCapability(boolean value) {
		this.infused = value;
	}

	@Override
	public boolean infused() {
		return this.infused;
	}

	@Override
	public void setInfused(boolean value) {
		if(this.infused != value) {
			this.infused = value;
		}
	}

	@Override
	public NBTTagCompound saveNBT() {
		return (NBTTagCompound) InfusedStorage.storage.writeNBT(InfusedProvider.infusedCapability, this, null);
	}

	@Override
	public void loadNBT(NBTTagCompound compound) {
		InfusedStorage.storage.readNBT(InfusedProvider.infusedCapability, this, null, compound);
	}
}
