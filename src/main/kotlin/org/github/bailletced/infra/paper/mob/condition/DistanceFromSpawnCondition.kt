package org.github.bailletced.infra.paper.mob.condition

import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.MobContext

class DistanceFromSpawnCondition(private val distance: Long, private val shouldBeWithin: Boolean = true) : Condition {
    override fun test(context: MobContext): Boolean {
        if (shouldBeWithin) return context.spawnLocation.distance(context.entity.location) >= distance
        return context.spawnLocation.distance(context.entity.location) < distance
    }
}
