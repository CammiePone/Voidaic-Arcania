package com.camellias.voidaicarcania.client.render;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.models.ModelBossBlock;
import com.camellias.voidaicarcania.client.render.layers.LayerVoidEyeLights;
import com.camellias.voidaicarcania.common.entities.EntityVoidEye;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVoidEye extends RenderLiving<EntityVoidEye>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/boss_block.png");
	
	public RenderVoidEye(RenderManager manager) 
	{
		super(manager, new ModelBossBlock(), 0.5F);
		this.addLayer(new LayerVoidEyeLights());
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVoidEye entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityVoidEye entity, float i, float yaw, float ticks)
	{
		super.applyRotations(entity, i, yaw, ticks);
	}
}