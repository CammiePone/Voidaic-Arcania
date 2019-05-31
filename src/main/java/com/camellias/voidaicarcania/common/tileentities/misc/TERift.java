package com.camellias.voidaicarcania.common.tileentities.misc;

import com.camellias.voidaicarcania.common.tileentities.TEGeneric;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TERift extends TEGeneric
{
	@SideOnly(Side.CLIENT)
    public boolean shouldRenderFace(EnumFacing face)
    {
        return this.getBlockType().getDefaultState().shouldSideBeRendered(this.world, this.getPos(), face);
    }
}
