package org.srevolution.Hymagika.Commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.srevolution.Hymagika.Components.ManaComponent;
import org.srevolution.Hymagika.HymagikaPlugin;

import javax.annotation.Nonnull;

public class ManaCommand extends CommandBase {

    public ManaCommand() {
        super("mana", "Conjunto de comandos que alteram a mana");
    }

    RequiredArg<String> methodArg = this.withRequiredArg("method", "O argumento pode ser: set para alterar a mana atual.", ArgTypes.STRING);
    RequiredArg<Float> quantityArg = this.withRequiredArg("quantity", "O valor a ser alterado", ArgTypes.FLOAT);

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        if(!ctx.isPlayer()) return;
        String method = methodArg.get(ctx);
        Float quantity = quantityArg.get(ctx);

        switch (method) {
            case "set":
                Ref<EntityStore> ref = ctx.senderAsPlayerRef();
                if(ref == null) return;
                Store<EntityStore> store = ref.getStore();

                World targetWorld = store.getExternalData().getWorld();

                targetWorld.execute(() -> {
                    ManaComponent manaComponent = store.getComponent(ref, HymagikaPlugin.getManaComponentType());
                    if(manaComponent == null) return;
                    manaComponent.setMana(quantity);
                    store.tryRemoveComponent(ref, HymagikaPlugin.getFullManaComponentType());
                });


                break;
        }
    }
}
