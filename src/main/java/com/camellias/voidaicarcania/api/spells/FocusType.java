package com.camellias.voidaicarcania.api.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class FocusType implements SpellComponent
{
	private double costMultiplier;
	private boolean isInstant;
	
	public FocusType(boolean isInstant)
	{
		this.isInstant = isInstant;
	}
	
	public abstract void onRightClick(EntityPlayer caster, World world, EnumHand hand, ItemStack stack);
	
	public void setCostMultiplier(double multiplier)
	{
		this.costMultiplier = multiplier;
	}
	
	public double getCostMultiplier()
	{
		return this.costMultiplier;
	}
	
	public boolean isInstant()
	{
		return this.isInstant;
	}
}
