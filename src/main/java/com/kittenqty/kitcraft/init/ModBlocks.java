package com.kittenqty.kitcraft.init;

import com.kittenqty.kitcraft.block.*;
import com.kittenqty.kitcraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{

    public static final BlockKC BlockCStone = new BlockCStone();
    public static final BlockKC BlockDStone = new BlockDStone();
    public static final BlockKC BlockTStone = new BlockTStone();
    public static final BlockKC BlockQuadStone = new BlockQuadStone();
    public static final BlockKC BlockQuinStone = new BlockQuinStone();
    public static final BlockKC BlockSeStone = new BlockSeStone();
    public static final BlockKC BlockSepStone = new BlockSepStone();
    public static final BlockKC BlockOStone = new BlockOStone();

    public static void init()
    {
        GameRegistry.registerBlock(BlockCStone, "blockCStone");
        GameRegistry.registerBlock(BlockDStone, "blockDStone");
        GameRegistry.registerBlock(BlockTStone, "blockTStone");
        GameRegistry.registerBlock(BlockQuadStone, "blockQuadStone");
        GameRegistry.registerBlock(BlockQuinStone, "blockQuinStone");
        GameRegistry.registerBlock(BlockSeStone, "blockSeStone");
        GameRegistry.registerBlock(BlockSepStone, "blockSepStone");
        GameRegistry.registerBlock(BlockOStone, "blockOStone");
    }

}
