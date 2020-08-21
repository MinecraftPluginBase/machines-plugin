package com.github.viiictorxd.machines.loader;

import com.github.viiictorxd.machines.entity.MachineItem;
import com.github.viiictorxd.machines.entity.MachineItemSettings;
import com.google.common.collect.Maps;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.Map;

public class MachineLoader {

    private Plugin plugin;

    public MachineLoader(Plugin plugin) {
        this.plugin = plugin;
    }

    public Map<String, MachineItem> getAll() {
        if (plugin != null) {
            Map<String, MachineItem> MACHINES = Maps.newHashMap();

            ConfigurationSection configurationSection = plugin.getConfig().getConfigurationSection("machines");
            if (configurationSection != null) {
                for (String key : configurationSection.getKeys(false)) {
                    double price = configurationSection.getDouble(key + ".price");
                    MachineItemSettings settings = new MachineItemSettings(
                            configurationSection.getInt(key + ".machine-id"),
                            configurationSection.getInt(key + ".drop-id"),
                            configurationSection.getInt(key + ".drop-amount"),
                            configurationSection.getString(key + ".name"),
                            configurationSection.getStringList(key + ".description")
                    );

                    MACHINES.put(key, new MachineItem(
                            key,
                            price,
                            settings
                    ));
                }
                return MACHINES;
            }
        }
        return Maps.newHashMap();
    }
}
