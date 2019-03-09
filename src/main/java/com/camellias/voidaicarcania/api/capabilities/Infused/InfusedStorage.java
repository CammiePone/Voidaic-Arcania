package com.camellias.voidaicarcania.api.capabilities.Infused;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class InfusedStorage implements IStorage<IInfused> {

	public static final InfusedStorage storage = new InfusedStorage();

	@Override
	public NBTBase writeNBT(Capability<IInfused> capability, IInfused instance, EnumFacing side) {
		return null;
	}

	@Override
	public void readNBT(Capability<IInfused> capability, IInfused instance, EnumFacing side, NBTBase nbt) {

	}

}
