package com.camellias.voidaicarcania.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.camellias.voidaicarcania.core.handlers.SoundReverbHandler;

import paulscode.sound.Channel;
import paulscode.sound.SoundBuffer;
import paulscode.sound.Source;
import paulscode.sound.libraries.ChannelLWJGLOpenAL;
import paulscode.sound.libraries.SourceLWJGLOpenAL;

@Mixin(SourceLWJGLOpenAL.class)
public abstract class MixinVoidReverb extends Source
{
	@Shadow
	private ChannelLWJGLOpenAL channelOpenAL = (ChannelLWJGLOpenAL) channel;
	
	public MixinVoidReverb(Source old, SoundBuffer soundBuffer)
	{
		super(old, soundBuffer);
	}
	
	@Inject(method = "play", at = @At(value = "INVOKE", target = "checkPitch", ordinal = 0))
	public void reverb(Channel channel, CallbackInfo info)
	{
		SoundReverbHandler.onPlaySound(channelOpenAL.ALSource.get());
	}
}
