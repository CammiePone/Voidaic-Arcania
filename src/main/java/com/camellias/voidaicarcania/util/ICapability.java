package com.camellias.voidaicarcania.util;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public interface ICapability extends INBTSerializable<NBTTagCompound>
{
	ResourceLocation getKey();
	
    ICapabilityProvider getProvider();
    
    void dataChanged(EntityPlayerMP player);
}
