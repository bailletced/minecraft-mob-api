package org.github.bailletced.infra.paper.mob.behavior

import org.bukkit.entity.Player
import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.context.MobContext

class AttackNearestPlayerBehavior(
    private val detectionRange: Double = 20.0,
) : MobBehavior {
    override fun shouldExecute(context: MobContext): Boolean {
        return context.entity.getNearbyEntities(detectionRange, detectionRange, detectionRange)
            .filterIsInstance<Player>()
            .isNotEmpty()
    }

    override fun execute(context: MobContext) {
        // TODO : implémenter la logique d'attaque
    }

    override fun getPriority(): Int = 50
}
