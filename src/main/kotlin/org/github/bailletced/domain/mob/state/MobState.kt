package org.github.bailletced.domain.mob.state

import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.condition.AlwaysTrueCondition
import org.github.bailletced.domain.mob.condition.Condition

open class MobState(
    open val behaviors: List<MobBehavior> = listOf(),
    open val condition: Condition = AlwaysTrueCondition(),
)
