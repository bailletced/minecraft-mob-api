package org.github.bailletced

import org.bukkit.plugin.java.JavaPlugin
import org.github.bailletced.application.paper.command.TestCommand
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class MobApi : JavaPlugin() {
    override fun onEnable() {
        this.getCommand("test")?.setExecutor(TestCommand(this))

        val modulePlugin =
            module {
                // Enregistrement des singletons essentiels
                single<MobApi> { this@MobApi }
            }

        startKoin {
            modules(modulePlugin)
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
