package com.camellias.voidaicarcania.core.mixin.plugin;

import java.util.Map;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import com.camellias.voidaicarcania.Reference;

import net.minecraftforge.fml.relauncher.IFMLCallHook;

public class VASetupHook implements IFMLCallHook
{
	@Override
	public void injectData(Map<String, Object> data)
	{
	}
	
	@Override
	public Void call()
	{
		MixinBootstrap.init();
		Mixins.addConfiguration("mixins." + Reference.MODID + ".json");
		
		return null;
	}
}