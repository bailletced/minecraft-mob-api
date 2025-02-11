package org.github.bailletced.infra.paper.mob.behavior

import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.context.MobContext

class ReturnToSpawnBehavior() : MobBehavior {
    override fun shouldExecute(context: MobContext): Boolean {
        return true
    }

    override fun execute(context: MobContext) {
        // TODO : Logique de déplacement vers spawnLocation
    }

    override fun getPriority(): Int = 100
}
