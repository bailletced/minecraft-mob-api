package org.github.bailletced.infra.paper.mob.state

import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.state.MobState
import org.github.bailletced.domain.mob.state.TransitionState
import org.github.bailletced.infra.paper.mob.behavior.PatrolBehavior
import org.github.bailletced.infra.paper.mob.transition.EntityNearLocationTransition
import org.koin.core.component.KoinComponent

class PatrolState() : MobState(), KoinComponent {
    override val behaviors: List<MobBehavior> = listOf(PatrolBehavior(200))
    override val transitions: List<TransitionState> = listOf(EntityNearLocationTransition(3.0))
}
