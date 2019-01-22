package com.camellias.voidaicarcania.client.render.overlay;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CorruptionOverlay
{
	public static final CorruptionOverlay INSTANCE = new CorruptionOverlay();
	
	private float playerCorruption = 0;
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/microfission_reactor.png");
	
	public void setEssence(float playerCorruption)
	{
		this.playerCorruption = playerCorruption;
	}
	
	@SubscribeEvent
    public void renderGameOverlayEvent(RenderGameOverlayEvent event)
	{
        if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE)
        {
            return;
        }
        
        if (Minecraft.getMinecraft().player.getHeldItem(EnumHand.MAIN_HAND).getItem() != ModItems.CRYSTAL)
        {
            return;
        }
        
        GlStateManager.disableLighting();
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        TextureManager manager = Minecraft.getMinecraft().getTextureManager();
        manager.bindTexture(TEXTURES);
        
        int x = 160;
        int y = 335;
        x = fontRenderer.drawString("Corruption - " , x, y, 7536798);
        x = fontRenderer.drawString(String.format("%.0f", playerCorruption * 100), x, y, 5308538);
	}
}
