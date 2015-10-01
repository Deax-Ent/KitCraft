package com.kittenqty.kitcraft.block;

import com.kittenqty.kitcraft.creativetab.CreativeTabKC;
import com.kittenqty.kitcraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockGenerator extends BlockContainer
{

    private Random rand;
    private static boolean isActive = false;
    private static boolean keepInventory = true;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;


    public BlockGenerator(boolean blockState) {
        super(Material.iron);
        this.setBlockName("blockGenerator");
        this.setCreativeTab(CreativeTabKC.KC_TAB_BLOCKS);
        this.setHardness(10.0f);
        this.setResistance(15.0f);
        this.setHarvestLevel("pickaxe", 3);

        rand = new Random();
        isActive = blockState;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":blockGeneratorSide");
        this.iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "blockGeneratorFrontOn" : "blockGeneratorFontOff"));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z)
    {
        if(!world.isRemote) {
            Block block1 = world.getBlock(x, y, z - 1);
            Block block2 = world.getBlock(x, y, z + 1);
            Block block3 = world.getBlock(x - 1, y, z);
            Block block4 = world.getBlock(x + 1, y, z);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
