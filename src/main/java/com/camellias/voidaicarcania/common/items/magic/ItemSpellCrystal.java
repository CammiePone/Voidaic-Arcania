package com.camellias.voidaicarcania.common.items.magic;

import com.camellias.voidaicarcania.api.spells.SpellType;
import com.camellias.voidaicarcania.common.items.ItemBaseGeneric;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSpellCrystal extends ItemBaseGeneric
{
	public SpellType[] spellType;
	
	public ItemSpellCrystal(String name)
	{
		super(name);
		setMaxStackSize(1);
	}
	
	public void onSpellCast(EntityPlayer player, SpellType... spellTypes)
	{
		for(SpellType spellType : spellTypes)
		{
			
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected)
	{
		super.onUpdate(stack, world, entity, slot, isSelected);
		if(stack.hasTagCompound())
		{
			NBTTagCompound nbt = stack.getTagCompound();
			
			if(!nbt.hasKey("spellType"))
			{
				for(SpellType type : spellType) type.deserializeNBT((NBTTagCompound) nbt.getTag("spellType"));
			}
		}
	}
}
