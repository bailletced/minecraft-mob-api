package org.github.bailletced.domain.mob.condition

import org.github.bailletced.domain.mob.context.MobContext

class HasTargetCondition : Condition {
    override fun test(context: MobContext): Boolean {
        return context.currentTarget != null
    }
}
