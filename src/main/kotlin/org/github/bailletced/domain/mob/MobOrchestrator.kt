package org.github.bailletced.domain.mob

import org.github.bailletced.domain.mob.behavior.MobBehavior
import org.github.bailletced.domain.mob.context.MobContext
import java.util.PriorityQueue

class MobOrchestrator(private val context: MobContext) {
    private val behaviors =
        PriorityQueue<MobBehavior> { a, b ->
            b.getPriority() - a.getPriority()
        }

    fun addBehavior(behavior: MobBehavior) {
        behaviors.add(behavior)
    }

    fun tick() {
        for (behavior in behaviors) {
            if (behavior.shouldExecute(context)) {
                behavior.execute(context)
                break
            }
        }
    }
}
