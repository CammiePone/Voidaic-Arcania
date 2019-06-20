package com.camellias.voidaicarcania.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import com.camellias.voidaicarcania.client.renderer.hud.OverlayRenderer;
import com.camellias.voidaicarcania.common.tileentities.altar.TileWhitewoodPedestal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TileWhitewoodPedestalRenderer extends TileEntitySpecialRenderer<TileWhitewoodPedestal>
{
	public static TileWhitewoodPedestalRenderer render = new TileWhitewoodPedestalRenderer();
	private ItemStack stack;
	
	public void setSyncedItemStack(ItemStack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public void render(TileWhitewoodPedestal pedestal, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		super.render(pedestal, x, y, z, partialTicks, destroyStage, alpha);
		
		if(this.stack != null)
		{
			if((pedestal != null) && (!this.stack.isEmpty()))
			{
				EntityItem entityitem = null;
				float ticks = Minecraft.getMinecraft().getRenderViewEntity().ticksExisted + partialTicks;
				
				GL11.glPushMatrix();
				GL11.glTranslated(x + 0.5D, y + 0.75D, z + 0.5D);
				GL11.glScaled(1.0D, 1.0D, 1.0D);
				GL11.glRotated(ticks % 360.0D, 0.0D, 1.0D, 0.0D);
				
				ItemStack stack = this.stack.copy();
				RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
				
				stack.setCount(1);
				entityitem = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D, stack);
				entityitem.hoverStart = 0.0F;
				rendermanager.renderEntity(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
				GL11.glPopMatrix();
			}
		}
	}
}
