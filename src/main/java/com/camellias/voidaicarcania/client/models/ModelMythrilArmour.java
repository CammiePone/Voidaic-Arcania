package com.camellias.voidaicarcania.client.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ModelMythrilArmour extends ModelBiped
{
	public final EntityEquipmentSlot slot;
	
    private ModelRenderer HelmetLeft1;
    private ModelRenderer HelmetLeft2;
    private ModelRenderer HelmetRight1;
    private ModelRenderer HelmetRight2;
    private ModelRenderer HelmetFrontLeft1;
    private ModelRenderer HelmetFrontLeft2;
    private ModelRenderer HelmetFrontRight1;
    private ModelRenderer HelmetFrontRight2;
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
    	this.slot = slot;
    	
        textureWidth = 128;
        textureHeight = 128;
        
        HelmetTop = new ModelRenderer(this, 0 + 64, 79 - 64);
        HelmetTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetTop.addBox(-4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F);
        
        HelmetBack = new ModelRenderer(this, 42 + 64, 106 - 64);
        HelmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetBack.addBox(-4.0F, -8.0F, 4.0F, 8, 6, 1, 0.0F);
        
        HelmetRight1 = new ModelRenderer(this, 0 + 64, 65 - 64);
        HelmetRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetRight1.addBox(-5.0F, -8.0F, -4.0F, 1, 6, 8, 0.0F);
        
        HelmetRight2 = new ModelRenderer(this, 2 + 642, 72 - 64);
        HelmetRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetRight2.addBox(-5.0F, -2.0F, -4.0F, 1, 2, 3, 0.0F);
        
        HelmetLeft1 = new ModelRenderer(this, 0 + 64, 65 - 64);
        HelmetLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetLeft1.addBox(4.0F, -8.0F, -4.0F, 1, 6, 8, 0.0F);
        
        HelmetLeft2 = new ModelRenderer(this, 22 + 64, 72 - 64);
        HelmetLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetLeft2.addBox(4.0F, -2.0F, -4.0F, 1, 2, 3, 0.0F);
        
        HelmetFrontTop = new ModelRenderer(this, 0 + 64, 89 - 64);
        HelmetFrontTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontTop.addBox(-3.0F, -8.0F, -5.0F, 6, 3, 1, 0.0F);
        setRotateAngle(HelmetFrontTop, 0.0F, 0.010821041362364843F, 0.0F);
        
        HelmetFrontMid = new ModelRenderer(this, 18 + 64, 72 - 64);
        HelmetFrontMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontMid.addBox(-0.5F, -5.0F, -5.0F, 1, 2, 1, 0.0F);
        
        HelmetFrontRight1 = new ModelRenderer(this, 33 + 64, 78 - 64);
        HelmetFrontRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontRight1.addBox(-4.0F, -8.0F, -5.0F, 1, 9, 1, 0.0F);
        
        HelmetFrontRight2 = new ModelRenderer(this, 18 + 64, 72 - 64);
        HelmetFrontRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontRight2.addBox(-3.0F, -5.0F, -5.0F, 1, 1, 1, 0.0F);
        
        HelmetFrontLeft1 = new ModelRenderer(this, 33 + 64, 78 - 64);
        HelmetFrontLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontLeft1.addBox(3.0F, -8.0F, -5.0F, 1, 9, 1, 0.0F);
        
        HelmetFrontLeft2 = new ModelRenderer(this, 18 + 64, 72 - 64);
        HelmetFrontLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontLeft2.addBox(2.0F, -5.0F, -5.0F, 1, 1, 1, 0.0F);
        
        
        
        
        
        TorsoChest = new ModelRenderer(this, 36 + 64, 64 - 64);
        TorsoChest.setRotationPoint(0.0F, 0.0F, 0.0F);
        TorsoChest.addBox(-4.0F, 0.0F, -3.0F, 8, 7, 6, 0.0F);
        
        TorsoStomach = new ModelRenderer(this, 38 + 64, 77 - 64);
        TorsoStomach.setRotationPoint(0.0F, 0.0F, 0.0F);
        TorsoStomach.addBox(-4.0F, 7.0F, -2.5F, 8, 5, 5, 0.0F);
        
        
        
        
        
        RightPauldron1 = new ModelRenderer(this, 0 + 64, 93 - 64);
        RightPauldron1.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightPauldron1.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        RightPauldron2 = new ModelRenderer(this, 0 + 64, 103 - 64);
        RightPauldron2.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightPauldron2.addBox(-4.5F, -3.0F, -2.5F, 6, 2, 5, 0.0F);
        setRotateAngle(RightPauldron2, 0.0F, 0.0F, -0.17453292519943295F);
        
        
        
        
        
        LeftPauldron1 = new ModelRenderer(this, 0 + 64, 93 - 64);
        LeftPauldron1.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftPauldron1.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        LeftPauldron2 = new ModelRenderer(this, 0 + 64, 103 - 64);
        LeftPauldron2.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftPauldron2.addBox(-1.5F, -3.0F, -2.5F, 6, 2, 5, 0.0F);
        setRotateAngle(LeftPauldron2, 0.0F, 0.0F, 0.17453292519943295F);
        
        
        
        
        
        RightLegGuard = new ModelRenderer(this, 24 + 64, 109 - 64);
        RightLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightLegGuard.addBox(-2.1F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        LeftLegGuard = new ModelRenderer(this, 24 + 64, 109 - 64);
        LeftLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftLegGuard.addBox(-1.9F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        
        
        
        
        RightFoot = new ModelRenderer(this, 40 + 64, 93 - 64);
        RightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightFoot.addBox(-2.2F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        LeftFoot = new ModelRenderer(this, 40 + 64, 93 - 64);
        LeftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftFoot.addBox(-1.8F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        
        
        
        
        bipedHead.addChild(HelmetTop);
        bipedHead.addChild(HelmetFrontLeft1);
        bipedHead.addChild(HelmetFrontRight2);
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
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	this.bipedHead.showModel = slot == EntityEquipmentSlot.HEAD;
		this.bipedHeadwear.showModel = slot == EntityEquipmentSlot.HEAD;
		
		this.bipedBody.showModel = slot == EntityEquipmentSlot.CHEST;
		this.bipedRightArm.showModel = slot == EntityEquipmentSlot.CHEST;
		this.bipedLeftArm.showModel = slot == EntityEquipmentSlot.CHEST;
		
		if(slot == EntityEquipmentSlot.LEGS)
		{
			this.bipedRightLeg.showModel = slot == EntityEquipmentSlot.LEGS;
			this.bipedLeftLeg.showModel = slot == EntityEquipmentSlot.LEGS;
		}
		else
		{
			this.bipedRightLeg.showModel = slot == EntityEquipmentSlot.FEET;
			this.bipedLeftLeg.showModel = slot == EntityEquipmentSlot.FEET;
		}
    	
        super.render(entity, f, f1, f2, f3, f4, f5);
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entity)
    {
    	if(entity instanceof EntityArmorStand)
    	{
			EntityArmorStand entityarmorstand = (EntityArmorStand) entity;
			this.bipedHead.rotateAngleX = 0.017453292F * entityarmorstand.getHeadRotation().getX();
			this.bipedHead.rotateAngleY = 0.017453292F * entityarmorstand.getHeadRotation().getY();
			this.bipedHead.rotateAngleZ = 0.017453292F * entityarmorstand.getHeadRotation().getZ();
			this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
			
			this.bipedBody.rotateAngleX = 0.017453292F * entityarmorstand.getBodyRotation().getX();
			this.bipedBody.rotateAngleY = 0.017453292F * entityarmorstand.getBodyRotation().getY();
			this.bipedBody.rotateAngleZ = 0.017453292F * entityarmorstand.getBodyRotation().getZ();
			
			this.bipedLeftArm.rotateAngleX = 0.017453292F * entityarmorstand.getLeftArmRotation().getX();
			this.bipedLeftArm.rotateAngleY = 0.017453292F * entityarmorstand.getLeftArmRotation().getY();
			this.bipedLeftArm.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftArmRotation().getZ();
			
			this.bipedRightArm.rotateAngleX = 0.017453292F * entityarmorstand.getRightArmRotation().getX();
			this.bipedRightArm.rotateAngleY = 0.017453292F * entityarmorstand.getRightArmRotation().getY();
			this.bipedRightArm.rotateAngleZ = 0.017453292F * entityarmorstand.getRightArmRotation().getZ();
			
			this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
			this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
			this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
			
			this.bipedRightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
			this.bipedRightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
			this.bipedRightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
			
			copyModelAngles(this.bipedHead, this.bipedHeadwear);
		}
    	
    	else
    	{
    		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
    	}
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
