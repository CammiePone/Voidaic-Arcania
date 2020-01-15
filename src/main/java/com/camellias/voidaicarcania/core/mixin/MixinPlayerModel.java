package com.camellias.voidaicarcania.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;

@Mixin(ModelPlayer.class)
public class MixinPlayerModel
{
	@Inject(method = "setRotationAngles", at = @At("RETURN"))
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn, CallbackInfo info)
	{
		Object obj = this;
		
		if(obj instanceof ModelPlayer)
		{
			ModelPlayer model = (ModelPlayer) obj;
			
			model.bipedHead.setRotationPoint(0.0F, 0.5F, -2.0F);
			model.bipedBody.setRotationPoint(0.0F, 0.3F, -2.0F);
			model.bipedRightArm.setRotationPoint(-5.0F, 2.3F, -2.0F);
			model.bipedLeftArm.setRotationPoint(5.0F, 2.3F, -2.0F);
			model.bipedBody.rotateAngleX = 0.175F;
		}
	}
}
