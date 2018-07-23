package com.camellias.voidaicarcania.items.armour.models;

import javax.annotation.Nullable;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ModelMythrilArmour extends ModelArmourBase
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
    
    public ModelMythrilArmour(EntityEquipmentSlot slot)
    {
    	super(slot);
    	
        textureWidth = 64;
        textureHeight = 128;
        
        LeftLegGuard = new ModelRenderer(this, 22, 82);
        LeftLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftLegGuard.addBox(-1.9F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        RightFoot = new ModelRenderer(this, 40, 93);
        RightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightFoot.addBox(-2.2F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        HelmetTop = new ModelRenderer(this, 10, 72);
        HelmetTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetTop.addBox(-4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F);
        
        HelmetFrontLeft1 = new ModelRenderer(this, 34, 70);
        HelmetFrontLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontLeft1.addBox(3.0F, -8.0F, -5.0F, 1, 9, 1, 0.0F);
        
        RightPauldron2 = new ModelRenderer(this, 0, 91);
        RightPauldron2.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightPauldron2.addBox(-4.5F, -3.0F, -2.5F, 6, 2, 5, 0.0F);
        setRotateAngle(RightPauldron2, 0.0F, 0.0F, -0.17453292519943295F);
        
        HelmetFrontLeft2_1 = new ModelRenderer(this, 0, 64);
        HelmetFrontLeft2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontLeft2_1.addBox(-3.0F, -5.0F, -5.0F, 1, 1, 1, 0.0F);
        
        TorsoStomach = new ModelRenderer(this, 40, 77);
        TorsoStomach.setRotationPoint(0.0F, 0.0F, 0.0F);
        TorsoStomach.addBox(-4.0F, 7.0F, -2.5F, 8, 5, 5, 0.0F);
        
        RightPauldron1 = new ModelRenderer(this, 0, 81);
        RightPauldron1.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightPauldron1.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        LeftPauldron2 = new ModelRenderer(this, 0, 91);
        LeftPauldron2.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftPauldron2.addBox(-1.5F, -3.0F, -2.5F, 6, 2, 5, 0.0F);
        setRotateAngle(LeftPauldron2, 0.0F, 0.0F, 0.17453292519943295F);
        
        TorsoChest = new ModelRenderer(this, 40, 64);
        TorsoChest.setRotationPoint(0.0F, 0.0F, 0.0F);
        TorsoChest.addBox(-4.0F, 0.0F, -3.0F, 8, 7, 6, 0.0F);
        
        LeftPauldron1.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftPauldron1.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        HelmetRight1 = new ModelRenderer(this, 0, 65);
        HelmetRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetRight1.addBox(-5.0F, -8.0F, -4.0F, 1, 6, 8, 0.0F);
        
        HelmetBack = new ModelRenderer(this, 10, 65);
        HelmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetBack.addBox(-4.0F, -8.0F, 4.0F, 8, 6, 1, 0.0F);
        
        HelmetLeft2 = new ModelRenderer(this, 0, 67);
        HelmetLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetLeft2.addBox(4.0F, -2.0F, -4.0F, 1, 2, 3, 0.0F);
        
        HelmetFrontMid = new ModelRenderer(this, 0, 64);
        HelmetFrontMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontMid.addBox(-0.5F, -5.0F, -5.0F, 1, 2, 1, 0.0F);
        
        HelmetFrontLeft2 = new ModelRenderer(this, 0, 64);
        HelmetFrontLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontLeft2.addBox(2.0F, -5.0F, -5.0F, 1, 1, 1, 0.0F);
        
        HelmetFrontRight1 = new ModelRenderer(this, 34, 70);
        HelmetFrontRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontRight1.addBox(-4.0F, -8.0F, -5.0F, 1, 9, 1, 0.0F);
        
        HelmetLeft1 = new ModelRenderer(this, 0, 65);
        HelmetLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetLeft1.addBox(4.0F, -8.0F, -4.0F, 1, 6, 8, 0.0F);
        
        HelmetFrontTop = new ModelRenderer(this, 28, 64);
        HelmetFrontTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontTop.addBox(-3.0F, -8.0F, -5.0F, 6, 3, 1, 0.0F);
        setRotateAngle(HelmetFrontTop, 0.0F, 0.010821041362364843F, 0.0F);
        
        LeftFoot = new ModelRenderer(this, 40, 93);
        LeftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftFoot.addBox(-1.8F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        HelmetRight2 = new ModelRenderer(this, 0, 67);
        HelmetRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetRight2.addBox(-5.0F, -2.0F, -4.0F, 1, 2, 3, 0.0F);
        
        RightLegGuard = new ModelRenderer(this, 22, 82);
        RightLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightLegGuard.addBox(-2.1F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        
        
        
        
        bipedHead.addChild(HelmetTop);
        bipedHead.addChild(HelmetFrontLeft1);
        bipedHead.addChild(HelmetFrontLeft2_1);
        bipedHead.addChild(HelmetRight1);
        bipedHead.addChild(HelmetBack);
        bipedHead.addChild(HelmetLeft2);
        bipedHead.addChild(HelmetFrontMid);
        bipedHead.addChild(HelmetFrontLeft2);
        bipedHead.addChild(HelmetFrontRight1);
        bipedHead.addChild(HelmetLeft1);
        bipedHead.addChild(HelmetFrontTop);
        bipedHead.addChild(HelmetRight2);
    	
        bipedBody.addChild(TorsoStomach);
        bipedBody.addChild(TorsoChest);
        
        bipedRightArm.addChild(RightPauldron1);
        bipedRightArm.addChild(RightPauldron2);
        
        bipedLeftArm.addChild(LeftPauldron1);
        bipedLeftArm.addChild(LeftPauldron2);
        
        bipedRightLeg.addChild(RightLegGuard);
        bipedLeftLeg.addChild(LeftLegGuard);
        
        bipedRightLeg.addChild(RightFoot);
        bipedLeftLeg.addChild(LeftFoot);
    }
    
    @Override
    public void render(@Nullable Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	bipedHead.showModel = slot == EntityEquipmentSlot.HEAD;
    	
    	bipedBody.showModel = slot == EntityEquipmentSlot.CHEST;
    	bipedRightArm.showModel = slot == EntityEquipmentSlot.CHEST;
    	bipedLeftArm.showModel = slot == EntityEquipmentSlot.CHEST;
    	
    	bipedRightLeg.showModel = slot == EntityEquipmentSlot.LEGS;
    	bipedLeftLeg.showModel = slot == EntityEquipmentSlot.LEGS;
    	
        bipedRightLeg.showModel = slot == EntityEquipmentSlot.FEET;
        bipedLeftLeg.showModel = slot == EntityEquipmentSlot.FEET;
        
        bipedHeadwear.showModel = false;
        
        super.render(entity, f, f1, f2, f3, f4, f5);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
