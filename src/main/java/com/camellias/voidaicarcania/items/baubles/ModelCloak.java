package com.camellias.voidaicarcania.items.baubles;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelCloak extends ModelBase
{
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/models/model_cloak.png");
	
    ModelRenderer CloakBack;
    
    ModelRenderer CloakSideLeft;
    ModelRenderer CloakShoulderLeft;
    
    ModelRenderer CloakSideRight;
    ModelRenderer CloakShoulderRight;
    
    ModelRenderer Latch;
  
    public ModelCloak()
    {
    	textureWidth = 64;
    	textureHeight = 32;
	  
    	CloakBack = new ModelRenderer(this, 0, 0);
    	CloakBack.addBox(-8F, 0F, 0F, 16, 16, 1);
    	CloakBack.setRotationPoint(0F, 0F, 2F);
    	setRotation(CloakBack, 0F, 0F, 0F);
    	
    	CloakSideLeft = new ModelRenderer(this, 34, 0);
    	CloakSideLeft.addBox(0F, 0F, -2F, 1, 14, 4);
    	CloakSideLeft.setRotationPoint(7.5F, 0F, 0F);
    	setRotation(CloakSideLeft, 0F, 0F, 0F);
      
    	CloakShoulderLeft = new ModelRenderer(this, 0, 17);
    	CloakShoulderLeft.addBox(-2F, 0F, -2.5F, 4, 1, 5);
    	CloakShoulderLeft.setRotationPoint(6F, -0.5F, 0F);
    	setRotation(CloakShoulderLeft, 0F, 0F, 0F);
    	
    	CloakSideRight = new ModelRenderer(this, 34, 0);
    	CloakSideRight.addBox(-1F, 0F, -2F, 1, 14, 4);
    	CloakSideRight.setRotationPoint(-7.5F, 0F, 0F);
    	setRotation(CloakSideRight, 0F, 0F, 0F);
    	
    	CloakShoulderRight = new ModelRenderer(this, 0, 17);
    	CloakShoulderRight.addBox(-2F, 0F, -2.5F, 4, 1, 5);
    	CloakShoulderRight.setRotationPoint(-6F, -0.5F, 0F);
    	setRotation(CloakShoulderRight, 0F, 0F, 0F);
      
    	Latch = new ModelRenderer(this, 0, 29);
    	Latch.addBox(-8.5F, 0F, -1F, 17, 2, 1);
    	Latch.setRotationPoint(0F, 0F, -1.5F);
    	setRotation(Latch, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
    	
    	CloakBack.render(f5);
    	CloakSideLeft.render(f5);
    	CloakShoulderLeft.render(f5);
    	CloakSideRight.render(f5);
    	CloakShoulderRight.render(f5);
    	Latch.render(f5);
  	}
  
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
}
