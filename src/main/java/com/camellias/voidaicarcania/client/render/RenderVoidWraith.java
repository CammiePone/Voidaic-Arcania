package com.camellias.voidaicarcania.client.render;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.models.ModelVoidWraith;
import com.camellias.voidaicarcania.common.entities.EntityVoidWraith;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;

public class RenderVoidWraith extends RenderLiving<EntityVoidWraith>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/void_wraith.png");
	
	public RenderVoidWraith(RenderManager manager) 
	{
		super(manager, new ModelVoidWraith(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVoidWraith entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityVoidWraith entity, float i, float yaw, float ticks)
	{
		super.applyRotations(entity, i, yaw, ticks);
	}
}
