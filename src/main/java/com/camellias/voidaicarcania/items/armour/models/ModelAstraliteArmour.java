package com.camellias.voidaicarcania.items.armour.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


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
        textureWidth = 64;
        textureHeight = 128;
        
        HelmetTop = new ModelRenderer(this, 0, 79);
        HelmetTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetTop.addBox(-4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F);
        
        HelmetWingRight = new ModelRenderer(this, 0, 64);
        HelmetWingRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetWingRight.addBox(-6.0F, -11.0F, -4.0F, 1, 8, 3, 0.0F);
        setRotateAngle(HelmetWingRight, -0.4363323129985824F, 0.0F, 0.0F);
        
        HelmetRight = new ModelRenderer(this, 0, 118);
        HelmetRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetRight.addBox(-5.0F, -8.0F, -5.0F, 1, 8, 9, 0.0F);
        
        HelmetFrontMid = new ModelRenderer(this, 12, 97);
        HelmetFrontMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontMid.addBox(-1.0F, -6.0F, -5.0F, 2, 3, 1, 0.0F);
        
        HelmetFront = new ModelRenderer(this, 40, 94);
        HelmetFront.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFront.addBox(-4.0F, -8.0F, -5.0F, 8, 3, 1, 0.0F);
        
        HelmetLeft = new ModelRenderer(this, 0, 118);
        HelmetLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetLeft.addBox(4.0F, -8.0F, -5.0F, 1, 8, 9, 0.0F);
        
        HelmetBack = new ModelRenderer(this, 0, 109);
        HelmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetBack.addBox(-4.0F, -8.0F, 4.0F, 8, 8, 1, 0.0F);
        
        HelmetWingLeft = new ModelRenderer(this, 0, 64);
        HelmetWingLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetWingLeft.addBox(5.0F, -11.0F, -4.0F, 1, 8, 3, 0.0F);
        setRotateAngle(HelmetWingLeft, -0.4363323129985824F, 0.0F, 0.0F);
        
        HelmetFrontLeft = new ModelRenderer(this, 12, 103);
        HelmetFrontLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontLeft.addBox(1.5F, -0.8F, -5.0F, 3, 2, 1, 0.0F);
        setRotateAngle(HelmetFrontLeft, 0.0F, 0.0F, -0.2617993877991494F);
        
        HelmetFrontRight = new ModelRenderer(this, 12, 103);
        HelmetFrontRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        HelmetFrontRight.addBox(-4.5F, -0.8F, -5.0F, 3, 2, 1, 0.0F);
        setRotateAngle(HelmetFrontRight, 0.0F, 0.0F, 0.2617993877991494F);
        
        BodyRight = new ModelRenderer(this, 0, 92);
        BodyRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        BodyRight.addBox(-5.0F, 0.0F, -2.5F, 1, 12, 5, 0.0F);
        
        BodyLeft = new ModelRenderer(this, 0, 92);
        BodyLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        BodyLeft.addBox(4.0F, 0.0F, -2.5F, 1, 12, 5, 0.0F);
        
        BodyFront = new ModelRenderer(this, 32, 79);
        BodyFront.setRotationPoint(0.0F, 0.0F, 0.0F);
        BodyFront.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 1, 0.0F);
        
        BodyBack = new ModelRenderer(this, 32, 79);
        BodyBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        BodyBack.addBox(-4.0F, -0.2F, 2.0F, 8, 13, 1, 0.0F);
        
        RightSleeve = new ModelRenderer(this, 10, 65);
        RightSleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightSleeve.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        RightPauldron = new ModelRenderer(this, 32, 69);
        RightPauldron.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightPauldron.addBox(-7.0F, -3.0F, -3.5F, 8, 3, 7, 0.0F);
        setRotateAngle(RightPauldron, 0.0F, 0.0F, 0.2519043105695434F);
        
        LeftSleeve = new ModelRenderer(this, 10, 65);
        LeftSleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftSleeve.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        LeftPauldron = new ModelRenderer(this, 32, 69);
        LeftPauldron.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftPauldron.addBox(-1.0F, -3.0F, -3.5F, 8, 3, 7, 0.0F);
        setRotateAngle(LeftPauldron, 0.0F, 0.0F, -0.2617993877991494F);
        
        RightLegGuard = new ModelRenderer(this, 24, 109);
        RightLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightLegGuard.addBox(-2.1F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        LeftLegGuard = new ModelRenderer(this, 24, 109);
        LeftLegGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        LeftLegGuard.addBox(-1.9F, -2.0F, -2.5F, 4, 14, 5, 0.0F);
        
        RightFoot = new ModelRenderer(this, 40, 98);
        RightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        RightFoot.addBox(-2.2F, 6.0F, -3.0F, 4, 6, 6, 0.0F);
        
        LeftFoot = new ModelRenderer(this, 40, 98);
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
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
