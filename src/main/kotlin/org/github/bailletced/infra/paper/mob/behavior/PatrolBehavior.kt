package org.github.bailletced.infra.paper.mob.behavior

import org.bukkit.Bukkit
import org.bukkit.entity.Mob
import org.bukkit.scheduler.BukkitRunnable
import org.github.bailletced.MobApi
import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.context.MobContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.random.Random

class PatrolBehavior(val patrolInterval: Int) : MobBehavior, KoinComponent {
    private val plugin: MobApi by inject<MobApi>()
    private var canPatrol = true

    override fun shouldExecute(context: MobContext): Boolean {
        return canPatrol
    }

    override fun execute(context: MobContext) {
        Bukkit.getConsoleSender().sendMessage("Executing patrol behavior")

        val mob = context.entity as Mob
        val random = Random.Default
        val currentLoc = context.entity.location

        // Génère un offset aléatoire entre 5 et 10 blocs
        val offsetX = random.nextDouble(5.0, 10.0) * if (random.nextBoolean()) 1 else -1
        val offsetZ = random.nextDouble(5.0, 10.0) * if (random.nextBoolean()) 1 else -1

        // Calcule la nouvelle position
        val targetLoc = currentLoc.clone().add(offsetX, 0.0, offsetZ)
        targetLoc.y = context.entity.world.getHighestBlockYAt(targetLoc.blockX, targetLoc.blockZ).toDouble()

        canPatrol = false
        mob.pathfinder.moveTo(targetLoc)

        object : BukkitRunnable() {
            override fun run() {
                canPatrol = true
            }
        }.runTaskLater(plugin, patrolInterval.toLong())
    }

    override fun getPriority(): Int {
        return 150
    }
}
