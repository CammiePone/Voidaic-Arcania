package com.camellias.voidaicarcania.client.renderer.entity.layers;

import com.camellias.voidaicarcania.client.models.entity.mobs.ModelKharonite;

import net.minecraft.client.renderer.entity.RenderLivingBase;

public class LayerKharonite extends LayerKharoniteBase<ModelKharonite>
{
	public LayerKharonite(RenderLivingBase renderer, boolean isAlex)
	{
		super(renderer);
		this.modelKharonite = new ModelKharonite(isAlex);
	}
}
