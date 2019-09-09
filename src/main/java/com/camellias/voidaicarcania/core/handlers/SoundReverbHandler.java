package com.camellias.voidaicarcania.core.handlers;

import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.EFX10;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.common.world.dimensions.DimensionVoid;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

/**
 * @author Gegy
 * All code below belongs to CrypticMushroom under the GNU General Public License 3.0.
 * https://github.com/Cryptic-Mushroom
 */
public class SoundReverbHandler
{
	private static final Minecraft MC = Minecraft.getMinecraft();
	
	private static boolean available;
	private static boolean setup;
	
	private static int auxEffectSlot;
	private static int reverbEffectSlot;
	
	private static boolean reverbApplied;
	
	public static void onPlaySound(int soundId)
	{
		if(!setup)
		{
			setupEffects();
			setup = true;
		}
		
		if(available)
		{
			applyEffect(soundId);
		}
	}
	
	private static void setupEffects()
	{
		available = ALC10.alcIsExtensionPresent(AL.getDevice(), EFX10.ALC_EXT_EFX_NAME);
		
		if(!available)
		{
			Main.LOGGER.warn("Unable to setup reverb effects, AL EFX not supported!");
			return;
		}
		
		auxEffectSlot = EFX10.alGenAuxiliaryEffectSlots();
		EFX10.alAuxiliaryEffectSloti(auxEffectSlot, EFX10.AL_EFFECTSLOT_AUXILIARY_SEND_AUTO, AL10.AL_TRUE);
		
		reverbEffectSlot = EFX10.alGenEffects();
	}
	
	private static void applyEffect(int soundId)
	{
		if(shouldEcho(MC.world))
		{
			applyReverbEffect();
		}
		else
		{
			applyDefaultEffect();
		}
		
		AL11.alSource3i(soundId, EFX10.AL_AUXILIARY_SEND_FILTER, auxEffectSlot, 0, EFX10.AL_FILTER_NULL);
	}
	
	private static void applyReverbEffect()
	{
		if(reverbApplied)
		{
			return;
		}
		
		reverbApplied = true;
		
		EFX10.alEffecti(reverbEffectSlot, EFX10.AL_EFFECT_TYPE, EFX10.AL_EFFECT_EAXREVERB);
		EFX10.alEffectf(reverbEffectSlot, EFX10.AL_EAXREVERB_ECHO_DEPTH, 20F);
		EFX10.alEffectf(reverbEffectSlot, EFX10.AL_EAXREVERB_DECAY_TIME, 20F);
		
		EFX10.alAuxiliaryEffectSloti(auxEffectSlot, EFX10.AL_EFFECTSLOT_EFFECT, reverbEffectSlot);
	}
	
	private static void applyDefaultEffect()
	{
		if(!reverbApplied)
		{
			return;
		}
		
		reverbApplied = false;
		
		EFX10.alEffecti(reverbEffectSlot, EFX10.AL_EFFECT_TYPE, EFX10.AL_EFFECT_NULL);
		EFX10.alAuxiliaryEffectSloti(auxEffectSlot, EFX10.AL_EFFECTSLOT_EFFECT, reverbEffectSlot);
	}
	
	public static boolean shouldEcho(World world)
	{
		return world != null && world.provider.getDimension() == -64;
	}
}