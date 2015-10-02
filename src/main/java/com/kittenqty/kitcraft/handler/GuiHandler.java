package com.kittenqty.kitcraft.handler;

import com.kittenqty.kitcraft.client.gui.GuiBlockGenerator;
import com.kittenqty.kitcraft.container.ContainerBlockGenerator;
import com.kittenqty.kitcraft.init.ModBlocks;
import com.kittenqty.kitcraft.tileentity.TileEntityBlockGenerator;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null) {
            switch(ID) {
                case ModBlocks.guiIDBlockGenerator:
                    if(entity instanceof TileEntityBlockGenerator) {
                        return new ContainerBlockGenerator(player.inventory, (TileEntityBlockGenerator) entity);
                    }
                    return null;
            }
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null) {
            switch(ID) {
                case ModBlocks.guiIDBlockGenerator:
                    if(entity instanceof TileEntityBlockGenerator) {
                        return new GuiBlockGenerator(player.inventory, (TileEntityBlockGenerator) entity);
                    }
                    return null;
            }
        }

        return null;
    }
}
