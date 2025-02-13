package org.github.bailletced.application.paper.command

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.github.bailletced.infra.paper.mob.factory.TotoMobFactory

class TestCommand(private val plugin: JavaPlugin) : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>,
    ): Boolean {
        sender.sendMessage("Bonjour ${sender.name} ! Bienvenue !")

        val entity =
            TotoMobFactory(plugin).createToto(
                (sender as Player).world,
                Location(
                    sender.world,
                    23.0,
                    88.0,
                    -61.0,
                ),
            )

        sender.sendMessage("spawned $entity")

        return true
    }
}
