package com.camellias.voidaicarcania.items.armour.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;


//-----Model made by Lone_Drifter-----//

public class ModelAstraliteArmour extends ModelBiped
{
	public static ModelAstraliteArmour INSTANCE_HEAD = new ModelAstraliteArmour(true, false, false, false);
	public static ModelAstraliteArmour INSTANCE_CHEST = new ModelAstraliteArmour(false, true, false, false);
	public static ModelAstraliteArmour INSTANCE_LEGS = new ModelAstraliteArmour(false, false, true, false);
	public static ModelAstraliteArmour INSTANCE_BOOTS = new ModelAstraliteArmour(false, false, false, true);
	
    public ModelRenderer HelmetTop;
    public ModelRenderer HelmetFrontMid;
    public ModelRenderer HelmetRight;
    public ModelRenderer HelmetLeft;
    public ModelRenderer HelmetBack;
    public ModelRenderer HelmetFrontLeft;
    public ModelRenderer HelmetWingRight;
    public ModelRenderer HelmetFront;
    public ModelRenderer HelmetWingLeft;
    public ModelRenderer HelmetFrontRight;
    
    public ModelRenderer BodyFront;
    public ModelRenderer BodyBack;
    public ModelRenderer BodyRight;
    public ModelRenderer BodyLeft;
    
    public ModelRenderer RightSleeve;
    public ModelRenderer RightPauldron;
    
    public ModelRenderer LeftSleeve;
    public ModelRenderer LeftPauldron;
    
    private ModelRenderer RightLegGuard;
    
    private ModelRenderer RightFoot;
    private ModelRenderer LeftLegGuard;
    private ModelRenderer LeftFoot;

    public ModelAstraliteArmour(boolean isHelm, boolean isChest, boolean isLegs, boolean isBoots)
    {
        textureWidth = 128;
        textureHeight = 128;
        
        HelmetTop = new ModelRenderer(this, 0 + 64, 79 - 64);
        HelmetTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetTop.addBox(-4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F);
        
        HelmetWingRight = new ModelRenderer(this, 0 + 64, 64 - 64);
        HelmetWingRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetWingRight.addBox(-6.0F, -11.0F, -4.0F, 1, 8, 3, 0.0F);
        setRotateAngle(HelmetWingRight, -0.4363323129985824F, 0.0F, 0.0F);
        
        HelmetRight = new ModelRenderer(this, 44 + 64, 111 - 64);
        HelmetRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetRight.addBox(-5.0F, -8.0F, -5.0F, 1, 8, 9, 0.0F);
        
        HelmetFrontMid = new ModelRenderer(this, 12 + 64, 97 - 64);
        HelmetFrontMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontMid.addBox(-1.0F, -6.0F, -5.0F, 2, 3, 1, 0.0F);
        
        HelmetFront = new ModelRenderer(this, 40 + 64, 94 - 64);
        HelmetFront.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFront.addBox(-4.0F, -8.0F, -5.0F, 8, 3, 1, 0.0F);
        
        HelmetLeft = new ModelRenderer(this, 44 + 64, 111 - 64);
        HelmetLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetLeft.addBox(4.0F, -8.0F, -5.0F, 1, 8, 9, 0.0F);
        
        HelmetBack = new ModelRenderer(this, 0 + 64, 109 - 64);
        HelmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetBack.addBox(-4.0F, -8.0F, 4.0F, 8, 8, 1, 0.0F);
        
        HelmetWingLeft = new ModelRenderer(this, 0 + 64, 64 - 64);
        HelmetWingLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetWingLeft.addBox(5.0F, -11.0F, -4.0F, 1, 8, 3, 0.0F);
        setRotateAngle(HelmetWingLeft, -0.4363323129985824F, 0.0F, 0.0F);
        
        HelmetFrontLeft = new ModelRenderer(this, 12 + 64, 103 - 64);
        HelmetFrontLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontLeft.addBox(1.5F, -0.8F, -5.0F, 3, 2, 1, 0.0F);
        setRotateAngle(HelmetFrontLeft, 0.0F, 0.0F, -0.2617993877991494F);
        
        HelmetFrontRight = new ModelRenderer(this, 12 + 64, 103 - 64);
        HelmetFrontRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontRight.addBox(-4.5F, -0.8F, -5.0F, 3, 2, 1, 0.0F);
        setRotateAngle(HelmetFrontRight, 0.0F, 0.0F, 0.2617993877991494F);
        
        BodyRight = new ModelRenderer(this, 0 + 64, 92 - 64);
        BodyRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        BodyRight.addBox(-5.0F, 0.0F, -2.5F, 1, 12, 5, 0.0F);
        
        BodyLeft = new ModelRenderer(this, 0 + 64, 92 - 64);
        BodyLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        BodyLeft.addBox(4.0F, 0.0F, -2.5F, 1, 12, 5, 0.0F);
        
        BodyFront = new ModelRenderer(this, 32 + 64, 79 - 64);
        BodyFront.setRotationPoint(0.0F, 0.0F, 0.0F);
        BodyFront.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 1, 0.0F);
        
