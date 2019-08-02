package com.camellias.voidaicarcania.api.capabilities.Essence;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class EssenceStorage implements IStorage<IEssence> {

	public static final EssenceStorage storage = new EssenceStorage();

	@Override
	public NBTBase writeNBT(Capability<IEssence> capability, IEssence instance, EnumFacing side) {
		final NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("essence", instance.getEssence());
		tag.setBoolean("effect", instance.effect());
		return tag;
	}

	@Override
	public void readNBT(Capability<IEssence> capability, IEssence instance, EnumFacing side, NBTBase nbt) {
		if (nbt instanceof NBTTagCompound) {
			final NBTTagCompound tag = (NBTTagCompound) nbt;
			if (tag.hasKey("essence")) {
				instance.setEssence(tag.getInteger("essence"));
			}
			if (tag.hasKey("effect")) {
				instance.setEffect(tag.getBoolean("effect"));
			}
		}
	}

}
