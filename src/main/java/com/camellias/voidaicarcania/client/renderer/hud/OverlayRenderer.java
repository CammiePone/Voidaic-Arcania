package com.camellias.voidaicarcania.client.renderer.hud;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OverlayRenderer
{
	public static OverlayRenderer instance = new OverlayRenderer();
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/hud/overlay.png");
	private static Minecraft mc = Minecraft.getMinecraft();
	protected float zLevel;
	private int chunkEssence = 0;
	private int maxChunkEssence = 1600;
	private int chunkCorruption = 0;
	private int maxChunkCorruption = 1000;
	private int playerCorruption = 0;
	private int maxPlayerCorruption = 1000;
	
	public void setEssenceCorruption(int chunkEssence, int chunkCorruption, int playerCorruption)
	{
		this.chunkEssence = chunkEssence;
		this.chunkCorruption = chunkCorruption;
		this.playerCorruption = playerCorruption;
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderGameOverlayEvent(RenderGameOverlayEvent event)
	{
		if(event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE)
		{
			return;
		}
		
		if((this.mc.player.getHeldItem(EnumHand.MAIN_HAND).getItem() != Items.APPLE))
		{
			return;
		}
		
		GlStateManager.disableLighting();
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		GlStateManager.scale(0.75f, 0.75f, 0.75f);
		GuiIngame gui = new GuiIngame(mc);
		FontRenderer fontRenderer = gui.getFontRenderer();
		TextureManager textureManager = this.mc.getTextureManager();
		int x = 0;
		int y = event.getResolution().getScaledHeight() - 47;
		
		textureManager.bindTexture(TEXTURES);
		gui.drawTexturedModalRect(x + 5, y - 5, 0, 0, 240, 47);
		
		int chunkEssenceMeter = chunkEssenceMeter(100);
		gui.drawTexturedModalRect(x + 16, y + 3, 0, 47, chunkEssenceMeter, 12);
		
		int chunkCorruptionMeter = chunkCorruptionMeter(100);
		gui.drawTexturedModalRect(x + 134, y + 3, 140, 47, chunkCorruptionMeter, 12);
		
		int playerCorruptionMeter = playerCorruptionMeter(110);
		gui.drawTexturedModalRect(x + 70, y + 22, 65, 60, playerCorruptionMeter, 12);
		
		if(this.mc.player.isSneaking())
		{
			x = 26;
			y += 5;
			x = fontRenderer.drawString("Chunk VE: ", x, y, 0xffffff);
			x = fontRenderer.drawString("" + chunkEssence, x, y, 0xffffff);
			x = fontRenderer.drawString("             Chunk VC: ", x, y, 0xffffff);
			x = fontRenderer.drawString("" + chunkCorruption, x, y, 0xffffff);
			y += 19;
			x = 77;
			x = fontRenderer.drawString("Player VC: ", x, y, 0xffffff);
			x = fontRenderer.drawString("" + (playerCorruption), x, y, 0xffffff);
		}
	}
	
	private int chunkEssenceMeter(int pixels)
	{
		int i = this.chunkEssence;
		int j = this.maxChunkEssence;
		return i != 0 && j != 0 ? i * pixels / j : 0;
	}
	
	private int chunkCorruptionMeter(int pixels)
	{
		int i = this.chunkCorruption;
		int j = this.maxChunkCorruption;
		return i != 0 && j != 0 ? i * pixels / j : 0;
	}
	
	private int playerCorruptionMeter(int pixels)
	{
		int i = this.playerCorruption;
		int j = this.maxPlayerCorruption;
		return i != 0 && j != 0 ? i * pixels / j : 0;
	}
}
