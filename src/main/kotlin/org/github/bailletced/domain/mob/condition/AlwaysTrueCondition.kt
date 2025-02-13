package org.github.bailletced.domain.mob.condition

import org.github.bailletced.domain.mob.context.MobContext

class AlwaysTrueCondition : Condition {
    override fun test(context: MobContext): Boolean {
        return true
    }
}
