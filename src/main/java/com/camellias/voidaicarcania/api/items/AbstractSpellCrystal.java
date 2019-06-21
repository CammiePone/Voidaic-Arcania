package com.camellias.voidaicarcania.api.items;

import java.util.List;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.spellcomponents.AbstractSpellComponent;
import com.camellias.voidaicarcania.common.items.ItemBaseGeneric;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class AbstractSpellCrystal extends ItemBaseGeneric
{
	private int potency;
	private double damage;
	private String spellName;
	private AbstractSpellComponent[] spellComponents;
	
	public AbstractSpellCrystal(String name)
	{
		super(name);
		this.setTranslationKey(Reference.MODID + "." + name + "." + getName());
		this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
	{
		String nameSlot = TextFormatting.DARK_PURPLE + I18n.format(Reference.MODID + ".spellNameSlot.name");
		String spellName = TextFormatting.DARK_GRAY + I18n.format(Reference.MODID + "." + getName() + ".name");
		
		String potencySlot = TextFormatting.DARK_PURPLE + I18n.format(Reference.MODID + ".spellPotencySlot.name");
		String potencyAmt = TextFormatting.DARK_GRAY + I18n.format(Reference.MODID + "." + getPotency() + ".name");
		
		String damageSlot = TextFormatting.DARK_PURPLE + I18n.format(Reference.MODID + ".spellDamageSlot.name");
		String damageAmt = TextFormatting.DARK_GRAY + I18n.format(Reference.MODID + "." + getDamage() + ".name");
		
		tooltip.add(nameSlot + " " + spellName);
		tooltip.add(potencySlot + " " + potencyAmt);
		tooltip.add(damageSlot + " " + damageAmt);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected)
	{
		if(!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if(!stack.getTagCompound().hasKey("potency"))
		{
			stack.getTagCompound().setInteger("potency", this.potency);
		}
	}
	
	/**
	 * What happens when the spell is cast (i.e. if the spell is supposed to teleport the player, this is where
	 * you tell the game to teleport the player to the desired location).
	 */
	public void castSpell()
	{
		
	}
	
	/**
	 * Returns the different spell components the player needs to combine to make the spell at the Research Table.
	 * @return
	 */
	public AbstractSpellComponent[] getSpellComponents()
	{
		return this.spellComponents;
	}
	
	/**
	 * Sets the different spell components the player needs to combine to make the spell at the Research Table.
	 * @param spellComponents
	 * @return
	 */
	public AbstractSpellComponent[] setSpellComponents(AbstractSpellComponent... spellComponents)
	{
		this.spellComponents = spellComponents;
		return this.spellComponents;
	}
	
	/**
	 * Returns the potency of the spell.
	 * @return
	 */
	public int getPotency()
	{
		return this.potency;
	}
	
	/**
	 * Sets the potency of the spell. Should almost always be 1 by default.
	 * @param potency
	 * @return
	 */
	public int setPotency(int potency)
	{
		this.potency = potency;
		return this.potency;
	}
	
	/**
	 * Returns the damage the spell is supposed to do.
	 * @return
	 */
	public double getDamage()
	{
		return this.damage;
	}
	
	/**
	 * Sets the base damage, which gets multiplied by the potency and then divided by 2.
	 * @param damage
	 * @return
	 */
	public double setDamage(double damage)
	{
		this.damage = ((damage * getPotency()) / 2);
		return this.damage;
	}
	
	/**
	 * Returns the name of the spell.
	 * @return
	 */
	public String getName()
	{
		return this.spellName;
	}
	
	/**
	 * Sets the name of the spell (keep in mind that you'll need to add a translation in your lang files!).
	 * @param spellName
	 * @return
	 */
	public String setName(String spellName)
	{
		this.spellName = spellName;
		return this.spellName;
	}
}
