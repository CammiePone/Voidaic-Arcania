package com.camellias.voidaicarcania.api.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public abstract class SpellType implements SpellComponent, ICapabilitySerializable<NBTTagCompound>
{
	public double costMultiplier;
	
	public abstract void onCast(EntityPlayer caster, World world, EnumHand hand, ItemStack stack);
	
	@Override
	public abstract NBTTagCompound serializeNBT();
	
	@Override
	public abstract void deserializeNBT(NBTTagCompound nbt);
	
	public void setCostMultiplier(double multiplier)
	{
		this.costMultiplier = multiplier;
	}
	
	public double getCostMultiplier()
	{
		return this.costMultiplier;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return false;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return null;
	}
}
