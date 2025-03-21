package com.aquamobs.aquaMobsUI;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class CustomCrafts implements Listener {

    public static int[] slotAmount = new int[9];

    public static void aquaCrafts(PrepareItemCraftEvent e, ItemStack result, ItemStack[] ingredient) {

        CraftingInventory inventory = e.getInventory();
        ItemStack[] matrix = inventory.getMatrix();

        for (int i = 0; i < slotAmount.length; i++) {
            if (ingredient[i] != null) {
                slotAmount[i] = ingredient[i].getAmount();
            } else {
                slotAmount[i] = 0;
            }
        }

        boolean validRecipe = true;

        boolean[] slot = new boolean[9];

        try {
            for (int i = 0; i < matrix.length; i++) {
                ItemStack item = matrix[i];
                if (ingredient[i] != null) {
                    if (item.getType() == ingredient[i].getType() && item.getAmount() >= ingredient[i].getAmount()) {
                        slot[i] = true;
                    } else {
                        validRecipe = false;
                    }
                } else {
                    slot[i] = true;
                }
            }
        } catch(NullPointerException npe) {
            String useless = null;
        }

        for (int i = 0; i < slot.length; i++) {
            if (slot[i]) {
                validRecipe = true;
            } else {
                validRecipe = false;
                break;
            }
        }

        if (!validRecipe) {
            inventory.setResult(ItemStack.of(Material.AIR, 1));
        } else {
            inventory.setResult(result);
        }
    }

    @EventHandler
    public void craftEvent(InventoryClickEvent e) {
        CraftingInventory inventory = (CraftingInventory) e.getInventory();
        ItemStack[] matrix = inventory.getMatrix();

        if (inventory.getType() == InventoryType.WORKBENCH && e.getRawSlot() == 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i] != null) {
                    matrix[i].setAmount(matrix[i].getAmount() - slotAmount[i]);
                }
            }
        }
    }
}