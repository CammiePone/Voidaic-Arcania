package com.camellias.voidaicarcania.blocks.blockmortalcentrifuge;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.blocks.blockaltar.TileEntityAltar;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiMortalCentrifuge extends GuiContainer
{
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/gui_mortal_furnace.png");
	private final InventoryPlayer player;
	private final TileEntityMortalCentrifuge tileEntity;
	
	public GuiMortalCentrifuge(InventoryPlayer player, TileEntityMortalCentrifuge tileEntity) 
	{
		super(new ContainerMortalCentrifuge(player, tileEntity));
		
		this.player = player;
		this.ySize = 190;
		this.tileEntity = tileEntity;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float ticks)
	{
		this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, ticks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		String tileName = this.tileEntity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2), 8, 8421504);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 8421504);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float ticks, int x, int y)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if(TileEntityMortalCentrifuge.isBurning(tileEntity))
		{
			int k = this.getBurnLeftScaled(15);
			this.drawTexturedModalRect(this.guiLeft + 82, this.guiTop + 35 - k, 176, 45 - k, 10, k + 1); //fuelbar
		}
		
		int l = this.getCookProgressScaled(30);
		this.drawTexturedModalRect(this.guiLeft + 64, this.guiTop + 40, 176, 3, 46, l - 1); //progressbar
	}
	
	private int getBurnLeftScaled(int pixels)
	{
		int i = this.tileEntity.getField(1);
		if(i == 0) i = 200;
		return this.tileEntity.getField(0) * pixels / i;
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.tileEntity.getField(2);
		int j = this.tileEntity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
}
