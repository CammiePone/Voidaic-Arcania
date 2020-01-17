package com.camellias.voidaicarcania.api.capabilities.corruption.player;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zabi.minecraft.minerva.common.capability.SimpleCapability;

public class PlayerCorruptionCapability extends SimpleCapability
{
	@CapabilityInject(PlayerCorruptionCapability.class)
	public static final Capability<PlayerCorruptionCapability> CAPABILITY = null;
	public static final PlayerCorruptionCapability DEFAULT_INSTANCE = new PlayerCorruptionCapability(0, false);
	
	public int corruption = 0;
	public boolean corrupted = false;
	
	public PlayerCorruptionCapability(int amount, boolean corrupted)
	{
		this.corruption = amount;
		this.corrupted = corrupted;
	}
	
	public boolean isCorrupted() {
		return this.corrupted;
	}
	
	public void setCorrupted(boolean value)
	{
		if(this.corrupted != value)
		{
			this.corrupted = value;
			this.markDirty((byte) 1);
		}
	}
	
	public int getCorruption()
	{
		return this.corruption;
	}
	
	public void setCorruption(int amount)
	{
		if(this.corruption != amount)
		{
			this.corruption = amount;
			this.markDirty((byte) 1);
		}
	}
	
	@Override
	public boolean isRelevantFor(Entity object)
	{
		return object instanceof EntityPlayer;
	}
	
	@Override
	public SimpleCapability getNewInstance()
	{
		return new PlayerCorruptionCapability(0, false);
	}
	
	@Override
	public boolean shouldSyncToOwnerPlayer()
	{
		return true;
	}
	
	@Override
	public boolean shouldSyncToPlayersAround()
	{
		return true;
	}
}
