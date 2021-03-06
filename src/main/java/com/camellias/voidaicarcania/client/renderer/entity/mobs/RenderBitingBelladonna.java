package com.camellias.voidaicarcania.client.renderer.entity.mobs;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.models.entity.mobs.ModelBitingBelladonna;
import com.camellias.voidaicarcania.common.entities.mobs.EntityBitingBelladonna;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBitingBelladonna extends RenderLiving<EntityBitingBelladonna>
{
	public RenderBitingBelladonna(RenderManager rendermanager)
	{
		super(rendermanager, new ModelBitingBelladonna(), 0.5F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(EntityBitingBelladonna entity)
	{
		return new ResourceLocation(Reference.MODID + ":textures/entity/biting_belladonna.png");
	}
}
