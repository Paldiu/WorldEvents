package io.github.paldiu.navigation;

import com.destroystokyo.paper.entity.ai.Goal;
import com.destroystokyo.paper.entity.ai.GoalKey;
import com.destroystokyo.paper.entity.ai.GoalType;
import io.github.paldiu.Base;
import io.github.paldiu.api.LocustSwarm;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;

public class LocustGoal implements Goal<LocustSwarm> {
    private static final LocustGoal goal = new LocustGoal();

    protected final NamespacedKey locustNamespace;
    protected final GoalKey<LocustSwarm> goalKey;
    protected final EnumSet<GoalType> goalTypes = EnumSet.noneOf(GoalType.class);

    private LocustGoal() {
        locustNamespace = new NamespacedKey(Base.getPlugin(), "locust_swarm");
        goalKey = GoalKey.of(LocustSwarm.class, locustNamespace);
        goalTypes.add(GoalType.MOVE);
        goalTypes.add(GoalType.JUMP);
        goalTypes.add(GoalType.LOOK);
    }

    public static LocustGoal get() {
        return goal;
    }

    @Override
    public boolean shouldActivate() {
        return false;
    }

    @Override
    public boolean shouldStayActive() {
        return false;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void tick() {

    }

    @NotNull
    @Override
    public GoalKey<LocustSwarm> getKey() {
        return goalKey;
    }

    @NotNull
    @Override
    public EnumSet<GoalType> getTypes() {
        return goalTypes;
    }
}