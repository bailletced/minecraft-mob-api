package org.github.bailletced.infra.paper.mob.condition

import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.MobContext

class EntityNearSpawnCondition(private val distance: Double) : Condition {
    override fun test(context: MobContext): Boolean {
        val world = context.entity.world
        val entities =
            world.getNearbyEntities(
                context.spawnLocation,
                distance,
                distance,
                distance,
            ) { entity -> entity is Entity && entity.uniqueId != context.entity.uniqueId }

        Bukkit.getConsoleSender().sendMessage("Executing EntityNearSpawnLocation condition ${entities.isNotEmpty()}")

        return entities.isNotEmpty()
    }
}
