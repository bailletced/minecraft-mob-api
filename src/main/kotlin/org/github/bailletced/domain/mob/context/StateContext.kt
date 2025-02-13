package org.github.bailletced.domain.mob.context

import org.github.bailletced.domain.mob.state.MobState
import org.github.bailletced.domain.mob.transition.TransitionState

data class StateContext(
    val mobContext: MobContext,
    val transitions: List<TransitionState> = listOf(),
    var currentState: MobState,
)
