package org.srevolution.Hymagika.Systems;

import com.hypixel.hytale.component.*;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.HolderSystem;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.srevolution.Hymagika.Components.ManaComponent;
import org.srevolution.Hymagika.HymagikaPlugin;

import javax.annotation.Nonnull;

public class InitializeManaSystem extends HolderSystem<EntityStore> {
    @Override
    public Query<EntityStore> getQuery() {
        return Query.and(PlayerRef.getComponentType(), Query.not(HymagikaPlugin.getManaComponentType()));
    }

    @Override
    public void onEntityAdd(@Nonnull Holder<EntityStore> playerHolder, @Nonnull AddReason addReason, @Nonnull Store<EntityStore> store) {
        playerHolder.addComponent(HymagikaPlugin.getManaComponentType(), new ManaComponent());
    }

    @Override
    public void onEntityRemoved(@Nonnull Holder<EntityStore> holder, @Nonnull RemoveReason removeReason, @Nonnull Store<EntityStore> store) { }
}
