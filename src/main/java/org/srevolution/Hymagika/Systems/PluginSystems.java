package org.srevolution.Hymagika.Systems;

import com.hypixel.hytale.server.core.plugin.PluginBase;
import org.srevolution.Hymagika.HymagikaPlugin;

public class PluginSystems {
    public void register(PluginBase pluginBase) {
        HymagikaPlugin.log(new InitializeManaSystem().toString());
        pluginBase.getEntityStoreRegistry().registerSystem(new InitializeManaSystem());
    }
}
