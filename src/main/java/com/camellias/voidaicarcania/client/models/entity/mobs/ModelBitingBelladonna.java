package com.camellias.voidaicarcania.client.models.entity.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Biting Belladonna - HadeZ
 * Created using Tabula 7.1.0
 */
public class ModelBitingBelladonna extends ModelBase
{
	public ModelRenderer base;
	public ModelRenderer baseDetail1;
	public ModelRenderer baseDetail2;
	public ModelRenderer baseDetail3;
	public ModelRenderer baseDetail4;
	public ModelRenderer stem1;
	public ModelRenderer stem2;
	public ModelRenderer stem3;
	public ModelRenderer flowerBase;
	public ModelRenderer pedal1Joint;
	public ModelRenderer pedal2Joint;
	public ModelRenderer pedal3Joint;
	public ModelRenderer pedal4Joint;
	public ModelRenderer tongue1;
	public ModelRenderer teeth;
	public ModelRenderer pedal1;
	public ModelRenderer pedal1A;
	public ModelRenderer pedal1B;
	public ModelRenderer pedal2;
	public ModelRenderer pedal2A;
	public ModelRenderer pedal2B;
	public ModelRenderer pedal3;
	public ModelRenderer pedal3A;
	public ModelRenderer pedal3B;
	public ModelRenderer pedal4;
	public ModelRenderer pedal4A;
	public ModelRenderer pedal4B;
	public ModelRenderer tongue2;
	public ModelRenderer tongue3;
	public ModelRenderer tongue4;
	public ModelRenderer tongeMouth;
	public ModelRenderer tongeMouth2;
	
