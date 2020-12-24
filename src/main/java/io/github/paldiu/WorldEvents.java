package io.github.paldiu;

import io.github.paldiu.command.CommandPathScanner;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldEvents extends JavaPlugin {
    public WorldEvents plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        CommandPathScanner.getInstance().registerAll();
    }

    @Override
    public void onDisable() {

    }
}
