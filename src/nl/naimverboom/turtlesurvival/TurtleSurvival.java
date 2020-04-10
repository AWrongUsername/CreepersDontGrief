package nl.naimverboom.turtlesurvival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TurtleSurvival extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new onChangeBlockEvent(), this);

        System.out.println("================= CreepersDontGrief =================");
        System.out.println();
        System.out.println("Thank you for using our plugins!");
        System.out.println("All plugin rights go to asemkiller and AWrongUsername.");
        System.out.println("For contact, message asemkiller#9073 or ");
        System.out.println("AWrongUsername#9129 on discord, or naimverboom.nl.");
        System.out.println();
        System.out.println("======================================================");

    }

    @Override
    public void onDisable() {

    }

    public static TurtleSurvival getInstance() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("TurtleSurvival");
        if (plugin == null || !(plugin instanceof TurtleSurvival)) {
            throw new RuntimeException("'CreepersDontGrief' not found. 'CreepersDontGrief' plugin disabled?");
        }

        return ((TurtleSurvival) plugin);
    }

}
