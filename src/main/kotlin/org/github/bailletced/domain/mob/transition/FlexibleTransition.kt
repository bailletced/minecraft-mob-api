package org.github.bailletced.domain.mob.transition

import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.StateContext
import org.github.bailletced.domain.mob.state.MobState

class FlexibleTransition(
    override val condition: Condition,
    private val targetStateFactory: (StateContext) -> MobState?,
) : TransitionState {
    override fun execute(context: StateContext): MobState {
        return targetStateFactory(context) ?: context.currentState
    }
}
