package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandler
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		event.player.sendMessage(new TextComponentString("\u00A75\u00A7l[Voidaic Arcania:] \u00A7dThis mod is still in BETA. Gameplay info can currently be found on the VA Wiki:"));
		event.player.sendMessage(ForgeHooks.newChatWithLinks(" https://github.com/CammiePone/Voidaic-Arcania/wiki"));
	}
	
	@SubscribeEvent
	public void onSoundPlayed(PlaySoundAtEntityEvent event)
	{
		World world = Minecraft.getMinecraft().world;
		
		if(SoundReverbHandler.shouldEcho(world))
		{
			event.setVolume(event.getVolume() * 5F);
		}
	}
	
	/*
	 * Credit for everything below goes to Paul Fulham.
	 */
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTextureStitch(final TextureStitchEvent.Pre event)
	{
		final TextureMap map = event.getMap();
		
		map.registerSprite(new ResourceLocation(Reference.MODID, "particles/particle_void_essence"));
		
		if(map == Minecraft.getMinecraft().getTextureMapBlocks())
		{
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_1")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_2")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_3")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_4")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_5")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_6")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_7")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_8")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_9")));
			map.setTextureEntry(new AlphaSprite(new ResourceLocation(Reference.MODID, "items/glyphs/glyph_10")));
		}
	}
	
	static class AlphaSprite extends TextureAtlasSprite
	{
		AlphaSprite(final ResourceLocation name)
		{
			super(name.toString());
		}
		
		@Override
		public void updateAnimation()
		{
			++this.tickCounter;
			
			if(this.tickCounter >= this.animationMetadata.getFrameTimeSingle(this.frameCounter))
			{
				int i = this.animationMetadata.getFrameIndex(this.frameCounter);
				int j = this.animationMetadata.getFrameCount() == 0 ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
				this.frameCounter = (this.frameCounter + 1) % j;
				this.tickCounter = 0;
				int k = this.animationMetadata.getFrameIndex(this.frameCounter);
				
				if(i != k && k >= 0 && k < this.framesTextureData.size())
				{
					TextureUtil.uploadTextureMipmap(this.framesTextureData.get(k), this.width, this.height, this.originX, this.originY, false, false);
				}
			}
			else if(this.animationMetadata.isInterpolate())
			{
				this.updateAnimationInterpolated();
			}
		}
		
		private void updateAnimationInterpolated()
		{
			double d0 = 1.0D - (double)this.tickCounter / (double)this.animationMetadata.getFrameTimeSingle(this.frameCounter);
			int i = this.animationMetadata.getFrameIndex(this.frameCounter);
			int j = this.animationMetadata.getFrameCount() == 0 ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
			int k = this.animationMetadata.getFrameIndex((this.frameCounter + 1) % j);

			if(i != k && k >= 0 && k < this.framesTextureData.size())
			{
				int[][] aint = this.framesTextureData.get(i);
				int[][] aint1 = this.framesTextureData.get(k);

				if(this.interpolatedFrameData == null || this.interpolatedFrameData.length != aint.length)
				{
					this.interpolatedFrameData = new int[aint.length][];
				}

				for(int l = 0; l < aint.length; ++l)
				{
					if(this.interpolatedFrameData[l] == null)
					{
						this.interpolatedFrameData[l] = new int[aint[l].length];
					}

					if(l < aint1.length && aint1[l].length == aint[l].length)
					{
						for(int i1 = 0; i1 < aint[l].length; ++i1)
						{
							int j1 = aint[l][i1];
							int k1 = aint1[l][i1];
							int a = this.interpolateColor(d0, j1 >> 24 & 255, k1 >> 24 & 255);
							int r = this.interpolateColor(d0, j1 >> 16 & 255, k1 >> 16 & 255);
							int g = this.interpolateColor(d0, j1 >> 8 & 255, k1 >> 8 & 255);
							int b = this.interpolateColor(d0, j1 & 255, k1 & 255);
							this.interpolatedFrameData[l][i1] = a << 24 | r << 16 | g << 8 | b;
						}
					}
				}

				TextureUtil.uploadTextureMipmap(this.interpolatedFrameData, this.width, this.height, this.originX, this.originY, false, false);
			}
		}
		
		private int interpolateColor(double d0, int i1, int i2)
		{
			return (int)(d0 * (double)i1 + (1.0D - d0) * (double)i2);
		}
	}
}
