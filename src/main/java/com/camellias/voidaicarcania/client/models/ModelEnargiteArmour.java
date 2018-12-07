package com.camellias.voidaicarcania.client.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ModelEnargiteArmour extends ModelBiped
{
	public final EntityEquipmentSlot slot;
	
    public ModelRenderer HelmetFrontTop;
    public ModelRenderer HelmetFrontRight;
    public ModelRenderer HelmetFrontLeft;
    public ModelRenderer HelmetTop;
    public ModelRenderer HelmetLeft1;
    public ModelRenderer HelmetLeft2;
    public ModelRenderer HelmetRight1;
    public ModelRenderer HelmetRight2;
    public ModelRenderer HelmetBack;
    public ModelRenderer HeadFrontMask1;
    public ModelRenderer HeadFrontMask2;
    
    public ModelRenderer ChestPlate;
    public ModelRenderer ChestChain;
    
    public ModelRenderer RightSpaulder;
    public ModelRenderer RightSpike1;
    public ModelRenderer RightSpike2;
    public ModelRenderer RightChainSleeve;
    
    public ModelRenderer LeftSpaulder;
    public ModelRenderer LeftSpike1;
    public ModelRenderer LeftSpike2;
    public ModelRenderer LeftChainSleeve;
    
    private ModelRenderer RightLegGuard;
    private ModelRenderer RightFoot;
    
    private ModelRenderer LeftLegGuard;
    private ModelRenderer LeftFoot;

    public ModelEnargiteArmour(EntityEquipmentSlot slot)
    {
    	this.slot = slot;
    	
        textureWidth = 128;
        textureHeight = 128;
        
        LeftSpike2 = new ModelRenderer(this, 54 + 64, 69 - 64);
        LeftSpike2.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftSpike2.addBox(2.0F, -3.5F, -0.5F, 1, 1, 1, 0.0F);
        
        HelmetFrontLeft = new ModelRenderer(this, 0 + 64, 68 - 64);
        HelmetFrontLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontLeft.addBox(3.0F, -6.0F, -5.0F, 2, 5, 1, 0.0F);
        setRotateAngle(HelmetFrontLeft, 0.0F, 0.0F, -0.17453292519943295F);
        
        RightChainSleeve = new ModelRenderer(this, 0 + 64, 104 - 64);
        RightChainSleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightChainSleeve.addBox(-3.5F, 0.8F, -2.5F, 5, 3, 5, 0.0F);
        
        HelmetFrontRight = new ModelRenderer(this, 0 + 64, 68 - 64);
        HelmetFrontRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontRight.addBox(-5.0F, -6.0F, -5.0F, 2, 5, 1, 0.0F);
        setRotateAngle(HelmetFrontRight, 0.0F, 0.0F, 0.17453292519943295F);
        
        LeftSpaulder = new ModelRenderer(this, 0 + 64, 95 - 64);
        LeftSpaulder.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftSpaulder.addBox(-2.0F, -3.0F, -2.5F, 6, 4, 5, 0.0F);
        setRotateAngle(LeftSpaulder, 0.0F, 0.0F, 0.17453292519943295F);
        
        HelmetRight1 = new ModelRenderer(this, 32 + 64, 64 - 64);
        HelmetRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetRight1.addBox(-5.0F, -8.0F, -4.0F, 1, 5, 8, 0.0F);
        
        ChestPlate = new ModelRenderer(this, 0 + 64, 83 - 64);
        ChestPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
        ChestPlate.addBox(-4.0F, 0.0F, -3.0F, 8, 6, 6, 0.0F);
        
        LeftChainSleeve = new ModelRenderer(this, 0 + 64, 104 - 64);
        LeftChainSleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftChainSleeve.addBox(-1.5F, 0.8F, -2.5F, 5, 3, 5, 0.0F);
        
        RightSpaulder = new ModelRenderer(this, 0 + 64, 95 - 64);
        RightSpaulder.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightSpaulder.addBox(-4.0F, -3.0F, -2.5F, 6, 4, 5, 0.0F);
        setRotateAngle(RightSpaulder, 0.0F, 0.0F, -0.17453292519943295F);
        
        HelmetTop = new ModelRenderer(this, 0 + 64, 74 - 64);
        HelmetTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetTop.addBox(-4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F);
        
        HelmetLeft1 = new ModelRenderer(this, 32 + 64, 64 - 64);
        HelmetLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetLeft1.addBox(4.0F, -8.0F, -4.0F, 1, 5, 8, 0.0F);
        
        HelmetFrontTop = new ModelRenderer(this, 0 + 64, 64 - 64);
        HelmetFrontTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontTop.addBox(-4.0F, -8.0F, -5.0F, 8, 3, 1, 0.0F);
        
        HelmetBack = new ModelRenderer(this, 32 + 64, 77 - 64);
        HelmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetBack.addBox(-4.0F, -8.0F, 4.0F, 8, 5, 1, 0.0F);
        
        RightSpike2 = new ModelRenderer(this, 54 + 64, 69 - 64);
        RightSpike2.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightSpike2.addBox(-3.0F, -3.5F, -0.5F, 1, 1, 1, 0.0F);
        
        LeftSpike1 = new ModelRenderer(this, 54 + 64, 69 - 64);
        LeftSpike1.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftSpike1.addBox(0.0F, -3.8F, -0.5F, 1, 1, 1, 0.0F);
        
        HeadFrontMask1 = new ModelRenderer(this, 50 + 64, 64 - 64);
        HeadFrontMask1.setRotationPoint(0.0F, 0.0F, 0.0F);
        HeadFrontMask1.addBox(-3.0F, -3.0F, -4.5F, 6, 1, 1, 0.0F);
        
        ChestChain = new ModelRenderer(this, 28 + 64, 83 - 64);
        ChestChain.setRotationPoint(0.0F, 0.0F, 0.0F);
        ChestChain.addBox(-4.0F, 6.0F, -2.5F, 8, 6, 5, 0.0F);
        
        HelmetLeft2 = new ModelRenderer(this, 18 + 64, 64 - 64);
        HelmetLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetLeft2.addBox(4.0F, -3.0F, -4.0F, 1, 1, 5, 0.0F);
        
        HeadFrontMask2 = new ModelRenderer(this, 50 + 64, 68 - 64);
        HeadFrontMask2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HeadFrontMask2.addBox(-0.5F, -5.0F, -4.5F, 1, 2, 1, 0.0F);
        
        HelmetRight2 = new ModelRenderer(this, 18 + 64, 64 - 64);
        HelmetRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetRight2.addBox(-5.0F, -3.0F, -4.0F, 1, 1, 5, 0.0F);
        
        RightSpike1 = new ModelRenderer(this, 54 + 64, 69 - 64);
        RightSpike1.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightSpike1.addBox(-1.0F, -3.8F, -0.5F, 1, 1, 1, 0.0F);
        
        RightLegGuard = new ModelRenderer(this, 24 + 64, 109 - 64);
        RightLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightLegGuard.addBox(-2.1F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        LeftLegGuard = new ModelRenderer(this, 24 + 64, 109 - 64);
        LeftLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftLegGuard.addBox(-1.9F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        RightFoot = new ModelRenderer(this, 40 + 64, 94 - 64);
        RightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightFoot.addBox(-2.2F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        LeftFoot = new ModelRenderer(this, 40 + 64, 94 - 64);
        LeftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftFoot.addBox(-1.8F, 6.0F, -3.0F, 4, 6, 6, 0.0F); 
        
        
        
        
        
        bipedHead.addChild(HelmetFrontLeft);
        bipedHead.addChild(HelmetRight1);
        bipedHead.addChild(HelmetFrontRight);
        bipedHead.addChild(HelmetTop);
        bipedHead.addChild(HelmetLeft1);
        bipedHead.addChild(HelmetFrontTop);
        bipedHead.addChild(HelmetBack);
        bipedHead.addChild(HelmetLeft2);
        bipedHead.addChild(HeadFrontMask2);
        bipedHead.addChild(HelmetRight2);
        bipedHead.addChild(HeadFrontMask1);
        
        bipedBody.addChild(ChestPlate);
        bipedBody.addChild(ChestChain);
        
        bipedRightArm.addChild(RightChainSleeve);
        bipedRightArm.addChild(RightSpaulder);
        bipedRightArm.addChild(RightSpike2);
        bipedRightArm.addChild(RightSpike1);
        
        bipedLeftArm.addChild(LeftSpike2);
        bipedLeftArm.addChild(LeftSpaulder);
        bipedLeftArm.addChild(LeftChainSleeve);
        bipedLeftArm.addChild(LeftSpike1);
        
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
