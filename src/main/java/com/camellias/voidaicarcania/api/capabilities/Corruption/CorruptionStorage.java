package com.camellias.voidaicarcania.api.capabilities.Corruption;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CorruptionStorage implements IStorage<ICorruption> {

	public static final CorruptionStorage storage = new CorruptionStorage();

	@Override
	public NBTBase writeNBT(Capability<ICorruption> capability, ICorruption instance, EnumFacing side) {
		final NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("corruption", instance.getCorruption());
		tag.setBoolean("corrupted", instance.isCorrupted());
		return tag;
	}

	@Override
	public void readNBT(Capability<ICorruption> capability, ICorruption instance, EnumFacing side, NBTBase nbt) {
		if (nbt instanceof NBTTagCompound) {
			final NBTTagCompound tag = (NBTTagCompound) nbt;
			if (tag.hasKey("corruption")) {
				instance.setCorruption(tag.getInteger("corruption"));
			}
			if (tag.hasKey("corrupted")) {
				instance.setCorrupted(tag.getBoolean("corrupted"));
			}
		}
	}

}
