package com.camellias.voidaicarcania.potions;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionVoidTouch extends Potion
{
public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, ":textures/potions/voidtouch.png");
	
	public PotionVoidTouch(String name)
	{
		super(true, 3276850);
		this.setPotionName("effect." + name);
		this.setRegistryName(new ResourceLocation(Reference.MODID + ":" + name));
	}
	
	@Override
	public boolean hasStatusIcon()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
		return true;
	}
}
