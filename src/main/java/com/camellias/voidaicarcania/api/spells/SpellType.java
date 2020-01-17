package com.camellias.voidaicarcania.api.spells;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.capabilities.essence.EssenceProvider;
import com.camellias.voidaicarcania.api.capabilities.essence.IEssence;
import com.camellias.voidaicarcania.api.capabilities.infused.InfusedProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityDispatcher;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class SpellType extends IForgeRegistryEntry.Impl<SpellType> implements ICapabilitySerializable<NBTTagCompound>
{
	protected int potency;
	protected int essenceCost;
	protected boolean canCast = false;
	private CapabilityDispatcher capabilities;
	
	public SpellType(String name, int potency, int essenceCost)
	{
		this.setRegistryName(Reference.MODID, name);
		this.potency = potency;
		this.essenceCost = essenceCost;
	}
	
	public void drainEssence(EntityPlayer player)
	{
		if(player.hasCapability(InfusedProvider.infusedCapability, null))
		{
			if(player.hasCapability(EssenceProvider.essenceCapability, null))
			{
				IEssence cap = player.getCapability(EssenceProvider.essenceCapability, null);
				
				if(cap.getEssence() >= getEssenceCost())
				{
					canCast = true;
					cap.setEssence(cap.getEssence() - getEssenceCost());
				}
				else canCast = false;
			}
		}
	}
	
	public int getPotency()
	{
		return potency;
	}
	
	public int getEssenceCost()
	{
		return essenceCost;
	}
	
	public boolean canCast()
	{
		return canCast;
	}
	
	public void readFromNBT(NBTTagCompound nbt)
	{
		if(nbt.hasKey("potency"))
		{
			potency = nbt.getInteger("potency");
		}
		
		if(nbt.hasKey("essenceCost"))
		{
			essenceCost = nbt.getInteger("essenceCost");
		}
		
		if(nbt.hasKey("canCast"))
		{
			canCast = nbt.getBoolean("canCast");
		}
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("potency", potency);
		nbt.setInteger("essenceCost", essenceCost);
		nbt.setBoolean("canCast", canCast);
		return nbt;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
	{
		return capabilities == null ? false : capabilities.hasCapability(capability, facing);
	}
	
	@Override
	@Nullable
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
	{
		return capabilities == null ? null : capabilities.getCapability(capability, facing);
	}
	
	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		readFromNBT(nbt);
	}
	
	@Override
	public NBTTagCompound serializeNBT()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return nbt;
	}
}
