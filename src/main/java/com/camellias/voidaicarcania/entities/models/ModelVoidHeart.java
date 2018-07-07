package com.camellias.voidaicarcania.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVoidHeart extends ModelBase 
{
    public ModelRenderer Heart1;
    public ModelRenderer Heart2;
    public ModelRenderer Heart3;
    public ModelRenderer Vessel1;
    public ModelRenderer Vessel2;
    public ModelRenderer Vessel3;
    
    public ModelVoidHeart() 
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        
        this.Heart1 = new ModelRenderer(this, 68, 0);
        this.Heart1.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.Heart1.addBox(-3.0F, 0.0F, -3.0F, 3, 8, 6, 0.0F);
        
        this.Heart2 = new ModelRenderer(this, 48, 0);
        this.Heart2.setRotationPoint(-2.0F, 9.0F, 0.0F);
        this.Heart2.addBox(0.0F, 0.0F, -2.0F, 5, 8, 5, 0.0F);
        
        this.Heart3 = new ModelRenderer(this, 86, 0);
        this.Heart3.setRotationPoint(-3.0F, 11.0F, 0.0F);
        this.Heart3.addBox(-1.0F, 0.0F, -2.0F, 1, 6, 4, 0.0F);
        
        this.Vessel1 = new ModelRenderer(this, 48, 16);
        this.Vessel1.setRotationPoint(2.0F, 7.0F, 1.0F);
        this.Vessel1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        
        this.Vessel2 = new ModelRenderer(this, 48, 16);
        this.Vessel2.setRotationPoint(1.0F, 7.0F, -1.0F);
        this.Vessel2.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        
        this.Vessel3 = new ModelRenderer(this, 48, 16);
        this.Vessel3.setRotationPoint(-1.0F, 7.0F, 1.0F);
        this.Vessel3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
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
}
