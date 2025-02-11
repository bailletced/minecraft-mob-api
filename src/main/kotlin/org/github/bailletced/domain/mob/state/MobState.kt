package org.github.bailletced.domain.mob.state

import org.github.bailletced.domain.mob.behavior.MobBehavior

abstract class MobState {
    abstract val behaviors: List<MobBehavior>
    abstract val transitions: List<TransitionState>
}
