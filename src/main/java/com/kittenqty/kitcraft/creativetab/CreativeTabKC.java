package com.kittenqty.kitcraft.creativetab;

import com.kittenqty.kitcraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabKC
{

    public static final CreativeTabs KC_TAB_ITEMS = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "_items")
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.stick;
        }
    };

    public static final CreativeTabs KC_TAB_BLOCKS = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "_blocks")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(Blocks.stone);
        }
    };

    public static final CreativeTabs KC_TAB_ARMOR = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "_armor")
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.diamond_chestplate;
        }
    };

}
