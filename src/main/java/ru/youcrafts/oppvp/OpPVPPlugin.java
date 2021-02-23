package ru.youcrafts.oppvp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(
        name = "OpPVP",
        version = "1.0.0"
)
@Author(value = "oDD1 / Alexander Repin")
@Description(value = "PVP allow only with operator players")
public class OpPVPPlugin extends JavaPlugin implements Listener
{


    @Override
    public void onEnable()
    {
        Bukkit.getPluginManager().registerEvents(this, this);
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDamage(EntityDamageByEntityEvent event)
    {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player damager = (Player) event.getDamager();
        Player victim = (Player) event.getEntity();

        if (!damager.isOp() && !victim.isOp()) {
            event.setCancelled(true);
        }
    }
}
