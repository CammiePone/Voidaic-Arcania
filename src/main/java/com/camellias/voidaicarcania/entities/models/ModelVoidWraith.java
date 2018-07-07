package com.camellias.voidaicarcania.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelVoidWraith extends ModelBase
{
    public ModelRenderer UpperJaw;
    public ModelRenderer LowerJaw;
    public ModelRenderer Body;
    public ModelRenderer LeftWing1;
    public ModelRenderer RightWing1;
    public ModelRenderer LeftWing2;
    public ModelRenderer RightWing2;
    public ModelRenderer Tail1;
    public ModelRenderer Spine4;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Spine5;
    public ModelRenderer Spine6;
    public ModelRenderer Spine1;
    public ModelRenderer Spine2;
    public ModelRenderer Spine3;
    
    public ModelVoidWraith()
    {
        this.textureWidth = 128;
        this.textureHeight = 32;
        this.Spine4 = new ModelRenderer(this, 0, 26);
        this.Spine4.setRotationPoint(0.0F, -2.0F, 4.5F);
        this.Spine4.addBox(-1.0F, -0.6F, -1.5F, 2, 1, 3, 0.0F);
        this.UpperJaw = new ModelRenderer(this, 62, 0);
        this.UpperJaw.setRotationPoint(0.0F, 20.0F, -8.0F);
        this.UpperJaw.addBox(-3.5F, -2.0F, -8.0F, 7, 2, 8, 0.0F);
        this.Body = new ModelRenderer(this, 28, 0);
        this.Body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.Body.addBox(-4.0F, -2.0F, -9.0F, 8, 4, 18, 0.0F);
        this.Tail2 = new ModelRenderer(this, 92, 12);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tail2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 8, 0.0F);
        this.RightWing2 = new ModelRenderer(this, 0, 13);
        this.RightWing2.setRotationPoint(-9.0F, 0.0F, 0.0F);
        this.RightWing2.addBox(-8.0F, -0.5F, -6.0F, 8, 1, 12, 0.0F);
        this.Spine3 = new ModelRenderer(this, 0, 26);
        this.Spine3.setRotationPoint(0.0F, 18.0F, 6.0F);
        this.Spine3.addBox(-1.0F, -0.699999988079071F, -1.5F, 2, 1, 3, 0.0F);
        this.RightWing1 = new ModelRenderer(this, 0, 0);
        this.RightWing1.setRotationPoint(-3.0F, 20.0F, 0.0F);
        this.RightWing1.addBox(-9.0F, -0.5F, -6.0F, 9, 1, 12, 0.0F);
        this.Tail3 = new ModelRenderer(this, 92, 23);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 14.0F);
        this.Tail3.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 7, 0.0F);
        this.Spine5 = new ModelRenderer(this, 0, 26);
        this.Spine5.setRotationPoint(0.0F, -1.6F, 4.5F);
        this.Spine5.addBox(-1.0F, -0.5F, -1.5F, 2, 1, 3, 0.0F);
        this.Spine2 = new ModelRenderer(this, 0, 26);
        this.Spine2.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.Spine2.addBox(-1.0F, -0.800000011920929F, -1.5F, 2, 1, 3, 0.0F);
        this.LeftWing1 = new ModelRenderer(this, 0, 0);
        this.LeftWing1.setRotationPoint(3.0F, 20.0F, 0.0F);
        this.LeftWing1.addBox(0.0F, -0.5F, -6.0F, 9, 1, 12, 0.0F);
        this.Spine1 = new ModelRenderer(this, 0, 26);
        this.Spine1.setRotationPoint(0.0F, 18.0F, -6.0F);
        this.Spine1.addBox(-1.0F, -0.699999988079071F, -1.5F, 2, 1, 3, 0.0F);
        this.LeftWing2 = new ModelRenderer(this, 0, 13);
        this.LeftWing2.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.LeftWing2.addBox(0.0F, -0.5F, -6.0F, 8, 1, 12, 0.0F);
        this.Spine6 = new ModelRenderer(this, 10, 26);
        this.Spine6.setRotationPoint(0.0F, -1.0F, 4.0F);
        this.Spine6.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
        this.Tail1 = new ModelRenderer(this, 92, 0);
        this.Tail1.setRotationPoint(0.0F, 20.0F, 8.0F);
        this.Tail1.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 8, 0.0F);
        this.LowerJaw = new ModelRenderer(this, 62, 10);
        this.LowerJaw.setRotationPoint(0.0F, 20.0F, -8.0F);
        this.LowerJaw.addBox(-3.0F, 0.0F, -7.0F, 6, 1, 7, 0.0F);
        this.Tail1.addChild(this.Spine4);
        this.Tail1.addChild(this.Tail2);
        this.RightWing1.addChild(this.RightWing2);
        this.Tail1.addChild(this.Tail3);
        this.Tail2.addChild(this.Spine5);
        this.LeftWing1.addChild(this.LeftWing2);
        this.Tail3.addChild(this.Spine6);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    { 
        this.UpperJaw.render(f5);
        this.Body.render(f5);
        this.Spine3.render(f5);
        this.RightWing1.render(f5);
        this.Spine2.render(f5);
        this.LeftWing1.render(f5);
        this.Spine1.render(f5);
        this.Tail1.render(f5);
        this.LowerJaw.render(f5);
    }
    
    @Override
    public void setRotationAngles(float swing, float swingAmount, float age, float headYaw,
    		float headPitch, float scale, Entity entity)
    {
    	this.UpperJaw.rotateAngleX = headPitch * 0.017453292F;
    	this.LowerJaw.rotateAngleX = headPitch * -0.017453292F;
    	
    	this.RightWing1.rotateAngleZ = MathHelper.cos(swing * 0.6662F) * 1.4F * swingAmount;
    	this.RightWing2.rotateAngleZ = MathHelper.cos(swing * 0.1331F + (float)Math.PI) * .7F * swingAmount;
    	this.LeftWing1.rotateAngleZ = MathHelper.cos(swing * 0.6662F + (float)Math.PI) * 1.4F * swingAmount;
    	this.LeftWing2.rotateAngleZ = MathHelper.cos(swing * 0.1331F) * .7F * swingAmount;
    	
    	this.Tail1.rotateAngleY = MathHelper.cos(swing * 0.1331F) * 0.7F * swingAmount;
    	this.Tail1.rotateAngleY = MathHelper.cos(swing * 0.1331F) * -0.7F * swingAmount;
    	this.Tail3.rotateAngleY = MathHelper.cos(swing * 0.1331F) * 0.7F * swingAmount;
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
