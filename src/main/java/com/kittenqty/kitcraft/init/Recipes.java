package com.kittenqty.kitcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{

    public static void init()
    {
        // Vanilla Recipes
        //GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block), " s ", "sss", " s ", 's', new ItemStack(Items.stick));
        //GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gold_block), new ItemStack(Items.stick), new ItemStack(Items.blaze_rod));

        // Blocks
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCStone), "sss", "sss", "sss", 's', new ItemStack(Blocks.stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockDStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.blockCStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockTStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.blockDStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockQuadStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.blockTStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockQuinStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.blockQuadStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSeStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.blockQuinStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSepStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.blockSeStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockOStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.blockSepStone));

        // Items
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemPot), "   ", "s s", " t ", 's', "ingotIron", 't', new ItemStack(Blocks.heavy_weighted_pressure_plate)));

        // Ore Dictionary Recipes
        //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.diamond_block), " s ", "sss", " s ", 's', "stickWood"));
        //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.gold_block), "stickWood", new ItemStack(Items.blaze_rod)));

        // Food Recipes
        //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.foodCheese), "listAllmilk", new ItemStack(ModItems.itemPot)));
    }

}
