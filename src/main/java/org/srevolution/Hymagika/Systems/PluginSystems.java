package org.srevolution.Hymagika.Systems;

import com.hypixel.hytale.server.core.plugin.PluginBase;

public class PluginSystems {
    public void register(PluginBase pluginBase) {
        pluginBase.getEntityStoreRegistry().registerSystem(new InitializeManaSystem());
        pluginBase.getEntityStoreRegistry().registerSystem(new ManaRegenSystem());
    }
}
