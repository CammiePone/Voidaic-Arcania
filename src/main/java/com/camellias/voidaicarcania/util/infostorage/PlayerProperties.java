package com.camellias.voidaicarcania.util.infostorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class PlayerProperties
{
	@CapabilityInject(VoidCorruptionCapability.class)
	public static Capability<VoidCorruptionCapability> VOID_CORRUPTION;
	
	public static VoidCorruptionCapability getPlayerCorruption(EntityPlayer player)
	{
		return player.getCapability(VOID_CORRUPTION, null);
	}
}
