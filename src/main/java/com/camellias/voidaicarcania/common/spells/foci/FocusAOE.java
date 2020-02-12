package com.camellias.voidaicarcania.common.spells.foci;

import com.camellias.voidaicarcania.api.spells.FocusType;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class FocusAOE extends FocusType
{
	public FocusAOE()
	{
		super(true);
	}
	
	@Override
	public void onRightClick(EntityPlayer caster, World world, EnumHand hand, ItemStack stack)
	{
		
	}
}
