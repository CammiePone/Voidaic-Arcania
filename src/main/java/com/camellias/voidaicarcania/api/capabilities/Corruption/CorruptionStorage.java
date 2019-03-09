package com.camellias.voidaicarcania.api.capabilities.Corruption;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CorruptionStorage implements IStorage<ICorruption> {

	public static final CorruptionStorage storage = new CorruptionStorage();

	@Override
	public NBTBase writeNBT(Capability<ICorruption> capability, ICorruption instance, EnumFacing side) {
		return null;
	}

	@Override
	public void readNBT(Capability<ICorruption> capability, ICorruption instance, EnumFacing side, NBTBase nbt) {

	}

}
