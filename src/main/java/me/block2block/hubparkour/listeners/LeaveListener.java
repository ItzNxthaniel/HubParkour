package me.block2block.hubparkour.listeners;

import me.block2block.hubparkour.entities.HubParkourPlayer;
import me.block2block.hubparkour.managers.CacheManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (CacheManager.isParkour(e.getPlayer())) {
            HubParkourPlayer player = CacheManager.getPlayer(e.getPlayer());
            player.removeItems();
            player.getParkour().playerEnd(player);
            CacheManager.playerEnd(player);
        }
    }

}
