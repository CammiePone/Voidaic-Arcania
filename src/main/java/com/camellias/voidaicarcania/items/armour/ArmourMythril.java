package com.camellias.voidaicarcania.items.armour;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.items.armour.models.ModelMythrilArmour;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmourMythril extends ItemArmor implements IHasModel
{
	public ArmourMythril(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot, String name)
	{
		super(material, renderIndex, equipmentSlot);
		
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.metaltab);
		this.setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@SideOnly(Side.CLIENT)
    public ModelBiped model;
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot slot, ModelBiped biped)
	{
		if(model == null)
		{
            if(armorType == slot.HEAD)
            {
            	model = new ModelMythrilArmour(1F, true, false, false, false);
            }
            
            else if(armorType == slot.CHEST)
            {
            	model = new ModelMythrilArmour(1F, false, true, false, false);
            }
            
            else if(armorType == slot.LEGS)
            {
            	model = new ModelMythrilArmour(1F, false, false, true, false);
            }
            
            else if(armorType == slot.FEET)
            {
            	model = new ModelMythrilArmour(1F, false, false, false, true);
            }
            
            model.bipedHead.showModel = (armorType == slot.HEAD);
            model.bipedHeadwear.showModel = (armorType == slot.HEAD);
            
            model.bipedBody.showModel = (armorType == slot.CHEST);
            model.bipedLeftArm.showModel = (armorType == slot.CHEST);
            model.bipedRightArm.showModel = (armorType == slot.CHEST);
            
            model.bipedLeftLeg.showModel = (armorType == slot.LEGS || armorType == slot.FEET);
            model.bipedRightLeg.showModel = (armorType == slot.LEGS || armorType == slot.FEET);
        }
        
        return model;
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
