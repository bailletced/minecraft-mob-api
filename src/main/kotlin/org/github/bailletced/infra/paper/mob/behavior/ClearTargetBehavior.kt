package org.github.bailletced.infra.paper.mob.behavior

import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.context.MobContext

class ClearTargetBehavior : MobBehavior {
    override fun shouldExecute(context: MobContext): Boolean {
        return true
    }

    override fun execute(context: MobContext) {
        context.currentTarget = null
    }

    override fun getPriority(): Int {
        return 10
    }
}
