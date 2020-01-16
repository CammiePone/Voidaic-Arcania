package com.camellias.voidaicarcania.client.renderer.entity.layers;

import com.camellias.voidaicarcania.client.models.entity.mobs.ModelKharonite;

import net.minecraft.client.renderer.entity.RenderLivingBase;

public class LayerKharonite extends LayerKharoniteBase<ModelKharonite>
{
	public LayerKharonite(RenderLivingBase renderer)
	{
		super(renderer);
	}
	
	@Override
	public void init()
	{
		this.modelKharonite = new ModelKharonite();
	}
}
