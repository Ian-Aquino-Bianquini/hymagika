package org.srevolution.Hymagika.Components;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;


public class FullManaComponent implements Component<EntityStore> {

    public static final BuilderCodec<FullManaComponent> CODEC = BuilderCodec.builder(
            FullManaComponent.class,
            FullManaComponent::new
    ).build();


    @Override
    public Component<EntityStore> clone() {
        return new FullManaComponent();
    }
}
