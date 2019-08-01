package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.common.blocks.machines.blockaltar.ContainerAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockaltar.GuiAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockaltar.TileEntityAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockbotanyaltar.ContainerBotanyAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockbotanyaltar.GuiBotanyAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockbotanyaltar.TileEntityBotanyAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockmortalcentrifuge.ContainerMortalCentrifuge;
import com.camellias.voidaicarcania.common.blocks.machines.blockmortalcentrifuge.GuiMortalCentrifuge;
import com.camellias.voidaicarcania.common.blocks.machines.blockmortalcentrifuge.TileEntityMortalCentrifuge;

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
		
		if(ID == ConfigHandler.GUI_MORTAL_FURNACE)
		{
			return new ContainerMortalCentrifuge(player.inventory, (TileEntityMortalCentrifuge) world.getTileEntity(new BlockPos(x, y, z)));
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
		
		if(ID == ConfigHandler.GUI_MORTAL_FURNACE)
		{
			return new GuiMortalCentrifuge(player.inventory, (TileEntityMortalCentrifuge) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}
}