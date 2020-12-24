package io.github.paldiu.api;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Mob;

public interface ILocustSwarm extends Mob {
    ILocustSwarm getSwarm();

    AreaEffectCloud getSwarmCloud();

    Location getSwarmLocation();

    World getSwarmWorld();

    int getSwarmSize();

    float getSwarmSpeed();

    double getSwarmChanceRate();
}
