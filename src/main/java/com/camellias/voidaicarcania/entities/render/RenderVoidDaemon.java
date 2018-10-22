package com.camellias.voidaicarcania.entities.render;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.entities.EntityVoidDaemon;
import com.camellias.voidaicarcania.entities.models.ModelVoidDaemon;
import com.camellias.voidaicarcania.entities.render.layers.LayerVoidEyeLights;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderVoidDaemon extends RenderLiving<EntityVoidDaemon>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/void_daemon.png");
	
	public RenderVoidDaemon(RenderManager manager) 
	{
		super(manager, new ModelVoidDaemon(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVoidDaemon entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityVoidDaemon entity, float i, float yaw, float ticks)
	{
		super.applyRotations(entity, i, yaw, ticks);
	}
}