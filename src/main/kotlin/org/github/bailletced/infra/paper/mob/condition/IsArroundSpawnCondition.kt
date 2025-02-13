package org.github.bailletced.infra.paper.mob.condition

import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.MobContext

class IsArroundSpawnCondition(private val distance: Long) : Condition {
    override fun test(context: MobContext): Boolean {
        return context.spawnLocation.distance(context.entity.location) <= distance
    }
}
