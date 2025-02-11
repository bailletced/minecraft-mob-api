package org.github.bailletced.domain.mob.context

import org.bukkit.Location
import org.github.bailletced.domain.mob.state.MobState

data class StateContext(
    val mobContext: MobContext,
    val spawnLocation: Location,
    var currentState: MobState,
)
