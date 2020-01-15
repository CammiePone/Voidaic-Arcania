package com.camellias.voidaicarcania.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.data.AnimationMetadataSection;

@Mixin(TextureAtlasSprite.class)
public interface IAccessorAnimationMetadata
{
	@Accessor("animationMetadata")
	public AnimationMetadataSection getMetadata();
}
