package com.kittenqty.kitcraft.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFoodCheese extends FoodKC {

    public ItemFoodCheese()
    {
        super(1, 0.2f, false);
        this.setUnlocalizedName("foodCheese");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPLayer)
    {
        return itemStack;
    }

}
