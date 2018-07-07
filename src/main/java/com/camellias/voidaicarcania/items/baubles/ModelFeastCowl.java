package com.camellias.voidaicarcania.items.baubles;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelFeastCowl extends ModelBase
{
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/models/model_feast_cowl.png");
	
    ModelRenderer CowlRightSide;
    ModelRenderer CowlLeftSide;
    
    ModelRenderer CowlTop;
    ModelRenderer CowlBack;
    
    public ModelFeastCowl()
    {
    	textureWidth = 64;
    	textureHeight = 32;
    	
    	CowlRightSide = new ModelRenderer(this, 0, 14);
    	CowlRightSide.addBox(-5F, -8F, -4.5F, 1, 9, 9);
    	CowlRightSide.setRotationPoint(0F, 0F, 0F);
    	setRotation(CowlRightSide, 0F, 0F, 0F);
    	
    	CowlLeftSide = new ModelRenderer(this, 0, 14);
    	CowlLeftSide.addBox(4F, -8F, -4.5F, 1, 9, 9);
    	CowlLeftSide.setRotationPoint(0F, 0F, 0F);
    	setRotation(CowlLeftSide, 0F, 0F, 0F);
    	
    	CowlTop = new ModelRenderer(this, 0, 0);
    	CowlTop.addBox(-4.5F, -8.5F, -4.5F, 9, 1, 9);
    	CowlTop.setRotationPoint(0F, 0F, 0F);
    	setRotation(CowlTop, 0F, 0F, 0F);
    	
    	CowlBack = new ModelRenderer(this, 36, 0);
    	CowlBack.addBox(-4F, -8F, 4F, 8, 9, 1);
    	CowlBack.setRotationPoint(0F, 0F, 0F);
    	setRotation(CowlBack, 0F, 0F, 0F);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
    	
    	CowlRightSide.render(f5);
    	CowlLeftSide.render(f5);
    	CowlTop.render(f5);
    	CowlBack.render(f5);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
}
