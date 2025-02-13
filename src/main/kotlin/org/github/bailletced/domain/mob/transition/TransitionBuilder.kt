package org.github.bailletced.domain.mob.transition

class TransitionsBuilder {
    private val transitions = mutableListOf<TransitionState>()

    // Permet d'ajouter une transition via un bloc de configuration
    fun transition(block: TransitionStateBuilder.() -> Unit) {
        transitions.add(TransitionStateBuilder().apply(block).build())
    }

    fun build(): List<TransitionState> = transitions.toList()
}

// Fonction d'extension pour créer le DSL
fun buildTransitions(block: TransitionsBuilder.() -> Unit): List<TransitionState> = TransitionsBuilder().apply(block).build()
