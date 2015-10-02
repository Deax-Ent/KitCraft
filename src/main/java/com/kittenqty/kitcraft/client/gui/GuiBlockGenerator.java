package com.kittenqty.kitcraft.client.gui;

import com.kittenqty.kitcraft.container.ContainerBlockGenerator;
import com.kittenqty.kitcraft.reference.Reference;
import com.kittenqty.kitcraft.tileentity.TileEntityBlockGenerator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiBlockGenerator extends GuiContainer
{
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "/textures/gui/BlockGenerator.png");
    private TileEntityBlockGenerator blockGenerator;

    public GuiBlockGenerator(InventoryPlayer invPlayer, TileEntityBlockGenerator teBlockGenerator) {
        super(new ContainerBlockGenerator(invPlayer, teBlockGenerator));
        blockGenerator = teBlockGenerator;

        this.xSize = 176;
        this.ySize = 166;
    }

    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        String name = this.blockGenerator.hasCustomInventoryName() ? this.blockGenerator.getInventoryName() : I18n.format(this.blockGenerator.getInventoryName());

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        // Do things with power

        // Do things with progress
    }
}
