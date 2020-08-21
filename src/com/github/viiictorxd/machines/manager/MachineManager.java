package com.github.viiictorxd.machines.manager;

import com.github.viiictorxd.machines.entity.Machine;
import com.google.common.collect.Maps;
import org.bukkit.Location;

import java.util.Map;

public class MachineManager {

    private static Map<Location, Machine> MACHINES = Maps.newHashMap();

    public static Machine get(Location location) {
        return MACHINES.getOrDefault(location, null);
    }

    public static boolean contains(Location location) {
        return MACHINES.containsKey(location);
    }

    public static void put(Machine machine) {
        MACHINES.put(machine.getLocation(), machine);
    }

    public static void remove(Machine machine) {
        MACHINES.remove(machine.getLocation());
    }
}
