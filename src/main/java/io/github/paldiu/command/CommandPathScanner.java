package io.github.paldiu.command;

import io.github.paldiu.Base;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class CommandPathScanner extends Base {
    private final Reflections reflections;
    private static final CommandPathScanner scanner = new CommandPathScanner();

    private CommandPathScanner() {
        reflections = new Reflections(ICommand.class.getPackage().getName());
    }

    public static CommandPathScanner getInstance() {
        return scanner;
    }

    public Set<Class<? extends ICommand>> getSubClasses() {
        return reflections.getSubTypesOf(ICommand.class);
    }

    public void registerAll() {
        getSubClasses().forEach(cls -> {
            try {
                Constructor<? extends ICommand> constructor = cls.getConstructor(JavaPlugin.class);
                ICommand command = constructor.newInstance(getPlugin());
                command.register(cls.getSimpleName().toLowerCase());
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                getLogger().severe(e.getMessage());
            }

            getAndSetFromAnnotation(cls);
        });
    }

    public void getAndSetFromAnnotation(Class<? extends ICommand> cls) {
        PluginCommand pcmd = plugin.getCommand(cls.getSimpleName());

        if (pcmd == null) {
            return;
        }

        if (cls.isAnnotationPresent(CommandParameters.class)) {
            CommandParameters parameters = cls.getAnnotation(CommandParameters.class);
            pcmd.setName(cls.getSimpleName());
            pcmd.setLabel(cls.getSimpleName().toLowerCase());
            pcmd.setDescription(parameters.description());
            pcmd.setUsage(parameters.usage());
            pcmd.setPermission(parameters.permission());
            pcmd.setAliases(Arrays.asList(parameters.aliases().split(",")));
        } else {
            pcmd.setName(cls.getSimpleName());
            pcmd.setLabel(cls.getSimpleName().toLowerCase());
            pcmd.setDescription("Undefined.");
            pcmd.setUsage("/<command>");
            pcmd.setPermission(getPlugin().getDescription().getName().toLowerCase()
                    + "."
                    + cls.getSimpleName().toLowerCase());
            pcmd.setAliases(new ArrayList<>());
        }
    }
}
