package org.github.bailletced.domain.mob.condition

import org.github.bailletced.domain.mob.context.MobContext

class HasLastAttackerCondition : Condition {
    override fun test(context: MobContext): Boolean {
        return context.lastAttacker != null
    }
}
