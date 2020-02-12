package com.camellias.voidaicarcania.client.models.entity.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

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
	public ModelRenderer petal1Joint;
	public ModelRenderer petal2Joint;
	public ModelRenderer petal3Joint;
	public ModelRenderer petal4Joint;
	public ModelRenderer tongue1;
	public ModelRenderer teeth;
	public ModelRenderer petal1;
	public ModelRenderer petal1A;
	public ModelRenderer petal1B;
	public ModelRenderer petal2;
	public ModelRenderer petal2A;
	public ModelRenderer petal2B;
	public ModelRenderer petal3;
	public ModelRenderer petal3A;
	public ModelRenderer petal3B;
	public ModelRenderer petal4;
	public ModelRenderer petal4A;
	public ModelRenderer petal4B;
	public ModelRenderer tongue2;
	public ModelRenderer tongue3;
	public ModelRenderer tongue4;
	public ModelRenderer tongueMouth;
	public ModelRenderer tongueMouth2;
	
	public ModelBitingBelladonna()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		
		this.petal4 = new ModelRenderer(this, 80, 115);
		this.petal4.setRotationPoint(-5.5F, 1.0F, 0.0F);
		this.petal4.addBox(-6.0F, -0.5F, -4.0F, 7, 0, 8, 0.0F);
		this.setRotateAngle(petal4, 0.0F, 0.0F, 0.5235987755982988F);
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
		this.petal3 = new ModelRenderer(this, 80, 115);
		this.petal3.setRotationPoint(-5.5F, 1.0F, 0.0F);
		this.petal3.addBox(-6.0F, -0.5F, -4.0F, 7, 0, 8, 0.0F);
		this.setRotateAngle(petal3, 0.0F, 0.0F, 0.5235987755982988F);
		this.petal4A = new ModelRenderer(this, 80, 105);
		this.petal4A.setRotationPoint(-6.2F, -0.1F, 0.0F);
		this.petal4A.addBox(-7.0F, -0.5F, -3.0F, 8, 0, 6, 0.0F);
		this.setRotateAngle(petal4A, 0.0F, 0.0F, 0.5235987755982988F);
		this.baseDetail1 = new ModelRenderer(this, 80, 15);
		this.baseDetail1.setRotationPoint(0.0F, -1.0F, 3.5F);
		this.baseDetail1.addBox(-4.5F, -0.5F, 0.0F, 9, 1, 3, 0.0F);
		this.setRotateAngle(baseDetail1, 0.7853981633974483F, 0.0F, 0.0F);
		this.petal2Joint = new ModelRenderer(this, 0, 0);
		this.petal2Joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.petal2Joint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(petal2Joint, 0.0F, 1.5707963267948966F, 0.0F);
		this.tongueMouth = new ModelRenderer(this, 50, 100);
		this.tongueMouth.setRotationPoint(0.0F, -9.5F, 0.0F);
		this.tongueMouth.addBox(0.0F, -9.0F, -2.5F, 2, 9, 5, 0.0F);
		this.setRotateAngle(tongueMouth, 0.0F, 0.0F, 0.5235987755982988F);
		this.petal1A = new ModelRenderer(this, 80, 105);
		this.petal1A.setRotationPoint(-6.2F, -0.1F, 0.0F);
		this.petal1A.addBox(-7.0F, -0.5F, -3.0F, 8, 0, 6, 0.0F);
		this.setRotateAngle(petal1A, 0.0F, 0.0F, 0.5235987755982988F);
		this.petal3B = new ModelRenderer(this, 80, 95);
		this.petal3B.setRotationPoint(-6.5F, -0.1F, 0.0F);
		this.petal3B.addBox(-7.0F, -0.5F, -1.5F, 7, 0, 3, 0.0F);
		this.setRotateAngle(petal3B, 0.0F, 0.0F, 0.5235987755982988F);
		this.tongue3 = new ModelRenderer(this, 50, 40);
		this.tongue3.setRotationPoint(0.0F, -10.0F, 0.0F);
		this.tongue3.addBox(-1.01F, -7.0F, -1.01F, 2, 11, 2, 0.0F);
		this.petal3A = new ModelRenderer(this, 80, 105);
		this.petal3A.setRotationPoint(-6.2F, -0.1F, 0.0F);
		this.petal3A.addBox(-7.0F, -0.5F, -3.0F, 8, 0, 6, 0.0F);
		this.setRotateAngle(petal3A, 0.0F, 0.0F, 0.5235987755982988F);
		this.petal4Joint = new ModelRenderer(this, 0, 0);
		this.petal4Joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.petal4Joint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(petal4Joint, 0.0F, -3.141592653589793F, 0.0F);
		this.baseDetail4 = new ModelRenderer(this, 80, 15);
		this.baseDetail4.setRotationPoint(-3.5F, -1.0F, 0.0F);
		this.baseDetail4.addBox(-4.5F, -0.5F, 0.0F, 9, 1, 3, 0.0F);
		this.setRotateAngle(baseDetail4, 0.7853981633974483F, 1.5707963267948966F, -1.5707963267948966F);
		this.stem3 = new ModelRenderer(this, 0, 85);
		this.stem3.setRotationPoint(0.0F, -10.5F, 0.01F);
		this.stem3.addBox(-1.0F, -11.0F, -1.0F, 2, 12, 2, 0.0F);
		this.petal4B = new ModelRenderer(this, 80, 95);
		this.petal4B.setRotationPoint(-6.5F, -0.1F, 0.0F);
		this.petal4B.addBox(-7.0F, -0.5F, -1.5F, 7, 0, 3, 0.0F);
		this.setRotateAngle(petal4B, 0.0F, 0.0F, 0.5235987755982988F);
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
		this.petal2A = new ModelRenderer(this, 80, 105);
		this.petal2A.setRotationPoint(-6.2F, -0.1F, 0.0F);
		this.petal2A.addBox(-7.0F, -0.5F, -3.0F, 8, 0, 6, 0.0F);
		this.setRotateAngle(petal2A, 0.0F, 0.0F, 0.5235987755982988F);
		this.flowerBase = new ModelRenderer(this, 0, 65);
		this.flowerBase.setRotationPoint(0.0F, -12.0F, 0.0F);
		this.flowerBase.addBox(-5.0F, 0.0F, -5.0F, 10, 3, 10, 0.0F);
		this.petal2B = new ModelRenderer(this, 80, 95);
		this.petal2B.setRotationPoint(-6.5F, -0.1F, 0.0F);
		this.petal2B.addBox(-7.0F, -0.5F, -1.5F, 7, 0, 3, 0.0F);
		this.setRotateAngle(petal2B, 0.0F, 0.0F, 0.5235987755982988F);
		this.base = new ModelRenderer(this, 80, 0);
		this.base.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.base.addBox(-5.0F, -2.0F, -5.0F, 10, 2, 10, 0.0F);
		this.setRotateAngle(base, 0.0F, 0.7853981633974483F, 0.0F);
		this.stem1 = new ModelRenderer(this, 0, 115);
		this.stem1.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.stem1.addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(stem1, 0.0F, 0.7853981633974483F, 0.0F);
		this.petal3Joint = new ModelRenderer(this, 0, 0);
		this.petal3Joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.petal3Joint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(petal3Joint, 0.0F, -1.5707963267948966F, 0.0F);
		this.petal1Joint = new ModelRenderer(this, 0, 0);
		this.petal1Joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.petal1Joint.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.petal1 = new ModelRenderer(this, 80, 115);
		this.petal1.setRotationPoint(-5.5F, 1.0F, 0.0F);
		this.petal1.addBox(-6.0F, -0.5F, -4.0F, 7, 0, 8, 0.0F);
		this.setRotateAngle(petal1, 0.0F, 0.0F, 0.5235987755982988F);
		this.petal2 = new ModelRenderer(this, 80, 115);
		this.petal2.setRotationPoint(-5.5F, 1.0F, 0.0F);
		this.petal2.addBox(-6.0F, -0.5F, -4.0F, 7, 0, 8, 0.0F);
		this.setRotateAngle(petal2, 0.0F, 0.0F, 0.5235987755982988F);
		this.petal1B = new ModelRenderer(this, 80, 95);
		this.petal1B.setRotationPoint(-6.5F, -0.1F, 0.0F);
		this.petal1B.addBox(-7.0F, -0.5F, -1.5F, 7, 0, 3, 0.0F);
		this.setRotateAngle(petal1B, 0.0F, 0.0F, 0.5235987755982988F);
		this.tongueMouth2 = new ModelRenderer(this, 50, 80);
		this.tongueMouth2.setRotationPoint(0.0F, -9.5F, 0.0F);
		this.tongueMouth2.addBox(-2.0F, -9.0F, -2.5F, 2, 9, 5, 0.0F);
		this.setRotateAngle(tongueMouth2, 0.0F, 0.0F, -0.5235987755982988F);
		
		this.petal4Joint.addChild(this.petal4);
		this.base.addChild(this.baseDetail2);
		this.tongue1.addChild(this.tongue2);
		this.flowerBase.addChild(this.teeth);
		this.tongue3.addChild(this.tongue4);
		this.petal3Joint.addChild(this.petal3);
		this.petal4.addChild(this.petal4A);
		this.base.addChild(this.baseDetail1);
		this.flowerBase.addChild(this.petal2Joint);
		this.tongue4.addChild(this.tongueMouth);
		this.petal1.addChild(this.petal1A);
		this.petal3A.addChild(this.petal3B);
		this.tongue2.addChild(this.tongue3);
		this.petal3.addChild(this.petal3A);
		this.flowerBase.addChild(this.petal4Joint);
		this.base.addChild(this.baseDetail4);
		this.stem2.addChild(this.stem3);
		this.petal4A.addChild(this.petal4B);
		this.base.addChild(this.baseDetail3);
		this.stem1.addChild(this.stem2);
		this.flowerBase.addChild(this.tongue1);
		this.petal2.addChild(this.petal2A);
		this.stem3.addChild(this.flowerBase);
		this.petal2A.addChild(this.petal2B);
		this.base.addChild(this.stem1);
		this.flowerBase.addChild(this.petal3Joint);
		this.flowerBase.addChild(this.petal1Joint);
		this.petal1Joint.addChild(this.petal1);
		this.petal2Joint.addChild(this.petal2);
		this.petal1A.addChild(this.petal1B);
		this.tongue4.addChild(this.tongueMouth2);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{ 
		GlStateManager.pushMatrix();
		GlStateManager.translate(0, -2.25, 0);
		this.base.rotateAngleZ = 3.125F;
		this.base.render(f5);
		GlStateManager.popMatrix();
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity)
	{
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		float petalAnim1 = (float) (Math.cos(ageInTicks * 0.05F) * 0.2F);
		float petalAnim2 = (float) (Math.cos(ageInTicks * 0.05F) * 0.3F);
		float petalAnim3 = (float) (Math.cos(ageInTicks * 0.05F) * 0.4F);
		
		this.petal1.rotateAngleZ = petalAnim1;
		this.petal1A.rotateAngleZ = petalAnim2;
		this.petal1B.rotateAngleZ = petalAnim3;
		this.petal2.rotateAngleZ = petalAnim1;
		this.petal2A.rotateAngleZ = petalAnim2;
		this.petal2B.rotateAngleZ = petalAnim3;
		this.petal3.rotateAngleZ = petalAnim1;
		this.petal3A.rotateAngleZ = petalAnim2;
		this.petal3B.rotateAngleZ = petalAnim3;
		this.petal4.rotateAngleZ = petalAnim1;
		this.petal4A.rotateAngleZ = petalAnim2;
		this.petal4B.rotateAngleZ = petalAnim3;
		
		this.teeth.rotateAngleY += 0.2F;
		
		this.tongue2.offsetY = 0.4F;
		this.tongue3.offsetY = 0.6F;
		this.tongue4.offsetY = 0.6F;
		
		EntityPlayer target = entity.world.getClosestPlayerToEntity(entity, 5D);
		BlockPos targetPos = target.getPosition().add(target.width / 2, target.eyeHeight, target.width / 2);
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
