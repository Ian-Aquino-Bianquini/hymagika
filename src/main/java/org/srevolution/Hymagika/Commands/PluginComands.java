package org.srevolution.Hymagika.Commands;

import com.hypixel.hytale.server.core.plugin.PluginBase;

public class PluginComands {
    public void register(PluginBase pluginBase) {
        pluginBase.getCommandRegistry().registerCommand(new ManaCommand());
    }
}
