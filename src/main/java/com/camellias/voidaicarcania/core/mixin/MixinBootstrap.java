package com.camellias.voidaicarcania.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.camellias.voidaicarcania.api.registry.Registry;

import net.minecraft.init.Bootstrap;

@Mixin(Bootstrap.class)
public class MixinBootstrap
{
	@Inject(method = "register", at = @At(value = "INVOKE", target = "registerDispenserBehaviors", ordinal = 0))
	private static void register(CallbackInfo info)
	{
		Registry.registerFocusTypes();
		Registry.registerSpellTypes();
		Registry.registerModifierTypes();
	}
}
