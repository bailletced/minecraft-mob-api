package org.github.bailletced.infra.paper.mob.condition

import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.MobContext

class EntityNearLocationCondition(private val distance: Double) : Condition {
    override fun test(context: MobContext): Boolean {
        if (context.entity.location.distance(context.spawnLocation) <= distance) {
            return true
        }
        return false
    }
}
