package org.srevolution.Hymagika.Components;

import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.plugin.PluginBase;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class PluginComponents {
    private ComponentType<EntityStore, ManaComponent> manaComponentType;

    public ComponentType<EntityStore, ManaComponent> getManaComponentType() {
        return this.manaComponentType;
    }

    public void register(PluginBase pluginBase) {
        this.manaComponentType = pluginBase.getEntityStoreRegistry().registerComponent(ManaComponent.class, ManaComponent::new);
    }
}
