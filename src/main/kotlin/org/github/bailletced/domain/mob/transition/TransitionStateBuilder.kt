package org.github.bailletced.domain.mob.transition

import org.github.bailletced.domain.mob.condition.AlwaysTrueCondition
import org.github.bailletced.domain.mob.condition.Condition
import org.github.bailletced.domain.mob.context.StateContext
import org.github.bailletced.domain.mob.state.MobState

class TransitionStateBuilder {
    // Stockage temporaire pour la construction
    private var condition: Condition? = null
    private var targetStateFactory: (StateContext) -> MobState? = { null }

    // Méthode pour définir la condition
    fun withCondition(condition: Condition) =
        apply {
            this.condition = condition
        }

    // Méthode pour définir l'état cible
    fun toState(stateFactory: (StateContext) -> MobState) =
        apply {
            this.targetStateFactory = stateFactory
        }

    // Création de la transition finale
    fun build(): TransitionState =
        FlexibleTransition(
            condition ?: AlwaysTrueCondition(),
            targetStateFactory,
        )
}
