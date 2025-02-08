package org.github.bailletced

import org.bukkit.plugin.java.JavaPlugin
import org.github.bailletced.application.paper.command.TestCommand

class MobApi : JavaPlugin() {
    override fun onEnable() {
        this.getCommand("test")?.setExecutor(TestCommand(this))

        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
