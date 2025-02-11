package org.github.bailletced.infra.paper.mob.factory

import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import org.github.bailletced.domain.mob.MobOrchestrator
import org.github.bailletced.domain.mob.behavior.ConditionalBehavior
import org.github.bailletced.domain.mob.context.MobContext
import org.github.bailletced.infra.paper.mob.behavior.AttackNearestPlayerBehavior
import org.github.bailletced.infra.paper.mob.behavior.ReturnToSpawnBehavior
import org.github.bailletced.infra.paper.mob.condition.DistanceFromSpawnCondition

class MobFactory(private val plugin: JavaPlugin) {
    fun createToto(
        world: World,
        location: Location,
    ): Entity {
        val entity = world.spawnEntity(location, EntityType.ZOMBIE)
        val context = MobContext(entity, entity.location, null, null)
        val orchestrator = MobOrchestrator(context)

        val farFromSpawnCondition = DistanceFromSpawnCondition(30L, true)
        val returnToSpawnBehavior = ConditionalBehavior(farFromSpawnCondition, ReturnToSpawnBehavior())

        orchestrator.addBehavior(AttackNearestPlayerBehavior())
        orchestrator.addBehavior(returnToSpawnBehavior)

        object : BukkitRunnable() {
            override fun run() {
                orchestrator.tick()
            }
        }.runTaskTimer(plugin, 0L, 20L)

        return entity
    }
}
