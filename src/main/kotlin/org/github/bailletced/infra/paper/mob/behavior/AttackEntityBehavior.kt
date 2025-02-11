package org.github.bailletced.infra.paper.mob.behavior

import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.context.MobContext

class AttackEntityBehavior(val target: Entity) : MobBehavior {
    override fun shouldExecute(context: MobContext): Boolean {
        val mob = context.entity as Mob

        if (!mob.hasLineOfSight(target) || context.maxRange < mob.location.distance(target.location)) {
            return false
        }

        context.currentTarget = target
        return true
    }

    override fun execute(context: MobContext) {
        val mob = context.entity as Mob
        mob.target = target as LivingEntity
    }

    override fun getPriority(): Int = 50
}
