package com.kittenqty.kitcraft.block;

import com.kittenqty.kitcraft.creativetab.CreativeTabKC;
import com.kittenqty.kitcraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockKC extends Block
{

    public BlockKC(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabKC.KC_TAB_BLOCKS);
        this.setHardness(10.0f);
        this.setResistance(15.0f);
        this.setHarvestLevel("pickaxe", 3);
    }

    public BlockKC()
    {
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
