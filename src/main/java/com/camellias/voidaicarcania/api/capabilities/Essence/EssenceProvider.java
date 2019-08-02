package com.camellias.voidaicarcania.api.capabilities.Essence;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class EssenceProvider implements ICapabilitySerializable<NBTTagCompound>{

	private IEssence capabilityItem = null;

	public EssenceProvider() {
		this.capabilityItem = new DefaultEssenceCapability();
	}

	public EssenceProvider(IEssence capability) {
		this.capabilityItem = capability;
	}

	@CapabilityInject(IEssence.class)
	public static final Capability<IEssence> essenceCapability = null;

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == essenceCapability;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if ((essenceCapability != null) && (capability == essenceCapability)) {
			return (T) this.capabilityItem;
		}
		return null;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		return this.capabilityItem.saveNBT();
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		this.capabilityItem.loadNBT(nbt);
	}
}