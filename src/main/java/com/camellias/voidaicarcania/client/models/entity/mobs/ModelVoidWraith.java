package com.camellias.voidaicarcania.client.models.entity.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelVoidWraith extends ModelBase
{
	public ModelRenderer body;
	public ModelRenderer wingLeft;
	public ModelRenderer wingRight;
	public ModelRenderer tailBase;
	public ModelRenderer legLeft3;
	public ModelRenderer legLeft2;
	public ModelRenderer legLeft1;
	public ModelRenderer legRight3;
	public ModelRenderer legRight2;
	public ModelRenderer legRight1;
	public ModelRenderer neckJoint;
	public ModelRenderer spines;
	public ModelRenderer tail;
	public ModelRenderer tailTip;
	public ModelRenderer legLeft3_2;
	public ModelRenderer legLeft2_2;
	public ModelRenderer legLeft1_2;
	public ModelRenderer legRight3_2;
	public ModelRenderer legRight2_2;
	public ModelRenderer legRight1_2;
	public ModelRenderer head;
	public ModelRenderer jaw;

	public ModelVoidWraith()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.legRight2_2 = new ModelRenderer(this, 0, 6);
		this.legRight2_2.setRotationPoint(0.0F, 5.0F, -0.1F);
		this.legRight2_2.addBox(0.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(legRight2_2, 0.0F, 0.0F, -1.0471975511965976F);
		
		this.legLeft3_2 = new ModelRenderer(this, 0, 6);
		this.legLeft3_2.setRotationPoint(0.0F, 5.0F, -0.1F);
		this.legLeft3_2.addBox(-1.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(legLeft3_2, 0.0F, 0.0F, 1.0471975511965976F);
		
		this.head = new ModelRenderer(this, 38, 14);
		this.head.setRotationPoint(0.0F, 0.5F, -0.5F);
		this.head.addBox(-3.0F, -3.0F, -6.0F, 6, 3, 6, 0.0F);
		
		this.neckJoint = new ModelRenderer(this, 50, 0);
		this.neckJoint.setRotationPoint(0.0F, 0.0F, -5.5F);
		this.neckJoint.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		
		this.legRight3 = new ModelRenderer(this, 0, 0);
		this.legRight3.setRotationPoint(-2.5F, 0.0F, 2.5F);
		this.legRight3.addBox(0.0F, 0.0F, -0.5F, 2, 5, 1, 0.0F);
		this.setRotateAngle(legRight3, 0.0F, 0.0F, 0.6108652381980153F);
		
		this.legLeft2 = new ModelRenderer(this, 0, 0);
		this.legLeft2.setRotationPoint(2.5F, 0.0F, 0.5F);
		this.legLeft2.addBox(-2.0F, 0.0F, -0.5F, 2, 5, 1, 0.0F);
		this.setRotateAngle(legLeft2, 0.0F, 0.0F, -0.6108652381980153F);
		
		this.legRight3_2 = new ModelRenderer(this, 0, 6);
		this.legRight3_2.setRotationPoint(0.0F, 5.0F, -0.1F);
		this.legRight3_2.addBox(0.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(legRight3_2, 0.0F, 0.0F, -1.0471975511965976F);
		
		this.tailBase = new ModelRenderer(this, 24, 0);
		this.tailBase.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.tailBase.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
		
		this.tail = new ModelRenderer(this, 24, 0);
		this.tail.setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
		
		this.tailTip = new ModelRenderer(this, 24, 0);
		this.tailTip.setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tailTip.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-2.5F, -2.0F, -6.0F, 5, 4, 14, 0.0F);
		
		this.wingLeft = new ModelRenderer(this, 0, 18);
		this.wingLeft.mirror = true;
		this.wingLeft.setRotationPoint(2.4F, -0.5F, 0.0F);
		this.wingLeft.addBox(0.0F, -0.5F, -5.0F, 14, 1, 10, 0.0F);
		
		this.legRight1 = new ModelRenderer(this, 0, 0);
		this.legRight1.setRotationPoint(-2.5F, 0.0F, -1.5F);
		this.legRight1.addBox(0.0F, 0.0F, -0.5F, 2, 5, 1, 0.0F);
		this.setRotateAngle(legRight1, 0.0F, 0.0F, 0.6108652381980153F);
		
		this.spines = new ModelRenderer(this, 0, 18);
		this.spines.setRotationPoint(0.0F, -2.0F, 1.0F);
		this.spines.addBox(0.0F, -2.0F, -6.0F, 0, 2, 12, 0.0F);
		
		this.legLeft1 = new ModelRenderer(this, 0, 0);
		this.legLeft1.setRotationPoint(2.5F, 0.0F, -1.5F);
		this.legLeft1.addBox(-2.0F, 0.0F, -0.5F, 2, 5, 1, 0.0F);
		this.setRotateAngle(legLeft1, 0.0F, 0.0F, -0.6108652381980153F);
		
		this.jaw = new ModelRenderer(this, 43, 24);
		this.jaw.setRotationPoint(0.0F, 0.5F, -0.5F);
		this.jaw.addBox(-2.0F, 0.0F, -5.0F, 4, 2, 5, 0.0F);
		
		this.legRight2 = new ModelRenderer(this, 0, 0);
		this.legRight2.setRotationPoint(-2.5F, 0.0F, 0.5F);
		this.legRight2.addBox(0.0F, 0.0F, -0.5F, 2, 5, 1, 0.0F);
		this.setRotateAngle(legRight2, 0.0F, 0.0F, 0.6108652381980153F);
		
		this.wingRight = new ModelRenderer(this, 0, 18);
		this.wingRight.setRotationPoint(-2.4F, -0.5F, 0.0F);
		this.wingRight.addBox(-14.0F, -0.5F, -5.0F, 14, 1, 10, 0.0F);
		
		this.legLeft2_2 = new ModelRenderer(this, 0, 6);
		this.legLeft2_2.setRotationPoint(0.0F, 5.0F, -0.1F);
		this.legLeft2_2.addBox(-1.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(legLeft2_2, 0.0F, 0.0F, 1.0471975511965976F);
		
		this.legLeft3 = new ModelRenderer(this, 0, 0);
		this.legLeft3.setRotationPoint(2.5F, 0.0F, 2.5F);
		this.legLeft3.addBox(-2.0F, 0.0F, -0.5F, 2, 5, 1, 0.0F);
		this.setRotateAngle(legLeft3, 0.0F, 0.0F, -0.6108652381980153F);
		
		this.legLeft1_2 = new ModelRenderer(this, 0, 6);
		this.legLeft1_2.setRotationPoint(0.0F, 5.0F, -0.1F);
		this.legLeft1_2.addBox(-1.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(legLeft1_2, 0.0F, 0.0F, 1.0471975511965976F);
		
		this.legRight1_2 = new ModelRenderer(this, 0, 6);
		this.legRight1_2.setRotationPoint(0.0F, 5.0F, -0.1F);
		this.legRight1_2.addBox(0.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(legRight1_2, 0.0F, 0.0F, -1.0471975511965976F);
		
		this.legRight2.addChild(this.legRight2_2);
		this.legLeft3.addChild(this.legLeft3_2);
		this.neckJoint.addChild(this.head);
		this.body.addChild(this.neckJoint);
		this.body.addChild(this.legRight3);
		this.body.addChild(this.legLeft2);
		this.legRight3.addChild(this.legRight3_2);
		this.body.addChild(this.tailBase);
		this.tailBase.addChild(this.tail);
		this.tail.addChild(this.tailTip);
		this.body.addChild(this.wingLeft);
		this.body.addChild(this.legRight1);
		this.body.addChild(this.spines);
		this.body.addChild(this.legLeft1);
		this.neckJoint.addChild(this.jaw);
		this.body.addChild(this.legRight2);
		this.body.addChild(this.wingRight);
		this.legLeft2.addChild(this.legLeft2_2);
		this.body.addChild(this.legLeft3);
		this.legLeft1.addChild(this.legLeft1_2);
		this.legRight1.addChild(this.legRight1_2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{ 
		this.body.render(f5);
	}
	
	@Override
	public void setRotationAngles(float swing, float swingAmount, float age, float headYaw,
			float headPitch, float scale, Entity entity)
	{
		/*this.UpperJaw.rotateAngleX = headPitch * 0.017453292F;
		this.LowerJaw.rotateAngleX = headPitch * -0.017453292F;
		
		this.RightWing1.rotateAngleZ = MathHelper.cos(swing * 0.6662F) * 1.4F * swingAmount;
		this.RightWing2.rotateAngleZ = MathHelper.cos(swing * 0.1331F + (float)Math.PI) * .7F * swingAmount;
		this.LeftWing1.rotateAngleZ = MathHelper.cos(swing * 0.6662F + (float)Math.PI) * 1.4F * swingAmount;
		this.LeftWing2.rotateAngleZ = MathHelper.cos(swing * 0.1331F) * .7F * swingAmount;
		
		this.Tail1.rotateAngleY = MathHelper.cos(swing * 0.1331F) * 0.7F * swingAmount;
		this.Tail1.rotateAngleY = MathHelper.cos(swing * 0.1331F) * -0.7F * swingAmount;
		this.Tail3.rotateAngleY = MathHelper.cos(swing * 0.1331F) * 0.7F * swingAmount;*/
	}
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
