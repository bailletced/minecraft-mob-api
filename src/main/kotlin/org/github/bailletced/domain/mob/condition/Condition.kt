package org.github.bailletced.domain.mob.condition

import org.github.bailletced.domain.mob.context.StateContext

interface Condition {
    fun test(context: StateContext): Boolean

    infix fun and(other: Condition): Condition = AndCondition(this, other)

    infix fun or(other: Condition): Condition = OrCondition(this, other)

    operator fun not(): Condition = NotCondition(this)
}