	public ModelBitingBelladonna()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		
		this.pedal4 = new ModelRenderer(this, 80, 115);
		this.pedal4.setRotationPoint(-5.5F, 1.0F, 0.0F);
		this.pedal4.addBox(-6.0F, -0.5F, -4.0F, 7, 0, 8, 0.0F);
		this.setRotateAngle(pedal4, 0.0F, 0.0F, 0.5235987755982988F);
		this.baseDetail2 = new ModelRenderer(this, 80, 15);
		this.baseDetail2.setRotationPoint(3.5F, -1.0F, 0.0F);
		this.baseDetail2.addBox(-4.5F, -0.5F, 0.0F, 9, 1, 3, 0.0F);
		this.setRotateAngle(baseDetail2, 0.7853981633974483F, 1.5707963267948966F, 0.0F);
		this.tongue2 = new ModelRenderer(this, 50, 20);
		this.tongue2.setRotationPoint(0.0F, -10.0F, 0.0F);
		this.tongue2.addBox(-1.5F, -7.0F, -1.5F, 3, 11, 3, 0.0F);
		this.teeth = new ModelRenderer(this, 4, 18);
		this.teeth.setRotationPoint(0.0F, -1.5F, 0.0F);
		this.teeth.addBox(-4.5F, 0.0F, -4.5F, 9, 2, 9, 0.0F);
		this.tongue4 = new ModelRenderer(this, 50, 60);
		this.tongue4.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.tongue4.addBox(-0.5F, -10.1F, -0.5F, 1, 11, 1, 0.0F);
		this.pedal3 = new ModelRenderer(this, 80, 115);
		this.pedal3.setRotationPoint(-5.5F, 1.0F, 0.0F);
		this.pedal3.addBox(-6.0F, -0.5F, -4.0F, 7, 0, 8, 0.0F);
		this.setRotateAngle(pedal3, 0.0F, 0.0F, 0.5235987755982988F);
		this.pedal4A = new ModelRenderer(this, 80, 105);
		this.pedal4A.setRotationPoint(-6.2F, -0.1F, 0.0F);
		this.pedal4A.addBox(-7.0F, -0.5F, -3.0F, 8, 0, 6, 0.0F);
		this.setRotateAngle(pedal4A, 0.0F, 0.0F, 0.5235987755982988F);
		this.baseDetail1 = new ModelRenderer(this, 80, 15);
		this.baseDetail1.setRotationPoint(0.0F, -1.0F, 3.5F);
		this.baseDetail1.addBox(-4.5F, -0.5F, 0.0F, 9, 1, 3, 0.0F);
		this.setRotateAngle(baseDetail1, 0.7853981633974483F, 0.0F, 0.0F);
		this.pedal2Joint = new ModelRenderer(this, 0, 0);
		this.pedal2Joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pedal2Joint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(pedal2Joint, 0.0F, 1.5707963267948966F, 0.0F);
		this.tongeMouth = new ModelRenderer(this, 50, 100);
		this.tongeMouth.setRotationPoint(0.0F, -9.5F, 0.0F);
		this.tongeMouth.addBox(0.0F, -9.0F, -2.5F, 2, 9, 5, 0.0F);
		this.setRotateAngle(tongeMouth, 0.0F, 0.0F, 0.5235987755982988F);
		this.pedal1A = new ModelRenderer(this, 80, 105);
		this.pedal1A.setRotationPoint(-6.2F, -0.1F, 0.0F);
		this.pedal1A.addBox(-7.0F, -0.5F, -3.0F, 8, 0, 6, 0.0F);
		this.setRotateAngle(pedal1A, 0.0F, 0.0F, 0.5235987755982988F);
		this.pedal3B = new ModelRenderer(this, 80, 95);
		this.pedal3B.setRotationPoint(-6.5F, -0.1F, 0.0F);
		this.pedal3B.addBox(-7.0F, -0.5F, -1.5F, 7, 0, 3, 0.0F);
		this.setRotateAngle(pedal3B, 0.0F, 0.0F, 0.5235987755982988F);
		this.tongue3 = new ModelRenderer(this, 50, 40);
		this.tongue3.setRotationPoint(0.0F, -10.0F, 0.0F);
		this.tongue3.addBox(-1.01F, -7.0F, -1.01F, 2, 11, 2, 0.0F);
		this.pedal3A = new ModelRenderer(this, 80, 105);
		this.pedal3A.setRotationPoint(-6.2F, -0.1F, 0.0F);
		this.pedal3A.addBox(-7.0F, -0.5F, -3.0F, 8, 0, 6, 0.0F);
		this.setRotateAngle(pedal3A, 0.0F, 0.0F, 0.5235987755982988F);
		this.pedal4Joint = new ModelRenderer(this, 0, 0);
		this.pedal4Joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pedal4Joint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(pedal4Joint, 0.0F, -3.141592653589793F, 0.0F);
		this.baseDetail4 = new ModelRenderer(this, 80, 15);
		this.baseDetail4.setRotationPoint(-3.5F, -1.0F, 0.0F);
		this.baseDetail4.addBox(-4.5F, -0.5F, 0.0F, 9, 1, 3, 0.0F);
		this.setRotateAngle(baseDetail4, 0.7853981633974483F, 1.5707963267948966F, -1.5707963267948966F);
		this.stem3 = new ModelRenderer(this, 0, 85);
		this.stem3.setRotationPoint(0.0F, -10.5F, 0.01F);
		this.stem3.addBox(-1.0F, -11.0F, -1.0F, 2, 12, 2, 0.0F);
		this.pedal4B = new ModelRenderer(this, 80, 95);
		this.pedal4B.setRotationPoint(-6.5F, -0.1F, 0.0F);
		this.pedal4B.addBox(-7.0F, -0.5F, -1.5F, 7, 0, 3, 0.0F);
		this.setRotateAngle(pedal4B, 0.0F, 0.0F, 0.5235987755982988F);
		this.baseDetail3 = new ModelRenderer(this, 80, 15);
		this.baseDetail3.setRotationPoint(0.0F, -1.0F, -3.5F);
		this.baseDetail3.addBox(-4.5F, -0.5F, 0.0F, 9, 1, 3, 0.0F);
		this.setRotateAngle(baseDetail3, 0.7853981633974483F, 3.141592653589793F, 0.0F);
		this.stem2 = new ModelRenderer(this, 0, 100);
		this.stem2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.stem2.addBox(-1.5F, -11.0F, -1.5F, 3, 12, 3, 0.0F);
		this.tongue1 = new ModelRenderer(this, 50, 5);
		this.tongue1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tongue1.addBox(-2.0F, -7.0F, -2.0F, 4, 7, 4, 0.0F);
		this.pedal2A = new ModelRenderer(this, 80, 105);
		this.pedal2A.setRotationPoint(-6.2F, -0.1F, 0.0F);
		this.pedal2A.addBox(-7.0F, -0.5F, -3.0F, 8, 0, 6, 0.0F);
		this.setRotateAngle(pedal2A, 0.0F, 0.0F, 0.5235987755982988F);
		this.flowerBase = new ModelRenderer(this, 0, 65);
		this.flowerBase.setRotationPoint(0.0F, -12.0F, 0.0F);
		this.flowerBase.addBox(-5.0F, 0.0F, -5.0F, 10, 3, 10, 0.0F);
		this.pedal2B = new ModelRenderer(this, 80, 95);
		this.pedal2B.setRotationPoint(-6.5F, -0.1F, 0.0F);
		this.pedal2B.addBox(-7.0F, -0.5F, -1.5F, 7, 0, 3, 0.0F);
		this.setRotateAngle(pedal2B, 0.0F, 0.0F, 0.5235987755982988F);
		this.base = new ModelRenderer(this, 80, 0);
		this.base.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.base.addBox(-5.0F, -2.0F, -5.0F, 10, 2, 10, 0.0F);
		this.setRotateAngle(base, 0.0F, 0.7853981633974483F, 0.0F);
		this.stem1 = new ModelRenderer(this, 0, 115);
		this.stem1.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.stem1.addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(stem1, 0.0F, 0.7853981633974483F, 0.0F);
		this.pedal3Joint = new ModelRenderer(this, 0, 0);
		this.pedal3Joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pedal3Joint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(pedal3Joint, 0.0F, -1.5707963267948966F, 0.0F);
		this.pedal1Joint = new ModelRenderer(this, 0, 0);
		this.pedal1Joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pedal1Joint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.pedal1 = new ModelRenderer(this, 80, 115);
		this.pedal1.setRotationPoint(-5.5F, 1.0F, 0.0F);
		this.pedal1.addBox(-6.0F, -0.5F, -4.0F, 7, 0, 8, 0.0F);
		this.setRotateAngle(pedal1, 0.0F, 0.0F, 0.5235987755982988F);
		this.pedal2 = new ModelRenderer(this, 80, 115);
		this.pedal2.setRotationPoint(-5.5F, 1.0F, 0.0F);
		this.pedal2.addBox(-6.0F, -0.5F, -4.0F, 7, 0, 8, 0.0F);
		this.setRotateAngle(pedal2, 0.0F, 0.0F, 0.5235987755982988F);
		this.pedal1B = new ModelRenderer(this, 80, 95);
		this.pedal1B.setRotationPoint(-6.5F, -0.1F, 0.0F);
		this.pedal1B.addBox(-7.0F, -0.5F, -1.5F, 7, 0, 3, 0.0F);
		this.setRotateAngle(pedal1B, 0.0F, 0.0F, 0.5235987755982988F);
		this.tongeMouth2 = new ModelRenderer(this, 50, 80);
		this.tongeMouth2.setRotationPoint(0.0F, -9.5F, 0.0F);
		this.tongeMouth2.addBox(-2.0F, -9.0F, -2.5F, 2, 9, 5, 0.0F);
		this.setRotateAngle(tongeMouth2, 0.0F, 0.0F, -0.5235987755982988F);
		
