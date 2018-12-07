package com.camellias.voidaicarcania.client.models;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelInverseAmulet extends ModelBase
{
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/models/model_inverse_amulet.png");
	
    ModelRenderer AmuletCenter;
    ModelRenderer AmuletTop;
    ModelRenderer AmuletBottom;
    ModelRenderer AmuletLeft;
    ModelRenderer AmuletRight;
    
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    
    public ModelInverseAmulet()
    {
    	textureWidth = 32;
    	textureHeight = 32;
    	
    	AmuletCenter = new ModelRenderer(this, 8, 0);
    	AmuletCenter.addBox(-1F, -1F, 0F, 2, 2, 1);
    	AmuletCenter.setRotationPoint(0F, 5F, -3F);
    	setRotation(AmuletCenter, 0F, 0F, 0F);
    	
    	AmuletTop = new ModelRenderer(this, 0, 3);
    	AmuletTop.addBox(-1F, 0F, 0F, 2, 1, 1);
    	AmuletTop.setRotationPoint(0F, 3F, -3F);
    	setRotation(AmuletTop, 0F, 0F, 0F);
    	
    	AmuletBottom = new ModelRenderer(this, 0, 3);
    	AmuletBottom.addBox(-1F, 0F, 0F, 2, 1, 1);
    	AmuletBottom.setRotationPoint(0F, 6F, -3F);
    	setRotation(AmuletBottom, 0F, 0F, 0F);
    	
    	AmuletLeft = new ModelRenderer(this, 4, 0);
    	AmuletLeft.addBox(0F, -1F, 0F, 1, 2, 1);
    	AmuletLeft.setRotationPoint(1F, 5F, -3F);
    	setRotation(AmuletLeft, 0F, 0F, 0F);
    	
    	AmuletRight = new ModelRenderer(this, 4, 0);
    	AmuletRight.addBox(0F, -1F, 0F, 1, 2, 1);
    	AmuletRight.setRotationPoint(-2F, 5F, -3F);
    	setRotation(AmuletRight, 0F, 0F, 0F);
    	
    	Shape1 = new ModelRenderer(this, 0, 0);
    	Shape1.addBox(0F, 0F, -0.5F, 1, 1, 1);
    	Shape1.setRotationPoint(1F, 2F, -2F);
    	setRotation(Shape1, 0F, 0F, 0F);
    	
    	Shape2 = new ModelRenderer(this, 0, 0);
    	Shape2.addBox(0F, 0F, -0.5F, 1, 1, 1);
    	Shape2.setRotationPoint(2F, 1F, -2F);
 	    setRotation(Shape2, 0F, 0F, 0F);
 	    
 	    Shape3 = new ModelRenderer(this, 0, 0);
	    Shape3.addBox(0F, 0F, -0.5F, 1, 1, 1);
	    Shape3.setRotationPoint(3F, 0F, -2F);
	    setRotation(Shape3, 0F, 0F, 0F);
	    
	    Shape4 = new ModelRenderer(this, 0, 0);
	    Shape4.addBox(0F, 0F, -0.5F, 1, 1, 1);
	    Shape4.setRotationPoint(-2F, 2F, -2F);
	    setRotation(Shape4, 0F, 0F, 0F);
	    
	    Shape5 = new ModelRenderer(this, 0, 0);
	    Shape5.addBox(0F, 0F, -0.5F, 1, 1, 1);
	    Shape5.setRotationPoint(-3F, 1F, -2F);
	    setRotation(Shape5, 0F, 0F, 0F);
	    
	    Shape6 = new ModelRenderer(this, 0, 0);
	    Shape6.addBox(0F, 0F, -0.5F, 1, 1, 1);
	    Shape6.setRotationPoint(-4F, 0F, -2F);
	    setRotation(Shape6, 0F, 0F, 0F);
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
    	
    	AmuletCenter.render(f5);
    	AmuletTop.render(f5);
    	AmuletBottom.render(f5);
    	AmuletLeft.render(f5);
    	AmuletRight.render(f5);
    	
    	Shape1.render(f5);
    	Shape2.render(f5);
    	Shape3.render(f5);
    	Shape4.render(f5);
    	Shape5.render(f5);
    	Shape6.render(f5);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
}
