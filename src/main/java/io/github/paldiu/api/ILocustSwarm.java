package io.github.paldiu.api;

import net.minecraft.server.EntityAreaEffectCloud;
import org.bukkit.Location;
import org.bukkit.World;

public interface ILocustSwarm {
    ILocustSwarm getSwarm();

    EntityAreaEffectCloud getSwarmCloud();

    Location getSwarmLocation();

    World getSwarmWorld();

    int getSwarmSize();

    float getSwarmSpeed();

    double getSwarmChanceRate();
}
