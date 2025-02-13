package org.github.bailletced.domain.mob.context

import org.bukkit.Location
import org.bukkit.entity.Entity

data class MobContext(
    val entity: Entity,
    val spawnLocation: Location,
    val targetMaxRange: Double,
    val attackMaxRange: Double,
    var currentTarget: Entity?,
    val lastAttacker: Entity?,
)
