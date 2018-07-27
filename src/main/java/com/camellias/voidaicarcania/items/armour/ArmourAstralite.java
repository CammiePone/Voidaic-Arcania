package com.camellias.voidaicarcania.items.armour;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ArmourAstralite extends ItemArmor implements IHasModel
{
	public ArmourAstralite(ArmorMaterial material, int index, EntityEquipmentSlot slot, String name)
	{
		super(material, index, slot);
		
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.metaltab);
		this.setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot slot, ModelBiped biped)
	{
		return null;
	}
	
	@SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) 
	{
		EntityEquipmentSlot head = EntityEquipmentSlot.HEAD;
		EntityEquipmentSlot body = EntityEquipmentSlot.CHEST;
		EntityEquipmentSlot legs = EntityEquipmentSlot.LEGS;
		EntityEquipmentSlot feet = EntityEquipmentSlot.FEET;
		
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			if(player.getItemStackFromSlot(head).getItem() == ModItems.ASTRALITE_HELM
					&& player.getItemStackFromSlot(body).getItem() == ModItems.ASTRALITE_CHEST
					&& player.getItemStackFromSlot(legs).getItem() == ModItems.ASTRALITE_LEGS
					&& player.getItemStackFromSlot(feet).getItem() == ModItems.ASTRALITE_BOOTS
					&& event.getSource() == DamageSource.FALL)
			{
				event.setAmount(event.getAmount() / 2.0F);
			}
		}
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
