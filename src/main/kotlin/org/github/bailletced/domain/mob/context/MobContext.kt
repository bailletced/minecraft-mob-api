package org.github.bailletced.domain.mob.context

import org.bukkit.Location
import org.bukkit.entity.Entity

data class MobContext(
    val entity: Entity,
    val spawnLocation: Location,
    val maxRange: Long,
    var currentTarget: Entity?,
    val lastAttacker: Entity?,
)
