package com.github.viiictorxd.machines.manager;

import com.github.viiictorxd.machines.entity.MachineItem;
import com.google.common.collect.Maps;

import java.util.Map;

public class MachineItemManager {

    private static Map<String, MachineItem> MACHINES = Maps.newHashMap();

    public static MachineItem get(String type) {
        return MACHINES.getOrDefault(type, null);
    }

    public static boolean contains(String type) {
        return MACHINES.containsKey(type);
    }

    public static void put(Map<String, MachineItem> MACHINES) {
        MachineItemManager.MACHINES = MACHINES;
    }
}
