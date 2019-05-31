package com.camellias.voidaicarcania.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import com.camellias.voidaicarcania.common.tileentities.altar.TEPedestal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class TEPedestalRenderer extends TileEntitySpecialRenderer<TEPedestal>
{
	@Override
	public void render(TEPedestal pedestal, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		super.render(pedestal, x, y, z, partialTicks, destroyStage, alpha);
		
		if((pedestal != null) && (!pedestal.getSyncedStackInSlot(0).isEmpty()))
		{
			EntityItem entityitem = null;
			float ticks = Minecraft.getMinecraft().getRenderViewEntity().ticksExisted + partialTicks;
			
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
			GL11.glScaled(1.25D, 1.25D, 1.25D);
			GL11.glRotatef(ticks % 360.0F, 0.0F, 1.0F, 0.0F);
			
			ItemStack stack = pedestal.getSyncedStackInSlot(0).copy();
			stack.setCount(1);
			entityitem = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D, stack);
			entityitem.hoverStart = 0.0F;
			RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
			rendermanager.renderEntity(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, false);
			GL11.glPopMatrix();
		}
	}
}
