package org.github.bailletced.infra.paper.mob.state

import org.bukkit.entity.Entity
import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.state.MobState
import org.github.bailletced.domain.mob.state.TransitionState
import org.github.bailletced.infra.paper.mob.behavior.AttackEntityBehavior

class CombatState(
    private val target: Entity,
    override val behaviors: List<MobBehavior> =
        listOf(
            AttackEntityBehavior(target),
        ),
    // TODO : implémenter les transitions
    override val transitions: List<TransitionState> =
        listOf(),
) : MobState()
