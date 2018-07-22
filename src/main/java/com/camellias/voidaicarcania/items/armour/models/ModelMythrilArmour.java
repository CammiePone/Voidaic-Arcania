package com.camellias.voidaicarcania.items.armour.models;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelMythrilArmour extends ModelBiped 
{
    private ModelRenderer HelmetLeft1;
    private ModelRenderer HelmetLeft2;
    private ModelRenderer HelmetRight1;
    private ModelRenderer HelmetRight2;
    private ModelRenderer HelmetFrontLeft1;
    private ModelRenderer HelmetFrontLeft2;
    private ModelRenderer HelmetFrontRight1;
    private ModelRenderer HelmetFrontLeft2_1;
    private ModelRenderer HelmetFrontTop;
    private ModelRenderer HelmetFrontMid;
    private ModelRenderer HelmetTop;
    private ModelRenderer HelmetBack;
    
    private ModelRenderer RightPauldron1;
    private ModelRenderer RightPauldron2;
    
    private ModelRenderer LeftPauldron1;
    private ModelRenderer LeftPauldron2;
    
    private ModelRenderer TorsoChest;
    private ModelRenderer TorsoStomach;
    
    private ModelRenderer RightLegGuard;
    private ModelRenderer RightFoot;
    
    private ModelRenderer LeftLegGuard;
    private ModelRenderer LeftFoot;
    
    public ModelMythrilArmour(float scale, boolean isHelmet, boolean isChest, boolean isLegs, boolean isBoots)
    {
    	super(scale, 0, 64, 128);
    	
        this.textureWidth = 64;
        this.textureHeight = 128;
        
        this.LeftLegGuard = new ModelRenderer(this, 22, 82);
        this.LeftLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftLegGuard.addBox(-1.9F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        this.RightFoot = new ModelRenderer(this, 40, 93);
        this.RightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightFoot.addBox(-2.2F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        this.HelmetTop = new ModelRenderer(this, 10, 72);
        this.HelmetTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetTop.addBox(-4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F);
        
        this.HelmetFrontLeft1 = new ModelRenderer(this, 34, 70);
        this.HelmetFrontLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetFrontLeft1.addBox(3.0F, -8.0F, -5.0F, 1, 9, 1, 0.0F);
        
        this.RightPauldron2 = new ModelRenderer(this, 0, 91);
        this.RightPauldron2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightPauldron2.addBox(-4.5F, -3.0F, -2.5F, 6, 2, 5, 0.0F);
        this.setRotateAngle(RightPauldron2, 0.0F, 0.0F, -0.17453292519943295F);
        
        this.HelmetFrontLeft2_1 = new ModelRenderer(this, 0, 64);
        this.HelmetFrontLeft2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetFrontLeft2_1.addBox(-3.0F, -5.0F, -5.0F, 1, 1, 1, 0.0F);
        
        this.TorsoStomach = new ModelRenderer(this, 40, 77);
        this.TorsoStomach.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TorsoStomach.addBox(-4.0F, 7.0F, -2.5F, 8, 5, 5, 0.0F);
        
        this.RightPauldron1 = new ModelRenderer(this, 0, 81);
        this.RightPauldron1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightPauldron1.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        this.LeftPauldron2 = new ModelRenderer(this, 0, 91);
        this.LeftPauldron2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftPauldron2.addBox(-1.5F, -3.0F, -2.5F, 6, 2, 5, 0.0F);
        this.setRotateAngle(LeftPauldron2, 0.0F, 0.0F, 0.17453292519943295F);
        
        this.TorsoChest = new ModelRenderer(this, 40, 64);
        this.TorsoChest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TorsoChest.addBox(-4.0F, 0.0F, -3.0F, 8, 7, 6, 0.0F);
        
        this.LeftPauldron1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftPauldron1.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        this.HelmetRight1 = new ModelRenderer(this, 0, 65);
        this.HelmetRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetRight1.addBox(-5.0F, -8.0F, -4.0F, 1, 6, 8, 0.0F);
        
        this.HelmetBack = new ModelRenderer(this, 10, 65);
        this.HelmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetBack.addBox(-4.0F, -8.0F, 4.0F, 8, 6, 1, 0.0F);
        
        this.HelmetLeft2 = new ModelRenderer(this, 0, 67);
        this.HelmetLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetLeft2.addBox(4.0F, -2.0F, -4.0F, 1, 2, 3, 0.0F);
        
        this.HelmetFrontMid = new ModelRenderer(this, 0, 64);
        this.HelmetFrontMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetFrontMid.addBox(-0.5F, -5.0F, -5.0F, 1, 2, 1, 0.0F);
        
        this.HelmetFrontLeft2 = new ModelRenderer(this, 0, 64);
        this.HelmetFrontLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetFrontLeft2.addBox(2.0F, -5.0F, -5.0F, 1, 1, 1, 0.0F);
        
        this.HelmetFrontRight1 = new ModelRenderer(this, 34, 70);
        this.HelmetFrontRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetFrontRight1.addBox(-4.0F, -8.0F, -5.0F, 1, 9, 1, 0.0F);
        
        this.HelmetLeft1 = new ModelRenderer(this, 0, 65);
        this.HelmetLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetLeft1.addBox(4.0F, -8.0F, -4.0F, 1, 6, 8, 0.0F);
        
        this.HelmetFrontTop = new ModelRenderer(this, 28, 64);
        this.HelmetFrontTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetFrontTop.addBox(-3.0F, -8.0F, -5.0F, 6, 3, 1, 0.0F);
        this.setRotateAngle(HelmetFrontTop, 0.0F, 0.010821041362364843F, 0.0F);
        
        this.LeftFoot = new ModelRenderer(this, 40, 93);
        this.LeftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftFoot.addBox(-1.8F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        this.HelmetRight2 = new ModelRenderer(this, 0, 67);
        this.HelmetRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetRight2.addBox(-5.0F, -2.0F, -4.0F, 1, 2, 3, 0.0F);
        
        this.RightLegGuard = new ModelRenderer(this, 22, 82);
        this.RightLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightLegGuard.addBox(-2.1F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        
        
        
        
        if(isHelmet)
        {
        	this.bipedHead.addChild(this.HelmetTop);
        	this.bipedHead.addChild(this.HelmetFrontLeft1);
        	this.bipedHead.addChild(this.HelmetFrontLeft2_1);
	        this.bipedHead.addChild(this.HelmetRight1);
	        this.bipedHead.addChild(this.HelmetBack);
	        this.bipedHead.addChild(this.HelmetLeft2);
	        this.bipedHead.addChild(this.HelmetFrontMid);
	        this.bipedHead.addChild(this.HelmetFrontLeft2);
	        this.bipedHead.addChild(this.HelmetFrontRight1);
	        this.bipedHead.addChild(this.HelmetLeft1);
	        this.bipedHead.addChild(this.HelmetFrontTop);
	        this.bipedHead.addChild(this.HelmetRight2);
        }
	        
        if(isChest)
        {
	        this.bipedBody.addChild(this.TorsoStomach);
	        this.bipedBody.addChild(this.TorsoChest);
	        
	        this.bipedRightArm.addChild(this.RightPauldron1);
	        this.bipedRightArm.addChild(this.RightPauldron2);
	        
	        this.bipedLeftArm.addChild(this.LeftPauldron1);
	        this.bipedLeftArm.addChild(this.LeftPauldron2);
        }
	        
        if(isLegs)
        {
	        this.bipedRightLeg.addChild(this.RightLegGuard);
	        this.bipedLeftLeg.addChild(this.LeftLegGuard);
        }
	    
        if(isBoots)
        {
	        this.bipedRightLeg.addChild(this.RightFoot);
	        this.bipedLeftLeg.addChild(this.LeftFoot);
        }
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
