package com.camellias.voidaicarcania.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.camellias.voidaicarcania.api.capabilities.corruption.player.PlayerCorruptionCapability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLivingBase extends Entity
{
	public MixinEntityLivingBase(World worldIn) { super(worldIn); }

	@Inject(method = "getCreatureAttribute", at = @At("HEAD"), cancellable = true)
	public void getCreatureAttribute(CallbackInfoReturnable<EnumCreatureAttribute> info)
	{
		Object obj = this;
		
		if(obj instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) obj;
			
			if(player.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() >= 1200)
			{
				info.setReturnValue(EnumCreatureAttribute.UNDEAD);
			}
		}
	}
}
