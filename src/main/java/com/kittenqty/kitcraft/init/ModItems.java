package com.kittenqty.kitcraft.init;

import com.kittenqty.kitcraft.food.FoodKC;
import com.kittenqty.kitcraft.item.ItemFoodCheese;
import com.kittenqty.kitcraft.item.ItemKC;
import com.kittenqty.kitcraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    //public static final ItemKC mapleLeaf = new ItemMapleLeaf();
    public static final FoodKC foodCheese = new ItemFoodCheese();

    public static void init()
    {
        //GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
        GameRegistry.registerItem(foodCheese, "foodCheese");
    }

}
