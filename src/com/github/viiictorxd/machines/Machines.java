package com.github.viiictorxd.machines;

import com.github.viiictorxd.machines.listener.BlockListener;
import com.github.viiictorxd.machines.loader.MachineLoader;
import com.github.viiictorxd.machines.manager.MachineItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Machines extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        // Loading all machines from config.yml
        MachineItemManager.put(new MachineLoader(this).getAll());

        // Registering listener
        Bukkit.getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }
}
