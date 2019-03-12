package com.camellias.voidaicarcania.client.renderer.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OverlayRenderer
{
	public static OverlayRenderer instance = new OverlayRenderer();
	private int chunkEssence = 0;
	private int chunkCorruption = 0;
	private int playerCorruption = 0;
	
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
		
		if((Minecraft.getMinecraft().player.getHeldItem(EnumHand.MAIN_HAND).getItem() != Items.APPLE))
		{
			return;
		}
		
		GlStateManager.disableLighting();
		
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		
		int x = 200;
		int y = 10;
		x = fontRenderer.drawString("Void Essence: ", x, y, 0xffffffff);
		x = fontRenderer.drawString("" + chunkEssence, x, y, 0xffff0000);
		x = fontRenderer.drawString("  Void Corruption: ", x, y, 0xffffffff);
		x = fontRenderer.drawString("" + chunkCorruption, x, y, 0xffff0000);
		y += 10;
		x = 200;
		x = fontRenderer.drawString("Player Corruption ", x, y, 0xffffffff);
		x = fontRenderer.drawString("" + (playerCorruption), x, y, 0xffff0000);
	}
}
