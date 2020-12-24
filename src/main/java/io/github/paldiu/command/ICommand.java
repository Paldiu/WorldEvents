package io.github.paldiu.command;

import io.github.paldiu.WorldEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class ICommand implements CommandExecutor, TabCompleter {
    protected JavaPlugin plugin;

    protected ICommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    protected final boolean checkPermission(CommandSender sender, String permission) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return false;
        }

        return true;
    }

    protected final List<String> getMatches(String start, List<String> possibleMatches) {
        if (start.isEmpty()) return possibleMatches;

        List<String> matches = new ArrayList<>();
        for (String match : possibleMatches) {
            if (match.toLowerCase().startsWith(start.toLowerCase())) {
                matches.add(match);
            }
        }
        return matches;

    }

    public final boolean isPlayer(CommandSender sender) {
        return (sender instanceof Player);
    }

    public final void register(String name) {
        plugin.getCommand(name).setExecutor(this);
        plugin.getCommand(name).setTabCompleter(this);
    }
}
