package com.camellias.voidaicarcania.api.capabilities.infused;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class InfusedProvider implements ICapabilitySerializable<NBTTagCompound>{

	private IInfused capabilityInfused = null;

	public InfusedProvider() {
		this.capabilityInfused = new DefaultInfusedCapability();
	}

	public InfusedProvider(IInfused capability) {
		this.capabilityInfused = capability;
	}

	@CapabilityInject(IInfused.class)
	public static final Capability<IInfused> infusedCapability = null;

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == infusedCapability;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if ((infusedCapability != null) && (capability == infusedCapability)) {
			return (T) this.capabilityInfused;
		}
		return null;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		return this.capabilityInfused.saveNBT();
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		this.capabilityInfused.loadNBT(nbt);
	}
}