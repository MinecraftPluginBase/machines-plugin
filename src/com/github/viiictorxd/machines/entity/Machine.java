package com.github.viiictorxd.machines.entity;

import com.github.viiictorxd.machines.manager.MachineManager;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.UUID;

public class Machine {

    private UUID owner;
    private MachineItem item;
    private Location location;

    public Machine(UUID owner, MachineItem item, Location location) {
        this.owner = owner;
        this.item = item;
        this.location = location;
    }

    public UUID getOwner() {
        return owner;
    }

    public MachineItem getItem() {
        return item;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isOwner(UUID owner) {
        return this.owner == owner;
    }

    public void delete() {
        location.getWorld().dropItemNaturally(location, item.getSettings().getMachineItem());
        location.getBlock().setType(Material.AIR);

        MachineManager.remove(this);
    }
}
