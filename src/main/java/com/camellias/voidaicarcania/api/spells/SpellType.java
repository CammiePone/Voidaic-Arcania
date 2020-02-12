package com.camellias.voidaicarcania.api.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class SpellType implements SpellComponent
{
	public double costMultiplier;
	
	public abstract void onCast(EntityPlayer caster, World world, EnumHand hand, ItemStack stack);
	
	public void setCostMultiplier(double multiplier)
	{
		this.costMultiplier = multiplier;
	}
	
	public double getCostMultiplier()
	{
		return this.costMultiplier;
	}
}
