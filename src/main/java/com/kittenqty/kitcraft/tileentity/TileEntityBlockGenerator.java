package com.kittenqty.kitcraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlockGenerator extends TileEntity implements IInventory
{

    private ItemStack slots[];

    public int power;
    public int cookTime;

    private String customName;

    public TileEntityBlockGenerator()
    {
        slots = new ItemStack[2];
    }

    @Override
    public int getSizeInventory() {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return slots[i];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        slots[i] = itemStack;
        if(itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "container.blockGenerator";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        if(worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
            return false;
        } else {
            return player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64;
        }
    }

    public void openInventory() {}
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return i == 1 ? false : (i == 0 ? hasItemPower(itemStack) : true);
    }

    public boolean hasItemPower(ItemStack itemStack)
    {
        return getItemPower(itemStack) > 0;
    }

    private static int getItemPower(ItemStack itemStack)
    {
        if(itemStack == null) {
            return 0;
        } else {
            Item item = itemStack.getItem();

            if(item == Items.coal) {
                return 50;
            }

            return 0;
        }
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if(slots[i] != null) {
            if(slots[i].stackSize <= j) {
                ItemStack itemStack = slots[i];
                slots[i] = null;
                return itemStack;
            }

            ItemStack itemStack1 = slots[i].splitStack(j);
            if(slots[i].stackSize == 0) {
                slots[i] = null;
            }

            return itemStack1;
        } else {
            return null;
        }
    }
}
