package org.github.bailletced.infra.paper.mob.factory

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import org.github.bailletced.domain.mob.condition.HasLastAttackerCondition
import org.github.bailletced.domain.mob.condition.HasTargetCondition
import org.github.bailletced.domain.mob.context.MobContext
import org.github.bailletced.domain.mob.context.StateContext
import org.github.bailletced.domain.mob.state.MachineState
import org.github.bailletced.domain.mob.state.MobState
import org.github.bailletced.domain.mob.transition.buildTransitions
import org.github.bailletced.infra.paper.mob.behavior.AttackEntityBehavior
import org.github.bailletced.infra.paper.mob.behavior.ClearTargetBehavior
import org.github.bailletced.infra.paper.mob.behavior.PatrolBehavior
import org.github.bailletced.infra.paper.mob.behavior.ReturnToSpawnBehavior
import org.github.bailletced.infra.paper.mob.condition.EntityNearSpawnCondition
import org.github.bailletced.infra.paper.mob.condition.IsArroundSpawnCondition
import org.github.bailletced.infra.paper.mob.state.PatrolState

class TotoMobFactory(private val plugin: JavaPlugin) {
    fun createToto(
        world: World,
        location: Location,
    ): Entity {
        val entity = world.spawnEntity(location, EntityType.ZOMBIE)
        val toto = entity as Mob

        Bukkit.getMobGoals().removeAllGoals(toto)
        val mobContext =
            MobContext(
                entity = toto as Entity,
                spawnLocation = location,
                attackMaxRange = 1.5,
                targetMaxRange = 10.0,
                currentTarget = null,
                lastAttacker = null,
            )

        val patrolState =
            PatrolState(
                behaviors = listOf(PatrolBehavior(200), ClearTargetBehavior()),
                condition = EntityNearSpawnCondition(3.0).not() and IsArroundSpawnCondition(30).not(),
            )

        val returnToSpawnState =
            MobState(
                behaviors = listOf(ReturnToSpawnBehavior(), ClearTargetBehavior()),
                condition = IsArroundSpawnCondition(1).not(),
            )

        val transitions =
            buildTransitions {
                // Transition vers l'état de combat
                transition {
                    withCondition(
                        EntityNearSpawnCondition(3.0) and HasTargetCondition().not(),
                    )
                    toState { context ->
                        val nearestPlayer =
                            location.getNearbyEntities(3.0, 3.0, 3.0)
                                .filterIsInstance<LivingEntity>()
                                .firstOrNull { entity ->
                                    entity.uniqueId !=
                                        context.mobContext.entity
                                            .uniqueId
                                }
                        if (nearestPlayer != null) {
                            Bukkit.getConsoleSender().sendMessage("Transitioning to attack")
                            MobState(
                                behaviors = listOf(AttackEntityBehavior(nearestPlayer)),
                                condition = EntityNearSpawnCondition(3.0),
                            )
                        } else {
                            Bukkit.getConsoleSender().sendMessage("Transitioning to patrol")
                            patrolState
                        }
                    }
                }

                // Transition arrêter d'attaquer
                transition {
                    withCondition(
                        IsArroundSpawnCondition(10).not() and
                            HasLastAttackerCondition().not(),
                    )
                    toState {
                        Bukkit.getConsoleSender().sendMessage(
                            "STOP ATTACK - Transitioning to returnToSpawnState - " +
                                "SOFT",
                        )
                        returnToSpawnState
                    }
                }

                transition {
                    withCondition(
                        HasTargetCondition() and IsArroundSpawnCondition(10).not() and
                            HasLastAttackerCondition(),
                    )
                    toState {
                        Bukkit.getConsoleSender().sendMessage(
                            "STOP ATTACK - Transitioning to returnToSpawnState - " +
                                "HARD",
                        )
                        returnToSpawnState
                    }
                }

                transition {
                    withCondition(
                        IsArroundSpawnCondition(3),
                    )
                    toState {
                        Bukkit.getConsoleSender().sendMessage(
                            "I am IN SPAWN - Transitioning to patrolState - ",
                        )
                        patrolState
                    }
                }
            }

        val stateContext =
            StateContext(
                mobContext = mobContext,
                currentState = patrolState,
                transitions = transitions,
            )

        val stateMachine = MachineState(stateContext)

        // Démarrage du cycle de mise à jour
        object : BukkitRunnable() {
            override fun run() {
                if (entity.isDead) {
                    cancel()
                    return
                }
                stateMachine.update()
            }
        }.runTaskTimer(plugin, 0L, 10L)

        return entity
    }
}
