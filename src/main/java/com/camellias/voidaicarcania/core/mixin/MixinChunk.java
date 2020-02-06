package com.camellias.voidaicarcania.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.chunk.Chunk;

@Mixin(Chunk.class)
public abstract class MixinChunk
{
	@Shadow
	private boolean dirty;
	
	@Inject(method = "generateSkylightMap", at = @At(value = "INVOKE", target = "getBlockLightOpacity", ordinal = 1), cancellable = true)
	public void genSkylights(CallbackInfo info)
	{
		Object obj = this;
		
		if(obj instanceof Chunk)
		{
			int y = ((Chunk) obj).getTopFilledSegment() + 16 - 1;
			
			if(y < 16)
			{
				this.dirty = true;
				info.cancel();
			}
		}
	}
}
