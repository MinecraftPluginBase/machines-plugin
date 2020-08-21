package com.github.viiictorxd.machines.listener;

import com.github.viiictorxd.machines.entity.Machine;
import com.github.viiictorxd.machines.entity.MachineItem;
import com.github.viiictorxd.machines.manager.MachineItemManager;
import com.github.viiictorxd.machines.manager.MachineManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    private void onBlockPlace(BlockPlaceEvent event) {
        if (!event.isCancelled()) {
            // Aqui, você irá pegar o tipo da máquina do jogador utilizando o NBT

            String type = /* get type from item in hand */ null;

            // Retornando objeto de uma máquina criada
            MachineItem item = MachineItemManager.get(type);

            // Não existe, logo não é uma máquina
            if (item == null) return;

            // Se chegamos aqui, é uma máquina!
            MachineManager.put(new Machine(
                    event.getPlayer().getUniqueId(),
                    item,
                    event.getBlock().getLocation()
            ));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void onBlockBreak(BlockBreakEvent event) {
        if (!event.isCancelled()) {
            // Retornando objeto de uma máquina física válida
            Machine machine = MachineManager.get(event.getBlock().getLocation());

            // Não existe, logo não é uma máquina e sim um bloco qualquer
            if (machine == null) return;

            // Não é o proprietário da máquina e não possui a permissão bypass
            if (!machine.isOwner(event.getPlayer().getUniqueId()) && !event.getPlayer().hasPermission("machine.bypass")) return;

            // Removendo a máquina
            machine.delete();
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.isCancelled() && event.getClickedBlock() != null) {
            // Retornando objeto de uma máquina física válida
            Machine machine = MachineManager.get(event.getClickedBlock().getLocation());

            // Não existe, logo não é uma máquina e sim um bloco qualquer
            if (machine == null) return;

            event.setCancelled(true);
            event.getPlayer().sendMessage(new String[] {
                    "",
                    ChatColor.GREEN + "Owner: " + ChatColor.WHITE + machine.getOwner().toString(),
                    ChatColor.GREEN + "Type: " + ChatColor.WHITE + machine.getItem().getSettings().getMachineName(),
                    ""
            });
        }
    }
}
