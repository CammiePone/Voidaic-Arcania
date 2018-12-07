package com.camellias.voidaicarcania.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelBossBlock extends ModelBase
{
	//fields
    ModelRenderer Shape1;
  
    public ModelBossBlock()
    {
    	textureWidth = 64;
    	textureHeight = 32;
    	
    	Shape1 = new ModelRenderer(this, 0, 0);
    	Shape1.addBox(-8F, -8F, -8F, 16, 16, 16);
    	Shape1.setRotationPoint(0F, 16F, 0F);
    	setRotation(Shape1, 0F, 0F, 0F);
    }
    
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    	
        Shape1.render(scale);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
}
