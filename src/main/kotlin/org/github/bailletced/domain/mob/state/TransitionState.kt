package org.github.bailletced.domain.mob.state

import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.StateContext

interface TransitionState {
    val condition: Condition

    fun execute(context: StateContext): MobState
}
