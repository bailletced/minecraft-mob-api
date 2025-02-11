package org.github.bailletced.domain.mob.behavior

import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.MobContext

class ConditionalBehavior(
    private val condition: Condition,
    private val behavior: MobBehavior,
    private val priority: Int = behavior.getPriority(),
) : MobBehavior {
    override fun shouldExecute(context: MobContext): Boolean {
        return condition.test(context) && behavior.shouldExecute(context)
    }

    override fun execute(context: MobContext) {
        behavior.execute(context)
    }

    override fun getPriority(): Int = priority
}
