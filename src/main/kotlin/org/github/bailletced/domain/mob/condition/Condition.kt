package org.github.bailletced.domain.mob.condition

import org.github.bailletced.domain.mob.context.MobContext

interface Condition {
    fun test(context: MobContext): Boolean

    infix fun and(other: Condition): Condition = AndCondition(this, other)

    infix fun or(other: Condition): Condition = OrCondition(this, other)

    operator fun not(): Condition = NotCondition(this)
}
