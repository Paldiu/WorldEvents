package io.github.paldiu;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Base {
    protected static final WorldEvents plugin;
    protected static final Server server;
    protected static final PluginManager manager;
    protected static final Logger logger;

    static {
        plugin = JavaPlugin.getPlugin(WorldEvents.class);
        server = plugin.getServer();
        manager = server.getPluginManager();
        logger = plugin.getLogger();
    }

    public static final WorldEvents getPlugin() {
        return plugin;
    }

    public static final Server getServer() {
        return server;
    }

    public static final PluginManager getPluginManager() {
        return manager;
    }

    public static final Logger getLogger() {
        return logger;
    }
}
