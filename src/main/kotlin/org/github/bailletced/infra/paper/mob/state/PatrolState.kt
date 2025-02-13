package org.github.bailletced.infra.paper.mob.state

import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.state.MobState
import org.github.bailletced.infra.paper.mob.behavior.PatrolBehavior

class PatrolState(
    override val behaviors: List<MobBehavior> = listOf(PatrolBehavior(200)),
    override val condition: Condition,
) : MobState()
