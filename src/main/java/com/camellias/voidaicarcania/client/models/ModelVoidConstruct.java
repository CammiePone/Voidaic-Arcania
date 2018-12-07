package com.camellias.voidaicarcania.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelVoidConstruct extends ModelBase
{
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer Hips;
    public ModelRenderer RightArm;
    public ModelRenderer RightHand;
    public ModelRenderer LeftArm;
    public ModelRenderer LeftHand;
    public ModelRenderer RightLeg;
    public ModelRenderer RightFoot;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftFoot;
    public ModelRenderer Heart1;
    public ModelRenderer Heart2;
    public ModelRenderer Heart3;
    public ModelRenderer Vessel1;
    public ModelRenderer Vessel2;
    public ModelRenderer Vessel3;
    
    public ModelVoidConstruct() 
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -27.0F, -2.0F);
        this.Head.addBox(-6.0F, -14.0F, -6.0F, 12, 14, 12, 0.0F);
        
        this.Body = new ModelRenderer(this, 0, 26);
        this.Body.setRotationPoint(0.0F, -7.0F, 6.0F);
        this.Body.addBox(-16.0F, -24.0F, -10.0F, 32, 24, 20, 0.0F);
        this.setRotateAngle(Body, 0.34906584024429316F, -0.0F, 0.0F);
        
        this.RightArm = new ModelRenderer(this, 104, 0);
        this.RightArm.setRotationPoint(-16.0F, -25.0F, 0.0F);
        this.RightArm.addBox(-6.0F, -2.0F, -5.0F, 6, 20, 10, 0.0F);
        
        this.RightHand = new ModelRenderer(this, 104, 30);
        this.RightHand.setRotationPoint(-3.0F, 16.0F, 0.0F);
        this.RightHand.addBox(-5.0F, 0.0F, -6.0F, 8, 16, 12, 0.0F);
        this.setRotateAngle(RightHand, -0.13962634015954636F, -0.0F, 0.0F);
        
        this.LeftArm = new ModelRenderer(this, 104, 0);
        this.LeftArm.setRotationPoint(16.0F, -25.0F, 0.0F);
        this.LeftArm.addBox(0.0F, -2.0F, -5.0F, 6, 20, 10, 0.0F);
        
        this.LeftHand = new ModelRenderer(this, 104, 30);
        this.LeftHand.setRotationPoint(3.0F, 16.0F, 0.0F);
        this.LeftHand.addBox(-3.0F, 0.0F, -6.0F, 8, 16, 12, 0.0F);
        this.setRotateAngle(LeftHand, -0.13962634015954636F, -0.0F, 0.0F);
        
        this.Hips = new ModelRenderer(this, 0, 70);
        this.Hips.setRotationPoint(0.0F, -1.0F, 10.0F);
        this.Hips.addBox(-8.0F, -8.0F, -4.0F, 16, 8, 8, 0.0F);
        this.setRotateAngle(Hips, 0.6108652353286743F, -0.0F, 0.0F);
        
        this.RightLeg = new ModelRenderer(this, 0, 86);
        this.RightLeg.setRotationPoint(-8.0F, -3.0F, 8.0F);
        this.RightLeg.addBox(-4.0F, 0.0F, -4.0F, 8, 16, 8, 0.0F);
        this.setRotateAngle(RightLeg, -0.6108652353286743F, 0.0F, 0.0F);
        
        this.RightFoot = new ModelRenderer(this, 32, 86);
        this.RightFoot.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.RightFoot.addBox(-5.0F, 0.0F, -5.0F, 10, 16, 10, 0.0F);
        this.setRotateAngle(RightFoot, 0.6108652381980153F, -0.0F, 0.0F);
        
        this.LeftLeg = new ModelRenderer(this, 0, 86);
        this.LeftLeg.setRotationPoint(8.0F, -3.0F, 8.0F);
        this.LeftLeg.addBox(-4.0F, 0.0F, -4.0F, 8, 16, 8, 0.0F);
        this.setRotateAngle(LeftLeg, -0.6108652353286743F, 0.0F, 0.0F);
        
        this.LeftFoot = new ModelRenderer(this, 32, 86);
        this.LeftFoot.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.LeftFoot.addBox(-5.0F, 0.0F, -5.0F, 10, 16, 10, 0.0F);
        this.setRotateAngle(LeftFoot, 0.6108652381980153F, -0.0F, 0.0F);
        
        this.Heart1 = new ModelRenderer(this, 68, 0);
        this.Heart1.setRotationPoint(0.0F, -19.0F, 0.0F);
        this.Heart1.addBox(-3.0F, 0.0F, -3.0F, 3, 8, 6, 0.0F);
        
        this.Heart2 = new ModelRenderer(this, 48, 0);
        this.Heart2.setRotationPoint(-2.0F, -20.0F, 0.0F);
        this.Heart2.addBox(0.0F, 0.0F, -2.0F, 5, 8, 5, 0.0F);
        
        this.Heart3 = new ModelRenderer(this, 86, 0);
        this.Heart3.setRotationPoint(-3.0F, -18.0F, 0.0F);
        this.Heart3.addBox(-1.0F, 0.0F, -2.0F, 1, 6, 4, 0.0F);
        
        this.Vessel1 = new ModelRenderer(this, 48, 16);
        this.Vessel1.setRotationPoint(2.0F, -22.0F, 1.0F);
        this.Vessel1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        
        this.Vessel2 = new ModelRenderer(this, 48, 16);
        this.Vessel2.setRotationPoint(1.0F, -22.0F, -1.0F);
        this.Vessel2.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        
        this.Vessel3 = new ModelRenderer(this, 48, 16);
        this.Vessel3.setRotationPoint(-1.0F, -22.0F, 1.0F);
        this.Vessel3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        
        this.RightLeg.addChild(this.RightFoot);
        this.LeftArm.addChild(this.LeftHand);
        this.RightArm.addChild(this.RightHand);
        this.LeftLeg.addChild(this.LeftFoot);
    }
    
    @Override
    public void render(Entity entity, float f0, float f1, float f2, float f3, float f4, float f5) 
    {
    	this.Head.render(f5);
    	
        this.Body.render(f5);
        
        this.RightArm.render(f5);
        
        this.LeftArm.render(f5);
        
        this.Hips.render(f5);
        
        this.RightLeg.render(f5);
        
        this.LeftLeg.render(f5);
        
        this.Heart1.render(f5);
        this.Heart2.render(f5);
        this.Heart3.render(f5);
        
        this.Vessel1.render(f5);
        this.Vessel2.render(f5);
        this.Vessel3.render(f5);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, 
    		float headPitch, float scaleFactor, Entity entityIn) 
    {
    	this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.6108652353286743F;
    	this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount - 0.6108652353286743F;
    	
    	this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX = headPitch * 0.017453292F;
    }
}
