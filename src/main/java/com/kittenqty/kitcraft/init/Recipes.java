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
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockCStone), "sss", "sss", "sss", 's', new ItemStack(Blocks.stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockDStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.BlockCStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockTStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.BlockDStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockQuadStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.BlockTStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockQuinStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.BlockQuadStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockSeStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.BlockQuinStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockSepStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.BlockSeStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockOStone), "sss", "sss", "sss", 's', new ItemStack(ModBlocks.BlockSepStone));

        // Items
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemPot), "   ", "s s", " t ", 's', "ingotIron", 't', new ItemStack(Blocks.heavy_weighted_pressure_plate)));

        // Ore Dictionary Recipes
        //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.diamond_block), " s ", "sss", " s ", 's', "stickWood"));
        //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.gold_block), "stickWood", new ItemStack(Items.blaze_rod)));

        // Food Recipes
        //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.foodCheese), "listAllmilk", new ItemStack(ModItems.itemPot)));
    }

}