		this.pedal4Joint.addChild(this.pedal4);
		this.base.addChild(this.baseDetail2);
		this.tongue1.addChild(this.tongue2);
		this.flowerBase.addChild(this.teeth);
		this.tongue3.addChild(this.tongue4);
		this.pedal3Joint.addChild(this.pedal3);
		this.pedal4.addChild(this.pedal4A);
		this.base.addChild(this.baseDetail1);
		this.flowerBase.addChild(this.pedal2Joint);
		this.tongue4.addChild(this.tongeMouth);
		this.pedal1.addChild(this.pedal1A);
		this.pedal3A.addChild(this.pedal3B);
		this.tongue2.addChild(this.tongue3);
		this.pedal3.addChild(this.pedal3A);
		this.flowerBase.addChild(this.pedal4Joint);
		this.base.addChild(this.baseDetail4);
		this.stem2.addChild(this.stem3);
		this.pedal4A.addChild(this.pedal4B);
		this.base.addChild(this.baseDetail3);
		this.stem1.addChild(this.stem2);
		this.flowerBase.addChild(this.tongue1);
		this.pedal2.addChild(this.pedal2A);
		this.stem3.addChild(this.flowerBase);
		this.pedal2A.addChild(this.pedal2B);
		this.base.addChild(this.stem1);
		this.flowerBase.addChild(this.pedal3Joint);
		this.flowerBase.addChild(this.pedal1Joint);
		this.pedal1Joint.addChild(this.pedal1);
		this.pedal2Joint.addChild(this.pedal2);
		this.pedal1A.addChild(this.pedal1B);
		this.tongue4.addChild(this.tongeMouth2);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{ 
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.base.offsetX, this.base.offsetY, this.base.offsetZ);
		GlStateManager.translate(this.base.rotationPointX * f5, this.base.rotationPointY * f5, this.base.rotationPointZ * f5);
		GlStateManager.scale(1.0D, 1.4D, 1.0D);
		GlStateManager.translate(-this.base.offsetX, -this.base.offsetY, -this.base.offsetZ);
		GlStateManager.translate(-this.base.rotationPointX * f5, -this.base.rotationPointY * f5, -this.base.rotationPointZ * f5);
		this.base.render(f5);
		GlStateManager.popMatrix();
	}
	
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
