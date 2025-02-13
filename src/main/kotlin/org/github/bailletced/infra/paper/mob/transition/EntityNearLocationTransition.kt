// package org.github.bailletced.infra.paper.mob.transition
//
// import org.github.bailletced.domain.mob.condition.Condition
// import org.github.bailletced.domain.mob.context.StateContext
// import org.github.bailletced.domain.mob.state.MobState
// import org.github.bailletced.domain.mob.transition.TransitionState
// import org.github.bailletced.infra.paper.mob.condition.EntityNearLocationCondition
//
// class EntityNearLocationTransition(
//    private val distance: Double = 3.0,
// ) : TransitionState {
//    override val condition: Condition = EntityNearLocationCondition(distance)
//
//    override fun execute(context: StateContext): MobState {
// //        Bukkit.getConsoleSender().sendMessage("Executing entity near location transition")
// //
// //        val location = context.mobContext.spawnLocation
// //
// //        val target =
// //            location.getNearbyEntities(distance, distance, distance)
// //                .firstOrNull { entity -> entity.uniqueId != context.mobContext.entity.uniqueId }
// //
// //        if (target != null) {
// //            Bukkit.getConsoleSender().sendMessage("transitioning to CombatState")
// //            return CombatState(target)
// //        } else {
// //            Bukkit.getConsoleSender().sendMessage("transitioning to PatrolState")
// //            return PatrolState()
// //        }
//    }
// }
