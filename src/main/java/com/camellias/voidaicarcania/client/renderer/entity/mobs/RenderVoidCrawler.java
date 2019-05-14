package com.camellias.voidaicarcania.client.renderer.entity.mobs;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.models.entity.mobs.ModelVoidCrawler;
import com.camellias.voidaicarcania.common.entities.mobs.EntityVoidCrawler;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVoidCrawler extends RenderLiving<EntityVoidCrawler>
{
	public RenderVoidCrawler(RenderManager rendermanager)
	{
		super(rendermanager, new ModelVoidCrawler(), 0.5F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(EntityVoidCrawler entity)
	{
		return new ResourceLocation(Reference.MODID + ":textures/entity/void_crawler.png");
	}
}
