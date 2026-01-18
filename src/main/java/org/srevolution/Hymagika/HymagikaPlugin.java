package org.srevolution.Hymagika;

import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.srevolution.Hymagika.Commands.PluginComands;
import org.srevolution.Hymagika.Components.FullManaComponent;
import org.srevolution.Hymagika.Components.ManaComponent;
import org.srevolution.Hymagika.Components.PluginComponents;
import org.srevolution.Hymagika.Systems.PluginSystems;

import javax.annotation.Nonnull;

/**
 * This class serves as the entrypoint for your plugin. Use the setup method to register into game registries or add
 * event listeners.
 */
public class HymagikaPlugin extends JavaPlugin {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    private static HymagikaPlugin instance;

    private static PluginComponents pluginComponents = new PluginComponents();
    private static PluginSystems pluginSystems = new PluginSystems();
    private static PluginComands pluginComands = new PluginComands();

    public HymagikaPlugin(@Nonnull JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Hello from " + this.getName() + " version " + this.getManifest().getVersion().toString());
        instance = this;
    }

    public static HymagikaPlugin getInstance() {
        return instance;
    }

    public static void log(String msg) {
        LOGGER.atInfo().log(msg);
    }

    public static ComponentType<EntityStore, ManaComponent> getManaComponentType() {
        return pluginComponents.getManaComponentType();
    }

    public static ComponentType<EntityStore, FullManaComponent> getFullManaComponentType() {
        return pluginComponents.getFullManaComponentType();
    }

    @Override
    protected void setup() {
        LOGGER.atInfo().log("Setting up plugin " + this.getName());
        pluginComponents.register(this);
        pluginSystems.register(this);
        pluginComands.register(this);
    }
}