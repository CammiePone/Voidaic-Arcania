package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.blocks.blockaltar.ContainerAltar;
import com.camellias.voidaicarcania.blocks.blockaltar.GuiAltar;
import com.camellias.voidaicarcania.blocks.blockaltar.TileEntityAltar;
import com.camellias.voidaicarcania.blocks.blockbotanyaltar.ContainerBotanyAltar;
import com.camellias.voidaicarcania.blocks.blockbotanyaltar.GuiBotanyAltar;
import com.camellias.voidaicarcania.blocks.blockbotanyaltar.TileEntityBotanyAltar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == ConfigHandler.GUI_ALTAR)
		{
			return new ContainerAltar(player.inventory, (TileEntityAltar) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID == ConfigHandler.GUI_BOTANY_ALTAR)
		{
			return new ContainerBotanyAltar(player.inventory, (TileEntityBotanyAltar) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == ConfigHandler.GUI_ALTAR)
		{
			return new GuiAltar(player.inventory, (TileEntityAltar) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID == ConfigHandler.GUI_BOTANY_ALTAR)
		{
			return new GuiBotanyAltar(player.inventory, (TileEntityBotanyAltar) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}
}
