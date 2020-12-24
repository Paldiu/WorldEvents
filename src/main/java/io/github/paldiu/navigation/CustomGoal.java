package io.github.paldiu.navigation;

import com.destroystokyo.paper.entity.Pathfinder;
import net.minecraft.server.PathfinderGoal;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomGoal implements Pathfinder {


    @NotNull
    @Override
    public Mob getEntity() {
        return null;
    }

    @Override
    public void stopPathfinding() {

    }

    @Override
    public boolean hasPath() {
        return false;
    }

    @Nullable
    @Override
    public PathResult getCurrentPath() {
        return null;
    }

    @Nullable
    @Override
    public PathResult findPath(@NotNull Location location) {
        return null;
    }

    @Nullable
    @Override
    public PathResult findPath(@NotNull LivingEntity livingEntity) {
        return null;
    }

    @Override
    public boolean moveTo(@NotNull Pathfinder.PathResult pathResult, double v) {
        return false;
    }

    @Override
    public boolean canOpenDoors() {
        return false;
    }

    @Override
    public void setCanOpenDoors(boolean b) {

    }

    @Override
    public boolean canPassDoors() {
        return false;
    }

    @Override
    public void setCanPassDoors(boolean b) {

    }

    @Override
    public boolean canFloat() {
        return false;
    }
}
