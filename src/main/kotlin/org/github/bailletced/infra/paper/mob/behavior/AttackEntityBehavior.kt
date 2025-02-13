package org.github.bailletced.infra.paper.mob.behavior

import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.context.MobContext

class AttackEntityBehavior(val target: Entity) : MobBehavior {
    override fun shouldExecute(context: MobContext): Boolean {
        val mob = context.entity as Mob

        if (!mob.hasLineOfSight(target)) {
            return false
        }

        context.currentTarget = target
        return true
    }

    override fun execute(context: MobContext) {
        val mob = context.entity as Mob
        val target = context.currentTarget as LivingEntity
        mob.target = target

        Bukkit.getConsoleSender().sendMessage("Executing attack entity behavior ${mob.target}")

        mob.pathfinder.moveTo(target)
        if (mob.location.distance(target.location) <= context.attackMaxRange) {
            mob.attack(target)
        }
    }

    override fun getPriority(): Int = 50
}
