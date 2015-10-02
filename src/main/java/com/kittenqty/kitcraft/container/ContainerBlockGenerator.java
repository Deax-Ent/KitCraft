package com.kittenqty.kitcraft.container;

import com.kittenqty.kitcraft.tileentity.TileEntityBlockGenerator;
import com.kittenqty.kitcraft.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerBlockGenerator extends Container
{
    private TileEntityBlockGenerator generator;
    private int cookTime;
    private int power;
    private int lastItemBurnTime;

    public ContainerBlockGenerator(InventoryPlayer invPlayer, TileEntityBlockGenerator teBlockGenerator)
    {
        cookTime = 0;
        power = 0;
        lastItemBurnTime = 0;

        generator = teBlockGenerator;

        // Machine Inventory
        this.addSlotToContainer(new Slot(teBlockGenerator, 0, 56, 31));
        this.addSlotToContainer(new Slot(teBlockGenerator, 1, 8, 53));


        // Player Inventory
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Player Actionbar
        for(int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.generator.cookTime);
        crafting.sendProgressBarUpdate(this, 1, this.generator.power);
    }

    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            LogHelper.info("TSIS 1");
            if (p_82846_2_ == 2)
            {
                LogHelper.info("TSIS 2");
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ != 1 && p_82846_2_ != 0)
            {
                LogHelper.info("TSIS 3");
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    LogHelper.info("TSIS 4");
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    LogHelper.info("TSIS 5");
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        LogHelper.info("TSIS 6");
                        return null;
                    }
                }
                else if (p_82846_2_ >= 3 && p_82846_2_ < 30)
                {
                    LogHelper.info("TSIS 7");
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        LogHelper.info("TSIS 8");
                        return null;
                    }
                }
                else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    LogHelper.info("TSIS 9");
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                LogHelper.info("TSIS 10");
                return null;
            }

            LogHelper.info("TSIS 11");
            if (itemstack1.stackSize == 0)
            {
                LogHelper.info("TSIS 12");
                slot.putStack((ItemStack)null);
            }
            else
            {
                LogHelper.info("TSIS 13");
                slot.onSlotChanged();
            }

            LogHelper.info("TSIS 14");
            if (itemstack1.stackSize == itemstack.stackSize)
            {
                LogHelper.info("TSIS 15");
                return null;
            }

            LogHelper.info("TSIS 16");
            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        LogHelper.info("TSIS 17");
        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return generator.isUseableByPlayer(player);
    }
}
