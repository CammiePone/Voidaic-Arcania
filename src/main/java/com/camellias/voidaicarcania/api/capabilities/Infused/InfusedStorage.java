package com.camellias.voidaicarcania.api.capabilities.Infused;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class InfusedStorage implements IStorage<IInfused> {

	public static final InfusedStorage storage = new InfusedStorage();

	@Override
	public NBTBase writeNBT(Capability<IInfused> capability, IInfused instance, EnumFacing side) {
		final NBTTagCompound tag = new NBTTagCompound();
		tag.setBoolean("infused", instance.infused());
		return tag;
	}

	@Override
	public void readNBT(Capability<IInfused> capability, IInfused instance, EnumFacing side, NBTBase nbt) {
		if (nbt instanceof NBTTagCompound) {
			final NBTTagCompound tag = (NBTTagCompound) nbt;
			if (tag.hasKey("infused")) {
				instance.setInfused(tag.getBoolean("infused"));
			}
		}
	}

}
