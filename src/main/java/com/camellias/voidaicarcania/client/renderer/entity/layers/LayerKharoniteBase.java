package com.camellias.voidaicarcania.client.renderer.entity.layers;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.capabilities.Corruption.CorruptionProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public abstract class LayerKharoniteBase<T extends ModelBiped> implements LayerRenderer<EntityLivingBase>
{
	private static final ResourceLocation KHARONITE_SKIN = new ResourceLocation(Reference.MODID, "textures/entity/layers/kharonite.png");
	protected T modelKharonite;
	private final RenderLivingBase<?> renderer;
	private int maxPlayerCorruption = 1200;
	
	public LayerKharoniteBase(RenderLivingBase<?> renderer)
	{
		this.renderer = renderer;
	}
	
	@Override
	public void doRenderLayer(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch, float scale)
	{
		if(entity.getCapability(CorruptionProvider.corruptionCapability, null).getCorruption() >= maxPlayerCorruption)
		{
			this.modelKharonite.setModelAttributes(this.renderer.getMainModel());
			this.modelKharonite.setLivingAnimations(entity, limbSwing, limbSwingAmount, partialTicks);
			this.renderer.bindTexture(KHARONITE_SKIN);
			this.modelKharonite.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}
	
	@Override
	public boolean shouldCombineTextures()
	{
		return true;
	}
}
