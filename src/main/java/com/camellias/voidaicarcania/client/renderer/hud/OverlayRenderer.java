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
		GuiIngame gui = new GuiIngame(mc);
		FontRenderer fontRenderer = gui.getFontRenderer();
		TextureManager textureManager = this.mc.getTextureManager();
		textureManager.bindTexture(TEXTURES);
		
		int x = 0;
		int y = event.getResolution().getScaledHeight() - 47;
		gui.drawTexturedModalRect(x + 5, y - 5, 0, 0, 240, 47);
		if(this.mc.player.isSneaking())
		{
			x = 26;
			y += 5;
			x = fontRenderer.drawString("Chunk VE: ", x, y, 0xffffffff);
			x = fontRenderer.drawString("" + chunkEssence, x, y, 0xffff0000);
			x = fontRenderer.drawString("             Chunk VC: ", x, y, 0xffffffff);
			x = fontRenderer.drawString("" + chunkCorruption, x, y, 0xffff0000);
			y += 20;
			x = 77;
			x = fontRenderer.drawString("Player VC: ", x, y, 0xffffffff);
			x = fontRenderer.drawString("" + (playerCorruption), x, y, 0xffff0000);
		}
	}
}
