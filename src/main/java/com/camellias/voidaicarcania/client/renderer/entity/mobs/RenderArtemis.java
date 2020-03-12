package com.camellias.voidaicarcania.client.renderer.entity.mobs;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.models.entity.mobs.ModelArtemis;
import com.camellias.voidaicarcania.common.entities.mobs.EntityArtemis;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderArtemis extends RenderLiving<EntityArtemis>
{
	public RenderArtemis(RenderManager rendermanager)
	{
		super(rendermanager, new ModelArtemis(), 0.5F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(EntityArtemis entity)
	{
		return new ResourceLocation(Reference.MODID + ":textures/entity/artemis.png");
	}
}
