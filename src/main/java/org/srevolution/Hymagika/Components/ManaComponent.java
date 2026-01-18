package org.srevolution.Hymagika.Components;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class ManaComponent implements Component<EntityStore> {
    private float mana;
    private float maxMana;

    private float regenMana;

    private final float minMana = 0;

    public static final BuilderCodec<ManaComponent> CODEC = BuilderCodec.builder(
            ManaComponent.class,
            ManaComponent::new
    )
            .append(new KeyedCodec<>("Mana", Codec.FLOAT), (data, value) -> data.mana = value, data -> data.mana).add()
            .append(new KeyedCodec<>("MaxMana", Codec.FLOAT), (data, value) -> data.maxMana = value, data -> data.maxMana).add()
            .append(new KeyedCodec<>("RegenMana", Codec.FLOAT), (data, value) -> data.regenMana = value, data -> data.regenMana).add()
            .build();


    public ManaComponent() {
        this(0.0f);
    }

    public ManaComponent(float mana) {
        this(mana,100.0f);
    }

    public ManaComponent(float mana, float maxMana) {
        this(mana, maxMana, 2);
    }

    public ManaComponent(float mana, float maxMana, float regenMana) {
        this.mana = mana;
        this.maxMana = maxMana;
        this.regenMana = regenMana;
    }


    public ManaComponent(ManaComponent other) {
        this.mana = other.mana;
        this.maxMana = other.maxMana;
        this.regenMana = other.regenMana;
    }

    public void setMana(float manaToSet) {
        mana = Math.max(Math.min(manaToSet, maxMana), minMana);
    }

    public float getMaxMana() {
        return this.maxMana;
    }

    public boolean isFullMana() {
        return mana == maxMana;
    }

    public void setMaxMana(float maxManaToSet) {
        this.maxMana = maxManaToSet;
    }

    public void addMana(float manaToAdd) {
        float nextMana = mana + manaToAdd;
        mana = Math.min(nextMana, maxMana);
    }

    public void regenMana(float deltaTime) {
        this.addMana(deltaTime * this.regenMana);
    }

    public float getMana() {
        return this.mana;
    }

    public float getRegenMana() {
        return this.regenMana;
    }

    public void setRegenMana(float regenManaToSet) {
        this.regenMana = regenManaToSet;
    }

    @Override
    public Component<EntityStore> clone() {
        return new ManaComponent(this);
    }
}
