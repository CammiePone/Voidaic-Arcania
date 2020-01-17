package com.camellias.voidaicarcania.client.models.entity.mobs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelKharonite extends ModelBiped
{
	public ModelRenderer RightHornBottom;
	public ModelRenderer LeftHornBottom;
	public ModelRenderer RightHornTop1;
	public ModelRenderer RightHornTop2;
	public ModelRenderer LeftHornTop1;
	public ModelRenderer LeftHornTop2;
	
	public ModelRenderer BackCrystalBase1;
	public ModelRenderer BackCrystalBase2;
	public ModelRenderer BackCrystal1;
	public ModelRenderer BackCrystal2;
	public ModelRenderer BackCrystal3;
	public ModelRenderer BackCrystal4;
	
	public ModelRenderer RightArmCrystalBottom;
	public ModelRenderer RightArmCrystal3;
	public ModelRenderer RightArmCrystalTop1;
	public ModelRenderer RightArmCrystalTop2;
	
	public ModelRenderer LeftArmCrystalBottom;
	public ModelRenderer LeftArmCrystal3;
	public ModelRenderer LeftArmCrystalTop1;
	public ModelRenderer LeftArmCrystalTop2;
	
	public ModelKharonite(boolean isAlex)
	{
		this.textureWidth = 64;
		this.textureHeight = 96;
		
		this.BackCrystal2 = new ModelRenderer(this, 14, 57);
		this.BackCrystal2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackCrystal2.addBox(0.0F, 2.5F, 0.5F, 3, 3, 5, 0.0F);
		this.setRotateAngle(BackCrystal2, 0.3490658503988659F, -0.4363323129985824F, 0.0F);
		
		this.BackCrystal4 = new ModelRenderer(this, 32, 49);
		this.BackCrystal4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackCrystal4.addBox(-4.1F, 5.0F, 1.0F, 3, 3, 5, 0.0F);
		this.setRotateAngle(BackCrystal4, 0.3490658503988659F, 0.6108652381980153F, 0.0F);
		
		this.RightHornTop1 = new ModelRenderer(this, 32, 6);
		this.RightHornTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightHornTop1.addBox(-8.2F, -10.0F, -2.6F, 1, 3, 1, 0.0F);
		this.setRotateAngle(RightHornTop1, -0.2617993877991494F, 0.0F, 0.6981317007977318F);
		
		this.bipedLeftLeg = new ModelRenderer(this, 0, 32);
		this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		
		this.BackCrystalBase2 = new ModelRenderer(this, 0, 50);
		this.BackCrystalBase2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackCrystalBase2.addBox(-3.0F, 4.0F, 2.0F, 4, 4, 3, 0.0F);
		this.setRotateAngle(BackCrystalBase2, -0.17453292519943295F, -0.3490658503988659F, 0.0F);
		
		this.RightArmCrystal3 = new ModelRenderer(this, 52, 0);
		this.RightArmCrystal3.setRotationPoint(-2.5F, -2.0F, 3.0F);
		this.RightArmCrystal3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(RightArmCrystal3, -0.9599310885968813F, 0.0F, -0.2617993877991494F);
		
		this.LeftHornBottom = new ModelRenderer(this, 32, 0);
		this.LeftHornBottom.setRotationPoint(-1.0F, 1.5F, 0.6F);
		this.LeftHornBottom.addBox(-0.2F, -11.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(LeftHornBottom, -0.08726646259971647F, 0.0F, 0.5235987755982988F);
		
		this.RightHornBottom = new ModelRenderer(this, 32, 0);
		this.RightHornBottom.setRotationPoint(0.8F, 2.5F, 0.5F);
		this.RightHornBottom.addBox(-1.8F, -11.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(RightHornBottom, 0.4363323129985824F, 0.0F, -0.5235987755982988F);
		
		this.BackCrystal3 = new ModelRenderer(this, 14, 48);
		this.BackCrystal3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackCrystal3.addBox(-2.3F, 4.0F, 4.0F, 3, 3, 6, 0.0F);
		this.setRotateAngle(BackCrystal3, -0.17453292519943295F, -0.17453292519943295F, 0.0F);
		
		this.RightHornTop2 = new ModelRenderer(this, 32, 10);
		this.RightHornTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightHornTop2.addBox(2.5F, -11.0F, -7.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(RightHornTop2, -0.7853981633974483F, 0.0F, -0.3490658503988659F);
		
		this.LeftHornTop1 = new ModelRenderer(this, 32, 6);
		this.LeftHornTop1.setRotationPoint(-0.5F, -1.0F, 3.5F);
		this.LeftHornTop1.addBox(7.2F, -10.0F, -2.6F, 1, 3, 1, 0.0F);
		this.setRotateAngle(LeftHornTop1, 0.2617993877991494F, 0.0F, -0.6981317007977318F);
		
		this.BackCrystal1 = new ModelRenderer(this, 30, 58);
		this.BackCrystal1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackCrystal1.addBox(-1.0F, 1.0F, 4.0F, 3, 3, 4, 0.0F);
		this.setRotateAngle(BackCrystal1, -0.3490658503988659F, 0.17453292519943295F, 0.0F);
		
		this.bipedBody = new ModelRenderer(this, 16, 16);
		this.bipedBody.setRotationPoint(0.0F, 0.3F, -2.0F);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		this.setRotateAngle(bipedBody, 0.17453292519943295F, 0.0F, 0.0F);
		
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		
		if(isAlex)
		{
			this.bipedRightArm = new ModelRenderer(this, 40, 16);
			this.bipedRightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);
			this.bipedRightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
			
			this.RightArmCrystalBottom = new ModelRenderer(this, 42, 0);
			this.RightArmCrystalBottom.mirror = true;
			this.RightArmCrystalBottom.setRotationPoint(0.0F, 4.0F, 1.0F);
			this.RightArmCrystalBottom.addBox(-1.7F, -3.0F, -1.5F, 2, 4, 2, 0.0F);
			this.setRotateAngle(RightArmCrystalBottom, -0.4363323129985824F, 0.0F, -0.5235987755982988F);
			
			this.RightArmCrystalTop1 = new ModelRenderer(this, 42, 6);
			this.RightArmCrystalTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.RightArmCrystalTop1.addBox(-2.5F, -4.0F, 0.5F, 1, 3, 1, 0.0F);
			this.setRotateAngle(RightArmCrystalTop1, 0.5235987755982988F, 0.0F, 0.4363323129985824F);
			
			this.RightArmCrystalTop2 = new ModelRenderer(this, 42, 10);
			this.RightArmCrystalTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.RightArmCrystalTop2.addBox(-0.7F, -5.0F, -1.5F, 1, 3, 1, 0.0F);
			this.setRotateAngle(RightArmCrystalTop2, -0.2617993877991494F, 0.0F, -0.2617993877991494F);
			
			this.bipedLeftArm = new ModelRenderer(this, 16, 32);
			this.bipedLeftArm.setRotationPoint(5.0F, 2.5F, 0.0F);
			this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
			
			this.LeftArmCrystalBottom = new ModelRenderer(this, 42, 0);
			this.LeftArmCrystalBottom.setRotationPoint(0.3F, 4.5F, 0.0F);
			this.LeftArmCrystalBottom.addBox(-1.7F, -5.0F, -1.5F, 2, 4, 2, 0.0F);
			this.setRotateAngle(LeftArmCrystalBottom, 0.3490658503988659F, 0.0F, 0.6981317007977318F);
			
			this.LeftArmCrystalTop1 = new ModelRenderer(this, 42, 6);
			this.LeftArmCrystalTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.LeftArmCrystalTop1.addBox(1.5F, -6.0F, 0.5F, 1, 3, 1, 0.0F);
			this.setRotateAngle(LeftArmCrystalTop1, 0.5235987755982988F, 0.0F, -0.4363323129985824F);
			
			this.LeftArmCrystalTop2 = new ModelRenderer(this, 42, 10);
			this.LeftArmCrystalTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.LeftArmCrystalTop2.addBox(-1.7F, -7.0F, -1.5F, 1, 3, 1, 0.0F);
			this.setRotateAngle(LeftArmCrystalTop2, -0.2617993877991494F, 0.0F, 0.2617993877991494F);
			
			this.LeftArmCrystal3 = new ModelRenderer(this, 52, 0);
			this.LeftArmCrystal3.setRotationPoint(2.0F, -2.0F, 3.0F);
			this.LeftArmCrystal3.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
			this.setRotateAngle(LeftArmCrystal3, -0.9599310885968813F, 0.0F, 0.3490658503988659F);
		}
		else
		{
			this.bipedRightArm = new ModelRenderer(this, 40, 16);
			this.bipedRightArm.setRotationPoint(-5.0F, 2.3F, -2.0F);
			this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
			
			this.RightArmCrystalBottom = new ModelRenderer(this, 42, 0);
			this.RightArmCrystalBottom.mirror = true;
			this.RightArmCrystalBottom.setRotationPoint(0.0F, 4.0F, 1.0F);
			this.RightArmCrystalBottom.addBox(-2.7F, -4.0F, -1.5F, 2, 4, 2, 0.0F);
			this.setRotateAngle(RightArmCrystalBottom, -0.4363323129985824F, 0.0F, -0.5235987755982988F);
			
			this.RightArmCrystalTop1 = new ModelRenderer(this, 42, 6);
			this.RightArmCrystalTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.RightArmCrystalTop1.addBox(-3.5F, -5.0F, 0.5F, 1, 3, 1, 0.0F);
			this.setRotateAngle(RightArmCrystalTop1, 0.5235987755982988F, 0.0F, 0.4363323129985824F);
			
			this.RightArmCrystalTop2 = new ModelRenderer(this, 42, 10);
			this.RightArmCrystalTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.RightArmCrystalTop2.addBox(-1.7F, -6.0F, -1.5F, 1, 3, 1, 0.0F);
			this.setRotateAngle(RightArmCrystalTop2, -0.2617993877991494F, 0.0F, -0.2617993877991494F);
			
			this.bipedLeftArm = new ModelRenderer(this, 16, 32);
			this.bipedLeftArm.setRotationPoint(5.0F, 2.3F, -2.0F);
			this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
			
			this.LeftArmCrystalBottom = new ModelRenderer(this, 42, 0);
			this.LeftArmCrystalBottom.setRotationPoint(0.3F, 4.5F, 0.0F);
			this.LeftArmCrystalBottom.addBox(0.7F, -4.0F, -1.5F, 2, 4, 2, 0.0F);
			this.setRotateAngle(LeftArmCrystalBottom, 0.3490658503988659F, 0.0F, 0.6981317007977318F);
			
			this.LeftArmCrystalTop1 = new ModelRenderer(this, 42, 6);
			this.LeftArmCrystalTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.LeftArmCrystalTop1.addBox(2.5F, -5.0F, 0.5F, 1, 3, 1, 0.0F);
			this.setRotateAngle(LeftArmCrystalTop1, 0.5235987755982988F, 0.0F, -0.4363323129985824F);
			
			this.LeftArmCrystalTop2 = new ModelRenderer(this, 42, 10);
			this.LeftArmCrystalTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.LeftArmCrystalTop2.addBox(0.7F, -6.0F, -1.5F, 1, 3, 1, 0.0F);
			this.setRotateAngle(LeftArmCrystalTop2, -0.2617993877991494F, 0.0F, 0.2617993877991494F);
			
			this.LeftArmCrystal3 = new ModelRenderer(this, 52, 0);
			this.LeftArmCrystal3.setRotationPoint(2.0F, -2.0F, 3.0F);
			this.LeftArmCrystal3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
			this.setRotateAngle(LeftArmCrystal3, -0.9599310885968813F, 0.0F, 0.3490658503988659F);
		}
		
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.setRotationPoint(0.0F, 0.5F, -2.0F);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		
		this.BackCrystalBase1 = new ModelRenderer(this, 0, 59);
		this.BackCrystalBase1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackCrystalBase1.addBox(-1.0F, 1.5F, 1.0F, 4, 4, 2, 0.0F);
		this.setRotateAngle(BackCrystalBase1, 0.17453292519943295F, 0.2617993877991494F, 0.0F);
		
		this.LeftHornTop2 = new ModelRenderer(this, 32, 10);
		this.LeftHornTop2.setRotationPoint(6.5F, -2.0F, 5.0F);
		this.LeftHornTop2.addBox(-3.5F, -11.0F, -7.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(LeftHornTop2, -0.2617993877991494F, 0.0F, -0.2617993877991494F);
		
		this.bipedLeftArm.addChild(this.LeftArmCrystalBottom);
		this.BackCrystalBase1.addChild(this.BackCrystal2);
		this.BackCrystalBase2.addChild(this.BackCrystal4);
		this.RightHornBottom.addChild(this.RightHornTop1);
		this.bipedRightArm.addChild(this.RightArmCrystalBottom);
		this.bipedBody.addChild(this.BackCrystalBase2);
		this.bipedRightArm.addChild(this.RightArmCrystal3);
		this.bipedHead.addChild(this.LeftHornBottom);
		this.bipedHead.addChild(this.RightHornBottom);
		this.RightArmCrystalBottom.addChild(this.RightArmCrystalTop1);
		this.BackCrystalBase2.addChild(this.BackCrystal3);
		this.RightHornBottom.addChild(this.RightHornTop2);
		this.LeftArmCrystalBottom.addChild(this.LeftArmCrystalTop1);
		this.LeftHornBottom.addChild(this.LeftHornTop1);
		this.BackCrystalBase1.addChild(this.BackCrystal1);
		this.bipedLeftArm.addChild(this.LeftArmCrystal3);
		this.RightArmCrystalBottom.addChild(this.RightArmCrystalTop2);
		this.bipedBody.addChild(this.BackCrystalBase1);
		this.LeftArmCrystalBottom.addChild(this.LeftArmCrystalTop2);
		this.LeftHornBottom.addChild(this.LeftHornTop2);
	}
	
	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		
		this.bipedLeftLeg.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedHead.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		this.bipedHead.setRotationPoint(0.0F, 0.5F, -2.0F);
		this.bipedBody.setRotationPoint(0.0F, 0.3F, -2.0F);
		this.bipedRightArm.setRotationPoint(-5.0F, 2.3F, -2.0F);
		this.bipedLeftArm.setRotationPoint(5.0F, 2.3F, -2.0F);
		this.bipedBody.rotateAngleX = 0.175F;
		
		if(this.isSneak)
		{
			this.bipedBody.rotateAngleX = 0.5F;
			this.bipedRightArm.rotateAngleX += 0.4F;
			this.bipedLeftArm.rotateAngleX += 0.4F;
			this.bipedRightLeg.rotationPointZ = 4.0F;
			this.bipedLeftLeg.rotationPointZ = 4.0F;
			this.bipedRightLeg.rotationPointY = 9.0F;
			this.bipedLeftLeg.rotationPointY = 9.0F;
			this.bipedHead.rotationPointY = 1.0F;
		}
	}
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
