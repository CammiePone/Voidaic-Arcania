package com.camellias.voidaicarcania.common.commands;

import java.util.List;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.world.dimension.voidic.TeleporterVoid;
import com.google.common.collect.Lists;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandDimTeleport extends CommandBase
{
	private final List<String> aliases = 
			Lists.newArrayList(Reference.MODID, "tp", "tpdim", "tpdimension", "teleportdimension", "teleport");
	
	@Override
	public String getName() 
	{
		return "tpDimension";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "tpDimension <id>";
	}
	
	@Override
	public List<String> getAliases()
	{
		return aliases;
	}
	
	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if(args.length < 1) return;
		
		String s = args[0];
		int dimensionID;
		
		try
		{
			dimensionID = Integer.parseInt(s);
		}catch(NumberFormatException e)
		{
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Dimension ID Invalid"));
			return;
		}
		
		if(sender instanceof EntityPlayer)
		{
			TeleporterVoid.teleportToDimension((EntityPlayer)sender, dimensionID, 
					sender.getPosition().getX(), sender.getPosition().getY(), sender.getPosition().getZ());
		}
	}
}
