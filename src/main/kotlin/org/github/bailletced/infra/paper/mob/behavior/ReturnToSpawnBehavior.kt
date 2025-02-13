package org.github.bailletced.infra.paper.mob.behavior

import org.bukkit.Bukkit
import org.bukkit.entity.Mob
import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.context.MobContext
import org.github.bailletced.infra.paper.mob.condition.IsArroundSpawnCondition

class ReturnToSpawnBehavior() : MobBehavior {
    override fun shouldExecute(context: MobContext): Boolean {
        return !IsArroundSpawnCondition(1).test(context)
    }

    override fun execute(context: MobContext) {
        Bukkit.getConsoleSender().sendMessage("Executing return to spawn")

        val mob = context.entity as Mob
        mob.pathfinder.moveTo(context.spawnLocation)
    }

    override fun getPriority(): Int = 100
}
