package com.kittenqty.kitcraft.init;

import com.kittenqty.kitcraft.block.*;
import com.kittenqty.kitcraft.creativetab.CreativeTabKC;
import com.kittenqty.kitcraft.reference.Reference;
import com.kittenqty.kitcraft.tileentity.TileEntityBlockGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

//@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{

    public static final BlockKC blockCStone = new BlockCStone();
    public static final BlockKC blockDStone = new BlockDStone();
    public static final BlockKC blockTStone = new BlockTStone();
    public static final BlockKC blockQuadStone = new BlockQuadStone();
    public static final BlockKC blockQuinStone = new BlockQuinStone();
    public static final BlockKC blockSeStone = new BlockSeStone();
    public static final BlockKC blockSepStone = new BlockSepStone();
    public static final BlockKC blockOStone = new BlockOStone();

    public static final Block blockGeneratorIdle = new BlockGenerator(false).setBlockName("blockGeneratorIdle").setCreativeTab(CreativeTabKC.KC_TAB_BLOCKS);
    public static final Block blockGeneratorActive = new BlockGenerator(true).setBlockName("blockGeneratorActive");
    public static final int guiIDBlockGenerator = 1;

    public static void init()
    {
        // Blocks
        GameRegistry.registerBlock(blockCStone, "blockCStone");
        GameRegistry.registerBlock(blockDStone, "blockDStone");
        GameRegistry.registerBlock(blockTStone, "blockTStone");
        GameRegistry.registerBlock(blockQuadStone, "blockQuadStone");
        GameRegistry.registerBlock(blockQuinStone, "blockQuinStone");
        GameRegistry.registerBlock(blockSeStone, "blockSeStone");
        GameRegistry.registerBlock(blockSepStone, "blockSepStone");
        GameRegistry.registerBlock(blockOStone, "blockOStone");

        // Machines
        GameRegistry.registerBlock(blockGeneratorIdle, "blockGeneratorIdle");
        GameRegistry.registerBlock(blockGeneratorActive, "blockGeneratorActive");
    }

    public static void tileEntityRegister()
    {
        GameRegistry.registerTileEntity(TileEntityBlockGenerator.class, "BlockGenerator");
    }
}
