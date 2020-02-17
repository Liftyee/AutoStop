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
                if (time.equals("06:00")) {
                    Bukkit.broadcastMessage("[!] §e累格累格管理員：§c§l伺服器維護時間到了！大約三分鐘就可以進遊戲了。");
                    Bukkit.broadcastMessage("[!] §e累格累格管理員：§c§l伺服器維護時間到了！大約三分鐘就可以進遊戲了。");
                    Bukkit.broadcastMessage("[!] §e累格累格管理員：§c§l伺服器維護時間到了！大約三分鐘就可以進遊戲了。");
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