package com.camellias.voidaicarcania.common.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityRift extends TileEntity
{
	@SideOnly(Side.CLIENT)
    public boolean shouldRenderFace(EnumFacing face)
    {
        return this.getBlockType().getDefaultState().shouldSideBeRendered(this.world, this.getPos(), face);
    }
}
