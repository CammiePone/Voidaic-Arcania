package com.camellias.voidaicarcania.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.camellias.voidaicarcania.api.capabilities.corruption.player.PlayerCorruptionCapability;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

@Mixin(ModelPlayer.class)
public abstract class MixinPlayerModel
{
	private int maxPlayerCorruption = 1200;
	
	@Inject(method = "setRotationAngles", at = @At("RETURN"))
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn, CallbackInfo info)
	{
		if(entityIn instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entityIn;
			
			if(entityIn.getCapability(PlayerCorruptionCapability.CAPABILITY, null).getCorruption() >= maxPlayerCorruption)
			{
				Object obj = this;
				
				if(obj instanceof ModelPlayer)
				{
					ModelPlayer model = (ModelPlayer) obj;
					
					model.bipedHead.setRotationPoint(0.0F, 0.5F, -2.0F);
					model.bipedHeadwear.setRotationPoint(0.0F, 0.5F, -2.0F);
					model.bipedBody.setRotationPoint(0.0F, 0.3F, -2.0F);
					model.bipedBodyWear.setRotationPoint(0.0F, 0.3F, -2.0F);
					model.bipedRightArm.setRotationPoint(-5.0F, 2.3F, -2.0F);
					model.bipedRightArmwear.setRotationPoint(-5.0F, 2.3F, -2.0F);
					model.bipedLeftArm.setRotationPoint(5.0F, 2.3F, -2.0F);
					model.bipedLeftArmwear.setRotationPoint(5.0F, 2.3F, -2.0F);
					model.bipedBody.rotateAngleX = 0.175F;
					model.bipedBodyWear.rotateAngleX = 0.175F;
					
					if(model.isSneak)
					{
						model.bipedBody.rotateAngleX = 0.5F;
						model.bipedBodyWear.rotateAngleX = 0.5F;
						model.bipedRightArm.rotateAngleX += 0.4F;
						model.bipedRightArmwear.rotateAngleX += 0.4F;
						model.bipedLeftArm.rotateAngleX += 0.4F;
						model.bipedLeftArmwear.rotateAngleX += 0.4F;
						model.bipedRightLeg.rotationPointZ = 4.0F;
						model.bipedRightLegwear.rotationPointZ = 4.0F;
						model.bipedLeftLeg.rotationPointZ = 4.0F;
						model.bipedLeftLegwear.rotationPointZ = 4.0F;
						model.bipedRightLeg.rotationPointY = 9.0F;
						model.bipedRightLegwear.rotationPointY = 9.0F;
						model.bipedLeftLeg.rotationPointY = 9.0F;
						model.bipedLeftLegwear.rotationPointY = 9.0F;
						model.bipedHead.rotationPointY = 1.0F;
						model.bipedHeadwear.rotationPointY = 1.0F;
					}
				}
			}
		}
	}
}
