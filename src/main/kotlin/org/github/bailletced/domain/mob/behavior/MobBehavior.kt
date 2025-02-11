package org.github.bailletced.domain.mob.behavior

import org.github.bailletced.domain.mob.context.MobContext

interface MobBehavior {
    fun shouldExecute(context: MobContext): Boolean

    fun execute(context: MobContext)

    fun getPriority(): Int
}
