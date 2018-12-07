package com.camellias.voidaicarcania.client.models;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelResistanceBelt extends ModelBase
{
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/models/model_resistance_belt.png");
    
	ModelRenderer Belt;
    ModelRenderer Buckle;
  
    public ModelResistanceBelt()
    {
    	textureWidth = 32;
    	textureHeight = 32;
    
    	Belt = new ModelRenderer(this, 0, 0);
    	Belt.addBox(-4.5F, 0F, -2.5F, 9, 2, 5);
    	Belt.setRotationPoint(0F, 9F, 0F);
    	setRotation(Belt, 0F, 0F, 0F);
    	
    	Buckle = new ModelRenderer(this, 0, 7);
    	Buckle.addBox(-1.5F, -1F, 0F, 3, 2, 1);
    	Buckle.setRotationPoint(0F, 10F, -3F);
	    setRotation(Buckle, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
    	
    	Belt.render(f5);
    	Buckle.render(f5);
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
}
