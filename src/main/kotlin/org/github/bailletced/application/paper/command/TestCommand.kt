package org.github.bailletced.application.paper.command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Mob
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class TestCommand(private val plugin: JavaPlugin) : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>,
    ): Boolean {
        sender.sendMessage("Bonjour ${sender.name} ! Bienvenue !")

        val player = sender as Player
        val world = player.world
        val zombie = world.spawnEntity(player.location, org.bukkit.entity.EntityType.ZOMBIE) as Mob

        val mobGoals = Bukkit.getMobGoals()
        mobGoals.removeAllGoals(zombie)

        zombie.pathfinder.moveTo(player)

        Bukkit.getScheduler().runTaskLater(
            plugin,
            Runnable {
                zombie.pathfinder.moveTo(player)
            },
            60L,
        ) // 100 ticks = 5 secondes (20 ticks = 1 seconde)[1][2]

        return true
    }
}