        BodyBack = new ModelRenderer(this, 32 + 64, 79 - 64);
        BodyBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        BodyBack.addBox(-4.0F, -0.2F, 2.0F, 8, 13, 1, 0.0F);
        
        RightSleeve = new ModelRenderer(this, 10 + 64, 65 - 64);
        RightSleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightSleeve.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        RightPauldron = new ModelRenderer(this, 32 + 64, 69 - 64);
        RightPauldron.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightPauldron.addBox(-7.0F, -3.0F, -3.5F, 8, 3, 7, 0.0F);
        setRotateAngle(RightPauldron, 0.0F, 0.0F, 0.2519043105695434F);
        
        LeftSleeve = new ModelRenderer(this, 10 + 64, 65 - 64);
        LeftSleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftSleeve.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        LeftPauldron = new ModelRenderer(this, 32 + 64, 69 - 64);
        LeftPauldron.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftPauldron.addBox(-1.0F, -3.0F, -3.5F, 8, 3, 7, 0.0F);
        setRotateAngle(LeftPauldron, 0.0F, 0.0F, -0.2617993877991494F);
        
        RightLegGuard = new ModelRenderer(this, 24 + 64, 109 - 64);
        RightLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightLegGuard.addBox(-2.1F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        LeftLegGuard = new ModelRenderer(this, 24 + 64, 109 - 64);
        LeftLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftLegGuard.addBox(-1.9F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        RightFoot = new ModelRenderer(this, 40 + 64, 98 - 64);
        RightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightFoot.addBox(-2.2F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        LeftFoot = new ModelRenderer(this, 40 + 64, 98 - 64);
        LeftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftFoot.addBox(-1.8F, 6.0F, -3.0F, 4, 6, 6, 0.0F); 
        
        
        if(isHelm)
        {
        	bipedHead.addChild(HelmetTop);
        	bipedHead.addChild(HelmetWingRight);
        	bipedHead.addChild(HelmetLeft);
        	bipedHead.addChild(HelmetBack);
        	bipedHead.addChild(HelmetWingLeft);
        	bipedHead.addChild(HelmetFrontLeft);
        	bipedHead.addChild(HelmetFrontRight);
        	bipedHead.addChild(HelmetFrontMid);
        	bipedHead.addChild(HelmetFront);
        	bipedHead.addChild(HelmetRight);
        }
        
        if(isChest)
        {
        	bipedBody.addChild(BodyRight);
        	bipedBody.addChild(BodyLeft);
        	bipedBody.addChild(BodyFront);
        	bipedBody.addChild(BodyBack);
	        
        	bipedRightArm.addChild(RightSleeve);
        	bipedRightArm.addChild(RightPauldron);
	        
        	bipedLeftArm.addChild(LeftSleeve);
        	bipedLeftArm.addChild(LeftPauldron);
        }
        
        if(isLegs)
        {
        	bipedRightLeg.addChild(RightLegGuard);
        	bipedLeftLeg.addChild(LeftLegGuard);
        }
        
        if(isBoots)
        {
        	bipedRightLeg.addChild(RightFoot);
        	bipedLeftLeg.addChild(LeftFoot);
        }
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
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
