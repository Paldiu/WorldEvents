package io.github.paldiu.api;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Zombie;

public abstract class LocustSwarm implements ILocustSwarm, Zombie {
    private final AreaEffectCloud swarm;
    private final World world;
    private final Location location;
    private final int swarmSize;
    private final float swarmSpeed;
    private final double swarmSpawnChance;

    public LocustSwarm(Location location, int size, float speed, double chance) {
        this.location = location;
        this.world = location.getWorld();
        this.swarm = null;
        this.swarmSize = size;
        this.swarmSpeed = speed;
        this.swarmSpawnChance = chance;


    }

    public abstract void spawnSwarm();

    @Override
    public ILocustSwarm getSwarm() {
        return this;
    }

    @Override
    public AreaEffectCloud getSwarmCloud() {
        return swarm;
    }

    @Override
    public Location getSwarmLocation() {
        return location;
    }

    @Override
    public World getSwarmWorld() {
        return world;
    }

    @Override
    public int getSwarmSize() {
        return swarmSize;
    }

    @Override
    public float getSwarmSpeed() {
        return swarmSpeed;
    }

    @Override
    public double getSwarmChanceRate() {
        return swarmSpawnChance;
    }
}
