package com.camellias.voidaicarcania.client.particles;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VoidEssenceParticle extends Particle
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "particles/particle_void_essence");
	private double realY = posY;
	
	public VoidEssenceParticle(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ)
	{
		super(world, x, y, z, velocityX, velocityY, velocityZ);
		
		particleMaxAge = 20;
		
		particleAlpha = 0.75F;
		
		motionX = velocityX;
		motionY = velocityY;
		motionZ = velocityZ;
		
		TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(TEXTURE.toString());
		setParticleTexture(sprite);
	}
	
	@Override
	public int getFXLayer()
	{
		return 1;
	}
	
	@Override
	public int getBrightnessForRender(float partialTicks)
	{
		return 255;
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if(motionY <= 0D) posY = realY + 1D * Math.sin(particleAge * (0.15D));
	}
	
	@Override
	public boolean shouldDisableDepth()
	{
		return true;
	}
	
	@Override
	public boolean isAlive()
	{
		return this.particleAge < this.particleMaxAge;
	}
	
	@Override
	public void renderParticle(BufferBuilder bufferBuilder, Entity entity, float partialTick,
			float edgeLRdirectionX, float edgeUDdirectionY, float edgeLRdirectionZ,
			float edgeUDdirectionX, float edgeUDdirectionZ)
	{
		double minU = this.particleTexture.getMinU();
		double maxU = this.particleTexture.getMaxU();
		double minV = this.particleTexture.getMinV();
		double maxV = this.particleTexture.getMaxV();
		
		double scale = 0.1F * this.particleScale;
		final double scaleLR = scale;
		final double scaleUD = scale;
		double x = this.prevPosX + (this.posX - this.prevPosX) * partialTick - interpPosX;
		double y = this.prevPosY + (this.posY - this.prevPosY) * partialTick - interpPosY;
		double z = this.prevPosZ + (this.posZ - this.prevPosZ) * partialTick - interpPosZ;
		
		int combinedBrightness = this.getBrightnessForRender(partialTick);
		int skyLightTimes16 = combinedBrightness >> 16 & 65535;
		int blockLightTimes16 = combinedBrightness & 65535;
		
		bufferBuilder.pos(x - edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,
				y - edgeUDdirectionY * scaleUD,
				z - edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)
				.tex(maxU, maxV)
				.color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
				.lightmap(skyLightTimes16, blockLightTimes16)
				.endVertex();
		
		bufferBuilder.pos(x - edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,
				y + edgeUDdirectionY * scaleUD,
				z - edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)
				.tex(maxU, minV)
				.color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
				.lightmap(skyLightTimes16, blockLightTimes16)
				.endVertex();
		
		bufferBuilder.pos(x + edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,
				y + edgeUDdirectionY * scaleUD,
				z + edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)
				.tex(minU, minV)
				.color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
				.lightmap(skyLightTimes16, blockLightTimes16)
				.endVertex();
		
		bufferBuilder.pos(x + edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,
				y - edgeUDdirectionY * scaleUD,
				z + edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)
				.tex(minU, maxV)
				.color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
				.lightmap(skyLightTimes16, blockLightTimes16)
				.endVertex();
	}
}
