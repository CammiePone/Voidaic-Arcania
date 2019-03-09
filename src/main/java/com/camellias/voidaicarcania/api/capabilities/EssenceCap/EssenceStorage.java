package com.camellias.voidaicarcania.api.capabilities.EssenceCap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class EssenceStorage implements IStorage<IEssence> {

	public static final EssenceStorage storage = new EssenceStorage();

	@Override
	public NBTBase writeNBT(Capability<IEssence> capability, IEssence instance, EnumFacing side) {
		return null;
	}

	@Override
	public void readNBT(Capability<IEssence> capability, IEssence instance, EnumFacing side, NBTBase nbt) {

	}

}
