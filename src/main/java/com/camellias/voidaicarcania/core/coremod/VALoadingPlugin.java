package com.camellias.voidaicarcania.core.coremod;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

/**
 * @author Gegy
 * All code below belongs to CrypticMushroom under the GNU General Public License 3.0.
 * https://github.com/Cryptic-Mushroom
 */
public class VALoadingPlugin implements IFMLLoadingPlugin
{
	@Override
	public String[] getASMTransformerClass()
	{
		return new String[] { "com.camellias.voidaicarcania.core.coremod.transformer.VAClassTransformer" };
	}
	
	@Override
	public String getModContainerClass()
	{
		return null;
	}
	
	@Nullable
	@Override
	public String getSetupClass()
	{
		return null;
	}
	
	@Override
	public void injectData(Map<String, Object> data)
	{
	}
	
	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
}
