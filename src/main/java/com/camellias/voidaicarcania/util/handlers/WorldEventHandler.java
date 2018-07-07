package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.items.crystals.ItemStorageMid;
import com.camellias.voidaicarcania.items.crystals.ItemStorageStrong;
import com.camellias.voidaicarcania.items.crystals.ItemStorageWeak;
import com.camellias.voidaicarcania.world.dimension.voidic.TeleporterVoid;

import baubles.api.BaublesApi;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class WorldEventHandler
{
	@SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) 
	{
        if(event.getEntityLiving() instanceof EntityPlayerMP && event.getEntityLiving().dimension == 0 
        		&& event.getEntityLiving().getPosition().getY() <= -60) 
        {
            EntityPlayerMP player = (EntityPlayerMP) event.getEntityLiving();
            PlayerList playerList = player.getEntityWorld().getMinecraftServer().getPlayerList();
            
            event.setCanceled(true);
            
            if(player.posX > 0 && player.posZ > 0)
            {
            	playerList.transferPlayerToDimension(player, -64, 
            			new TeleporterVoid((WorldServer) player.getEntityWorld(), player.posX + 1000, 250, player.posZ + 1000));
            }
            
            if(player.posX < 0 && player.posZ < 0)
            {
            	playerList.transferPlayerToDimension(player, -64, 
            			new TeleporterVoid((WorldServer) player.getEntityWorld(), player.posX - 1000, 250, player.posZ - 1000));
            }
            
            if(player.posX < 0 && player.posZ > 0)
            {
            	playerList.transferPlayerToDimension(player, -64, 
            			new TeleporterVoid((WorldServer) player.getEntityWorld(), player.posX - 1000, 250, player.posZ + 1000));
            }
            
            if(player.posX > 0 && player.posZ < 0)
            {
            	playerList.transferPlayerToDimension(player, -64, 
            			new TeleporterVoid((WorldServer) player.getEntityWorld(), player.posX + 1000, 250, player.posZ - 1000));
            }
        }
        
        if(event.getEntityLiving() instanceof EntityPlayerMP && event.getEntityLiving().dimension == -64 
        		&& event.getEntityLiving().getPosition().getY() <= -60) 
        {
            EntityPlayerMP player = (EntityPlayerMP) event.getEntityLiving();
            PlayerList playerList = player.getEntityWorld().getMinecraftServer().getPlayerList();
            
            event.setCanceled(true);
            playerList.transferPlayerToDimension(player, -1, 
            		new TeleporterVoid((WorldServer) player.getEntityWorld(), player.getPosition().getX(), 250, player.getPosition().getZ()));
        }
        
        if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			if(BaublesApi.isBaubleEquipped(player, ModItems.A_SHIELD_AMULET) > -1)
			{
				ItemStack stack = BaublesApi.getBaublesHandler(player).getStackInSlot(0);
				
				if(ModItems.A_SHIELD_AMULET.getDamage(stack) < 5)
				{
					ModItems.A_SHIELD_AMULET.setDamage(stack, ModItems.A_SHIELD_AMULET.getDamage(stack) + 1);
					
					event.setCanceled(true);
				}
				
				if(ModItems.A_SHIELD_AMULET.getDamage(stack) == 5)
				{
					
				}
			}
		}
    }
	
	private static ItemStack findCrystals(EntityPlayer player)
    {
        if (isCrystal(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (isCrystal(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if(itemstack.getItemDamage() < itemstack.getMaxDamage())
                {
                	if(isCrystal(itemstack))
                	{
                		return itemstack;
                	}
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected static boolean isCrystal(ItemStack stack)
    {
        return stack.getItem() instanceof ItemStorageWeak || stack.getItem() instanceof ItemStorageMid || stack.getItem() instanceof ItemStorageStrong;
    }
	
	@SubscribeEvent
	public static void onPlayerAttack(AttackEntityEvent event)
	{
		EntityPlayer player = event.getEntityPlayer();
		ItemStack stack = findCrystals(player);
		
		if(player.inventory.hasItemStack(stack) && stack.getItemDamage() <= stack.getMaxDamage() - 50)
		{
			if(BaublesApi.isBaubleEquipped(player, ModItems.A_REAPER_COWL) > -1)
			{
				player.heal(1.0F);
				stack.setItemDamage(stack.getItemDamage() + 50);
			}
		
			if(BaublesApi.isBaubleEquipped(player, ModItems.A_VOID_CHARM) > -1)
			{
				if(!player.world.isRemote)
				{
					player.world.createExplosion(player, player.posX, player.posY, player.posZ, 3.0F, true);
					stack.setItemDamage(stack.getItemDamage() + 50);
				}
			}
		
			if(BaublesApi.isBaubleEquipped(player, ModItems.A_LUCK_CHARM) > -1)
			{
				if(event.getTarget() instanceof EntityLiving)
				{
					EntityLiving target = (EntityLiving) event.getTarget();
					
					if(player.getHeldItemMainhand().isEmpty() && !player.world.isRemote)
					{
						ItemStack head = target.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
						ItemStack body = target.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
						ItemStack legs = target.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
						ItemStack feet = target.getItemStackFromSlot(EntityEquipmentSlot.FEET);
						
						target.entityDropItem(head, 1);
						target.entityDropItem(body, 1);
						target.entityDropItem(legs, 1);
						target.entityDropItem(feet, 1);
						
						target.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.AIR));
						target.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.AIR));
						target.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.AIR));
						target.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.AIR));
						
						stack.setItemDamage(stack.getItemDamage() + 50);
					}
				}
			
				if(event.getTarget() instanceof EntityPlayer)
				{
					EntityPlayer target = (EntityPlayer) event.getTarget();
					
					if(player.getHeldItemMainhand().isEmpty() && !player.world.isRemote)
					{
						ItemStack head = target.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
						ItemStack body = target.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
						ItemStack legs = target.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
						ItemStack feet = target.getItemStackFromSlot(EntityEquipmentSlot.FEET);
						
						target.entityDropItem(head, 1);
						target.entityDropItem(body, 1);
						target.entityDropItem(legs, 1);
						target.entityDropItem(feet, 1);
						
						target.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.AIR));
						target.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.AIR));
						target.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.AIR));
						target.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.AIR));
						
						stack.setItemDamage(stack.getItemDamage() + 50);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void onAdvancementGet(AdvancementEvent event)
	{
		if(!event.getEntityPlayer().world.isRemote)
		{
			EntityPlayerMP player = (EntityPlayerMP) event.getEntityPlayer();
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
			
			if(player != null)
			{
				if(event.getAdvancement() == player.getServer().getAdvancementManager().getAdvancement(new ResourceLocation
						("minecraft", "nether/root")))
				{
					server.getCommandManager().executeCommand(server, "/give " + player.getName() + 
							" written_book 1 0 {title:\"Of Creation - Vol. III\", author:\"Artemis\", pages:["
							+ " \"{text:\\\"To whom it may concern,                       I've sent you this book to aide you on a quest of mine. After you've grown, I will send you information as to my whereabouts. This quest is fully voluntary, and, if you wish, you may ignore my bidding. But, if you would like power... then please, read on.\\\"}\","
							+ " \"{text:\\\"3rd New Moon, 1052 -     I've come across a peculiar item... it hails from an unknown origin, and houses odd properties. Transformative properties... I feel further testing will be necessary. The anomoly, at least from my testing, seems to be created by pressing\\\"}\","
							+ " \"{text:\\\"Glowstone Dust on four sides with pure diamonds, until the diamonds shatter, combining with the Hell-ish lightsource.\\\"}\","
							+ " \"{text:\\\"5th Waxing Crescent, 1052 -                       I've made an amazing discovery! These shards... when 8 or so are surrounding a cluster of pure diamonds, they create some kind of catalyst! I can feel the energy emenating from it... it's powerful... And that excites me greatly.\\\"}\","
							+ " \"{text:\\\"...                                                The rest is missing...\\\"}\"]}");
				}
				
				if(event.getAdvancement() == player.getServer().getAdvancementManager().getAdvancement(new ResourceLocation
						("voidaicarcania", "transmutation_orb")))
				{
					server.getCommandManager().executeCommand(server, "/give " + player.getName() + 
							" written_book 1 0 {title:\"Missing Notes 1\", author:\"Artemis\", pages:["
							+ " \"{text:\\\"12th Waning Crescent, 1052 -                       It's strange... how this orb pulses, every day, drawing my attention away from my other work. As if it's beckoning me to use it. I feel that I should look into its limitations more. By the close of the year, I will know its secrets...\\\"}\","
							+ " \"{text:\\\"1st New Moon, 1055 -     Strange, how it is, I've spent this past year trying to understand this orb... and now, I have. In an altar made of quartz, I can use it to replicate items, though it seems limited in what it can make. No matter, I'm sure I can surpass it with more tests.\\\"}\"]}");
				}
				
				if(event.getAdvancement() == player.getServer().getAdvancementManager().getAdvancement(new ResourceLocation
						("voidaicarcania", "altar")))
				{
					server.getCommandManager().executeCommand(server, "/give " + player.getName() + 
							" written_book 1 0 {title:\"Missing Notes 2\", author:\"Artemis\", pages:["
							+ " \"{text:\\\"4th Quarter Moon, 1055 -                        Amazing! I can use the altar without the orb! I found that I can combine an ender pearl and breath of a dragon in the altar to create a highly volitile... gasious liquid! It seems pouring it on something breaks it down\\\"}\","
							+ " \"{text:\\\"to the molecular level, even bedrock! Tonight, I will descend below the bedrock, see what I can find. I'll make sure to bring the ingredients for a portal in case I get stuck. I should probably take my wings, as well. Who knows if there's even anything down there?\\\"}\"]}");
				}
				
				if(event.getAdvancement() == player.getServer().getAdvancementManager().getAdvancement(new ResourceLocation
						("voidaicarcania", "void_shard")))
				{
					server.getCommandManager().executeCommand(server, "/give " + player.getName() + 
							" written_book 1 0 {title:\"Missing Notes 3\", author:\"Artemis\", pages:["
							+ " \"{text:\\\"5th Quarter Moon,  1055 -                        While I was in the void, I found these strange shards... they remind me of the blue ones I created around two years ago... I wonder how these behave?\\\"}\","
							+ " \"{text:\\\"5th Waning Crescent,  1055 -                       These are brilliant! I can create that volitile concoction out of these far easier, so I can return to the void later on! I'll have to make sure I'm better prepared next time. I'll prepare for a longer visit this time.\\\"}\","
							+ " \"{text:\\\"3rd New Moon, 1056 -     Interesting... I can combine 8 of these new crystals with my orb... they seem to... take over, or empower it, perhaps? I'll have to do some more testing with this. Maybe this is my breakthrough I've been looking for?\\\"}\"]}");
				}
				
				if(event.getAdvancement() == player.getServer().getAdvancementManager().getAdvancement(new ResourceLocation
						("voidaicarcania", "void_orb")))
				{
					server.getCommandManager().executeCommand(server, "/give " + player.getName() + 
							" written_book 1 0 {title:\"Missing Notes 4\", author:\"Artemis\", pages:["
							+ " \"{text:\\\"3rd New Moon, 1056 -     This orb... with its origins of the void, I think it more efficiently uses essence from other items to create new ones. I tested it, and I can create diamonds - DIAMONDS! It's amazing! I wonder what the limits of this new orb are...\\\"}\","
							+ " \"{text:\\\"3rd Quarter Moon, 1056 -                        Disappointingly, it seems that I cannot make much more than I could before... it's not too surprising, if I'm honest, but I'm glad I discovered this new orb. Perhaps one day, I'll find more uses for it.\\\"}\"]}");
				}
				
				if(event.getAdvancement() == player.getServer().getAdvancementManager().getAdvancement(new ResourceLocation
						("voidaicarcania", "enter_void")))
				{
					server.getCommandManager().executeCommand(server, "/give " + player.getName() + 
							" written_book 1 0 {title:\"Missing Notes 5\", author:\"Artemis\", pages:["
							+ " \"{text:\\\"4th Quarter Moon, 1055 -                        This confounded place... I had thought it would be easier than this. I cannot fly back out the way I came, nor can I create a portal. It seems that its forcing me to stay, or... go further down? I'll have to try, but first, research!\\\"}\","
							+ " \"{text:\\\"4th Waning Crescent,  1055 -                       These... wraiths. They're immensly powerful. One-on-one, they aren't too bad, but... the moment they group together... I don't think anyone could hope to beat them. They phase through everything, disappear, reappear... This place...\\\"}\","
							+ " \"{text:\\\"5th New Moon, 1055 -     Today I go further down... this may be a mistake, but... hopefully I'm wrong.\\\"}\","
							+ " \"{text:\\\"5th New Moon, 1055 -     It's... strange. I'm back in... the nether? It's hot, and I have that same sense of dread, but... I'm on bedrock? Is... is the void an intermediary between our world and this? Is... is this the top of the nether? At least I can make my portal home, now...\\\"}\"]}");
				}
				
				if(event.getAdvancement() == player.getServer().getAdvancementManager().getAdvancement(new ResourceLocation
						("voidaicarcania", "botany_altar")))
				{
					server.getCommandManager().executeCommand(server, "/give " + player.getName() + 
							" written_book 1 0 {title:\"Missing Notes 6\", author:\"Artemis\", pages:["
							+ " \"{text:\\\"5th Waxing Crescent, 1055 -                       In my time visiting the void, I came across two plants which I've never seen before... a weed, and a bloom. I did some extensive testing with them, and found that, in the presence of Wraith Wisp, I can alter them. I've recorded the\\\"}\","
							+ " \"{text:\\\"recipes that I've discovered so far, on the following pages. They're all quite... interesting, and perhaps have more uses unbeknowst to me.\\\"}\","
							+ " \"{text:\\\"Featherweed - Feather and Void Weed                     This weed is quite interesting. It's extremely light weight, and seems to have some uses in later herbology.\\\"}\","
							+ " \"{text:\\\"Floatshroom - Mushroom and Shulker Bullet                    An interesting mushroom. I fed a tiny amount to a rabbit, and, surprisingly, it survived. It ended up... floating for a short while.\\\"}\","
							+ " \"{text:\\\"Glowgrowth - Netherwart and Glowstone Dust        Glowgrowth is an interesting plant. Feeding it to the same rabbit, it began to emit a bright light. Maybe I can find some uses for this...\\\"}\","
							+ " \"{text:\\\"Void Melon Seed - Melon Seeds and Void Bulb                      I decided to try mixing our melons with the void's bulbous fruit. Interestingly, it worked, and made a small melon with properties unknown.\\\"}\","
							+ " \"{text:\\\"Moon Mint - Void Crystal and Dark Camellia               This leaf, interestingly, seems to help with increasing vision, if only temporarily. I find it quite useful when trying to find small things.\\\"}\","
							+ " \"{text:\\\"Neddlesprout - Stick and Cactus Green Dye I wouldn't recommend eating this one. It's spiny to the touch, but the spines are so small, I can't find them to remove them.\\\"}\","
							+ " \"{text:\\\"Starbloom - Blaze Powder and Wraith Wisp                       I dub this the miracle plant! It's, by far, the best possible herb one could eat! I must make more of these. Shame they're so difficult to produce...\\\"}\"]}");
				}
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onPlayerRender(RenderPlayerEvent.Pre event)
	{
		EntityPlayer player = event.getEntityPlayer();
		World world = event.getEntity().world;
		
		if(world.isRemote)
		{
			if(BaublesApi.isBaubleEquipped(player, ModItems.A_INVISIBILITY_CLOAK) > -1)
			{
				event.setCanceled(true);
			}
		}
	}
}
