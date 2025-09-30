package net.rimaki.emotax;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.atomic.AtomicInteger;

public class EventListener implements Listener {

    // Ver Info Pull
    String ver = EmotaXPlugin.INSTANCE.plver;
    String placehold = EmotaXPlugin.INSTANCE.placeholdercmd;

    private final EmotaXPlugin plugin;
    private final AtomicInteger integer = new AtomicInteger(1);

    public EventListener(EmotaXPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(placehold + "You're Using EmotaX : " + ver);
    }
}
