package com.github.viiictorxd.machines.entity;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MachineItemSettings {

    private int machineId,
            dropId,
            dropAmount;
    private String machineName;
    private List<String> machineLore;

    public MachineItemSettings(int machineId, int dropId, int dropAmount, String machineName, List<String> machineLore) {
        this.machineId = machineId;
        this.dropId = dropId;
        this.dropAmount = dropAmount;
        this.machineName = machineName;
        this.machineLore = machineLore;
    }

    public int getMachineId() {
        return machineId;
    }

    public int getDropId() {
        return dropId;
    }

    public int getDropAmount() {
        return dropAmount;
    }

    public String getMachineName() {
        return machineName;
    }

    public List<String> getMachineLore() {
        return machineLore;
    }

    public ItemStack getMachineItem() {
        ItemStack itemStack = new ItemStack(Material.getMaterial(machineId));

        ItemMeta itemMeta = itemStack.getItemMeta();;
        itemMeta.setDisplayName(machineName);
        itemMeta.setLore(machineLore);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
