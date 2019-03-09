package com.camellias.voidaicarcania.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemStackWrapper
{
	private static Item item;
	private static Integer meta;
	
	public ItemStackWrapper(Item item, Integer meta)
	{
		this.item = item;
		this.meta = meta;
	}
	
	public Item getItem()
	{
		return this.item;
	}
	
	public int getMetadata()
	{
		return this.meta;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof ItemStackWrapper)
		{
			ItemStackWrapper other = (ItemStackWrapper) obj;
			if(other.getMetadata() == meta && other.getItem().equals(item))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return this.item.hashCode() + this.meta.hashCode();
	};
}
