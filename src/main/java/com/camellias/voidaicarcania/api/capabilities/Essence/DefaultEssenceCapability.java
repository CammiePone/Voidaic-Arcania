package com.camellias.voidaicarcania.api.capabilities.essence;

import net.minecraft.nbt.NBTTagCompound;

public class DefaultEssenceCapability implements IEssence {

	int essence = -1;
	boolean on = false;

	public DefaultEssenceCapability(){

	}

	public DefaultEssenceCapability(int type, boolean on) {
		this.essence = type;
		this.on = on;
	}

	@Override
	public boolean effect() {
		return this.on;
	}

	@Override
	public void setEffect(boolean on) {
		if(this.on != on) {
			this.on = on;
		}
	}
	@Override
	public int getEssence() {
		return this.essence;
	}

	@Override
	public void setEssence(int type) {
		if (this.essence != type) {
			this.essence = type;
		}
	}

	@Override
	public NBTTagCompound saveNBT() {
		return (NBTTagCompound) EssenceStorage.storage.writeNBT(EssenceProvider.essenceCapability, this, null);
	}

	@Override
	public void loadNBT(NBTTagCompound compound) {
		EssenceStorage.storage.readNBT(EssenceProvider.essenceCapability, this, null, compound);
	}
}
