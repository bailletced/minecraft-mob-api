package org.github.bailletced.domain.mob.state

import org.github.bailletced.domain.mob.context.StateContext

class MachineState(
    private val context: StateContext,
) {
    fun update() {
        // Mise à jour du contexte des conditions
//        context.conditions.update(context)

        // Vérification des transitions
        val currentState = context.currentState
        for (transition in currentState.transitions) {
            if (transition.condition.test(context)) {
                context.currentState = transition.execute(context)
                break
            }
        }

        // Exécution des comportements de l'état actuel
        for (behavior in context.currentState.behaviors) {
            if (behavior.shouldExecute(context.mobContext)) {
                behavior.execute(context.mobContext)
                break
            }
        }
    }
}
