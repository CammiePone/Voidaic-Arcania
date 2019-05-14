package com.camellias.voidaicarcania.client.renderer.entity.mobs;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.models.entity.mobs.ModelVoidWraith;
import com.camellias.voidaicarcania.common.entities.mobs.EntityVoidWraith;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVoidWraith extends RenderLiving<EntityVoidWraith>
{
	public RenderVoidWraith(RenderManager rendermanager)
	{
		super(rendermanager, new ModelVoidWraith(), 0.5F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(EntityVoidWraith entity)
	{
		return new ResourceLocation(Reference.MODID + ":textures/entity/void_wraith.png");
	}
}
