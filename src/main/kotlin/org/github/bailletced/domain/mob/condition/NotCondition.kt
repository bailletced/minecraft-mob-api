package org.github.bailletced.domain.mob.condition

import org.github.bailletced.domain.mob.context.MobContext

class NotCondition(private val condition: Condition) : Condition {
    override fun test(context: MobContext) = !condition.test(context)
}
