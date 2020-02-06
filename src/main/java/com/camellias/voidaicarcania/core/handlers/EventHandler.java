package com.camellias.voidaicarcania.core.handlers;

import java.util.LinkedList;
import java.util.Queue;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.core.mixin.IAccessorAnimationMetadata;
import com.camellias.voidaicarcania.core.util.Edit;
import com.camellias.voidaicarcania.core.util.ScanCallBack;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandler
{
	private boolean shouldRaiseWorld = false;
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		event.player.sendMessage(new TextComponentString("\u00A75\u00A7l[Voidaic Arcania:] \u00A7dThis mod is still in BETA. Gameplay info can currently be found on the VA Wiki:"));
		event.player.sendMessage(ForgeHooks.newChatWithLinks(" https://github.com/CammiePone/Voidaic-Arcania/wiki"));
	}
	
	@SubscribeEvent
	public void onWorldGen(PopulateChunkEvent.Post event)
	{
		if(shouldRaiseWorld)
		{
			Chunk chunk = event.getWorld().getChunk(event.getChunkX(), event.getChunkZ());
			
			final Queue<Edit> editQueue = new LinkedList();

			scanChunk(chunk, 140, (c, i, j, k) ->
			{
				BlockPos pos = new BlockPos(i, j, k);
				IBlockState state = chunk.getBlockState(pos);
				editQueue.offer(get(pos, state));
			});
			
			while(editQueue.peek() != null)
			{
				final Edit edit = editQueue.poll();
				BlockPos pos = edit.pos;

				chunk.setBlockState(pos.up(16), edit.state);
				
				if(pos.getY() < 16)
				{
					chunk.setBlockState(pos, AIR);
				}
				
				recycleBin.offer(edit);
			}
		}
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
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public static final IBlockState AIR = Blocks.AIR.getDefaultState();

	public void scanChunk(Chunk chunk, int yMax, ScanCallBack function)
	{
		loopChunk(chunk, 0, 0, 0, 16, yMax, 16, function);
	}

	public void loopChunk(Chunk chunk, int x, int y, int z, int w, int h, int d, ScanCallBack function)
	{
		for(int i = x; i < w; i++)
		{
			for(int j = y; j < h; j++)
			{
				for(int k = z; k < d; k++)
				{
					function.onScan(chunk, i, j, k);
				}
			}
		}
	}
	
	Queue<Edit> recycleBin = new LinkedList();
	
	public Edit get(BlockPos pos, IBlockState state)
	{
		if(recycleBin.peek() != null)
		{
			Edit edit = recycleBin.poll();
			edit.pos = pos;
			edit.state = state;
			return edit;
		}
		
		return new Edit(pos, state);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
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
			
			if(this.tickCounter >= ((IAccessorAnimationMetadata) this).getMetadata().getFrameTimeSingle(this.frameCounter))
			{
				int i = ((IAccessorAnimationMetadata) this).getMetadata().getFrameIndex(this.frameCounter);
				int j = ((IAccessorAnimationMetadata) this).getMetadata().getFrameCount() == 0 ? this.framesTextureData.size() : ((IAccessorAnimationMetadata) this).getMetadata().getFrameCount();
				this.frameCounter = (this.frameCounter + 1) % j;
				this.tickCounter = 0;
				int k = ((IAccessorAnimationMetadata) this).getMetadata().getFrameIndex(this.frameCounter);
				
				if(i != k && k >= 0 && k < this.framesTextureData.size())
				{
					TextureUtil.uploadTextureMipmap(this.framesTextureData.get(k), this.width, this.height, this.originX, this.originY, false, false);
				}
			}
			else if(((IAccessorAnimationMetadata) this).getMetadata().isInterpolate())
			{
				this.updateAnimationInterpolated();
			}
		}
		
		private void updateAnimationInterpolated()
		{
			double d0 = 1.0D - (double)this.tickCounter / (double)((IAccessorAnimationMetadata) this).getMetadata().getFrameTimeSingle(this.frameCounter);
			int i = ((IAccessorAnimationMetadata) this).getMetadata().getFrameIndex(this.frameCounter);
			int j = ((IAccessorAnimationMetadata) this).getMetadata().getFrameCount() == 0 ? this.framesTextureData.size() : ((IAccessorAnimationMetadata) this).getMetadata().getFrameCount();
			int k = ((IAccessorAnimationMetadata) this).getMetadata().getFrameIndex((this.frameCounter + 1) % j);

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
