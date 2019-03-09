package com.camellias.voidaicarcania.api.capabilities.Corruption;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CorruptionProvider implements ICapabilitySerializable<NBTTagCompound>{

	private ICorruption capabilityCorruption = null;

	public CorruptionProvider() {
		this.capabilityCorruption = new DefaultCorruptionCapability();
	}

	public CorruptionProvider(ICorruption capability) {
		this.capabilityCorruption = capability;
	}

	@CapabilityInject(ICorruption.class)
	public static final Capability<ICorruption> corruptionCapability = null;

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == corruptionCapability;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if ((corruptionCapability != null) && (capability == corruptionCapability)) {
			return (T) this.capabilityCorruption;
		}
		return null;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		return this.capabilityCorruption.saveNBT();
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		this.capabilityCorruption.loadNBT(nbt);
	}
}