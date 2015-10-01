package com.kittenqty.kitcraft.init;

import com.kittenqty.kitcraft.food.FoodKC;
import com.kittenqty.kitcraft.food.ItemFoodCheese;
import com.kittenqty.kitcraft.item.ItemKC;
import com.kittenqty.kitcraft.item.ItemPot;
import com.kittenqty.kitcraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    //public static final ItemKC mapleLeaf = new ItemMapleLeaf();
    public static final FoodKC foodCheese = new ItemFoodCheese();
    public static final ItemKC itemPot = new ItemPot();

    public static void init()
    {
        // Food Items
        //GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
        GameRegistry.registerItem(foodCheese, "foodCheese");

        // Items
        GameRegistry.registerItem(itemPot, "itemPot");
    }

}
