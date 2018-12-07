package com.camellias.voidaicarcania.client.render;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.models.ModelVoidHeart;
import com.camellias.voidaicarcania.common.entities.EntityVoidHeartBoss;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVoidHeartBoss extends RenderLiving<EntityVoidHeartBoss>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/voidic_construct.png");
	
	public RenderVoidHeartBoss(RenderManager manager) 
	{
		super(manager, new ModelVoidHeart(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVoidHeartBoss entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityVoidHeartBoss entity, float i, float yaw, float ticks)
	{
		super.applyRotations(entity, i, yaw, ticks);
	}
}
