package org.srevolution.Hymagika.Systems;

import com.hypixel.hytale.component.*;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.tick.EntityTickingSystem;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.srevolution.Hymagika.Components.FullManaComponent;
import org.srevolution.Hymagika.Components.ManaComponent;
import org.srevolution.Hymagika.HymagikaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ManaRegenSystem extends EntityTickingSystem<EntityStore> {

    @Override
    public void tick(float deltaTime, int i, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk, @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer) {
        ManaComponent manaComponent = archetypeChunk.getComponent(i, HymagikaPlugin.getManaComponentType());

        if(manaComponent == null) return;

        HymagikaPlugin.log("adicionando MANA: " + manaComponent.getMana());

        manaComponent.regenMana(deltaTime);

        if(manaComponent.isFullMana()) {
            Ref<EntityStore> targetRef = archetypeChunk.getReferenceTo(i);

            commandBuffer.addComponent(targetRef, HymagikaPlugin.getFullManaComponentType(), new FullManaComponent());
        }

    }

    @Nullable
    @Override
    public Query<EntityStore> getQuery() {
        return Query.and(HymagikaPlugin.getManaComponentType(), Query.not(HymagikaPlugin.getFullManaComponentType()));
    }
}
