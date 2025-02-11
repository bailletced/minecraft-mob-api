package org.github.bailletced.domain.mob.condition

import org.github.bailletced.domain.mob.context.MobContext

class OrCondition(
    private val first: Condition,
    private val second: Condition,
) : Condition {
    override fun test(context: MobContext) = first.test(context) || second.test(context)
}
