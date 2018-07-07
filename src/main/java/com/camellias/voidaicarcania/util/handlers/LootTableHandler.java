package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler 
{
	public static final ResourceLocation WRAITH = LootTableList.register(new ResourceLocation(Reference.MODID, "void_wraith"));
	public static final ResourceLocation HEART = LootTableList.register(new ResourceLocation(Reference.MODID, "void_heart"));
}
