package com.camellias.voidaicarcania.core.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mixin(value = ModelPlayer.class, priority = 1000)
public abstract class ModelPlayerMixin
{
	@Shadow
	public ModelRenderer bipedLeftArm;
	
	@Shadow
	public ModelRenderer bipedRightArm;
	
	@Shadow
	public ModelRenderer bipedBody;
	
	@Inject(method = "setRotationAngles", at = @At("HEAD"))
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn, CallbackInfo info)
	{
		System.out.println("Beep boop");
		this.bipedBody.rotateAngleX = 0.175F;
	}
}
