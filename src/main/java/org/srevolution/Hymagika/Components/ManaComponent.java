package org.srevolution.Hymagika.Components;

import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class ManaComponent implements Component<EntityStore> {
    private float mana;
    private float maxMana;


    public ManaComponent() {
        this(0.0f);
    }

    public ManaComponent(Float mana) {
        this(mana,100.0f);
    }

    public ManaComponent(Float mana, Float maxMana) {
        this.mana = mana;
        this.maxMana = maxMana;
    }


    public ManaComponent(ManaComponent other) {
        this.mana = other.mana;
        this.maxMana = other.maxMana;
    }

    @Override
    public Component<EntityStore> clone() {
        return new ManaComponent(this);
    }
}
