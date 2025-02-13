package org.github.bailletced.domain.mob.transition

import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.StateContext
import org.github.bailletced.domain.mob.state.MobState

interface TransitionState {
    val condition: Condition

    fun execute(context: StateContext): MobState
}
