package tyze.bukkit.autostop;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class App extends JavaPlugin {
    private static final SimpleDateFormat df = new SimpleDateFormat("HH:mm");

    @Override
    public void onEnable() {
        getLogger().info("AutoStop enable.");

        new BukkitRunnable() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                Timestamp now = new Timestamp(cal.getTimeInMillis());
                String time = df.format(now);
                if (time.equals("22:50")) {
                    Bukkit.broadcastMessage("§c[!] WARNING! §1 The server will shutdown in §e10 §1 minutes! §c[!]");
                }
                if (time.equals("22:55")) {
                    Bukkit.broadcastMessage("§c[!] WARNING! The server will shutdown in 5 minutes! [!]");
                }
                if (time.equals("23:00")) {
                    Bukkit.broadcastMessage("§c[!] The server is shutting down... [!]");
                    Bukkit.broadcastMessage("Goodbye!");
                    Bukkit.shutdown();
                }
            }
        }.runTaskTimerAsynchronously(this, 60 * 20L, 10 * 20L);
    }

    @Override
    public void onDisable() {
        getLogger().info("AutoStop disable.");
    }
}
