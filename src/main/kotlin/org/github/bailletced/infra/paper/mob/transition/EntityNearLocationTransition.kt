package org.github.bailletced.infra.paper.mob.transition

import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.MobContext
import org.github.bailletced.domain.mob.state.MobState
import org.github.bailletced.domain.mob.state.TransitionState
import org.github.bailletced.infra.paper.mob.condition.EntityNearLocationCondition
import org.github.bailletced.infra.paper.mob.state.CombatState
import org.github.bailletced.infra.paper.mob.state.PatrolState

class EntityNearLocationTransition(
    private val distance: Double = 3.0,
) : TransitionState {
    override val condition: Condition = EntityNearLocationCondition(distance)

    override fun execute(context: MobContext): MobState {
        val location = context.spawnLocation

        val target =
            location.getNearbyEntities(distance, distance, distance)
                .firstOrNull { entity -> entity.uniqueId != context.entity.uniqueId }

        if (target != null) {
            return CombatState(target)
        } else {
            return PatrolState()
        }
    }
}
