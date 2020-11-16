package plugin.ai.minigamebots.pestcontrol

import core.game.node.Node
import core.game.world.map.Direction
import plugin.activity.pestcontrol.PestControlHelper
import plugin.activity.pestcontrol.PestControlHelper.getMyPestControlSession2
import java.util.*
import plugin.activity.pestcontrol.PestControlHelper.GATE_ENTRIES
import plugin.activity.pestcontrol.PestControlHelper.Portals_AttackableI
class CombatStateIntermediate(val bot: PestControlTestBot2) {
    private val Random = Random()
    val randomtype = Random().nextInt(100)

    //public CombatState2(PestControlTestBot2 pestControlTestBot2) =
    fun goToPortals() {
        bot.customState = "I'm at portals."
        val gate = bot.getClosestNodeWithEntry(75, GATE_ENTRIES)
        val portalattack = Portals_AttackableI.random()
        var portal = listOf(
                getMyPestControlSession2(bot).portals[0],
                getMyPestControlSession2(bot).portals[1],
                getMyPestControlSession2(bot).portals[2],
                getMyPestControlSession2(bot).portals[3]).random()


        if (bot.justStartedGame && Random().nextInt(2) == 0) {
            return
        }

        if (bot.justStartedGame || gate == null && portal == null) {
            bot.customState = "Walking randomly"
            bot.justStartedGame = false
            bot.randomWalkAroundPoint(PestControlHelper.getMyPestControlSession2(bot).squire.location, 5)
            bot.movetimer = Random.nextInt(7) + 6
            return
        }

        if (gate != null) {
            bot.customState = "Interacting gate ID " + gate.id
            bot.interact(gate)
            bot.openedGate = true
            if (Random.nextInt(4) == 1 && randomtype < 50) {
                bot.movetimer = Random.nextInt(3) + 1
            }
            return
        }

        if (portal != null) {
            bot.customState = "Walking to portals"
            bot.randomWalkAroundPoint(portal.location, 5)
            bot.movetimer = Random.nextInt(5) + 5
        }
        bot.customState = "Absolutely nothing. Everything is dead"
    }

    fun fightNPCs() {
        bot.customState = "Fight NPCs"
        //Npc Combat
        if (bot.tick == 0) {
            if (!bot.inCombat()) bot.AttackNpcsInRadius(10)
            bot.tick = 10
        } else bot.tick--
        bot.eat(379)

        if (!bot.inCombat())
        { if (bot.combatMoveTimer <= 0)
            { if (bot.FindTargets(bot, 10) == null)
                bot.randomWalk(5, 5);
                bot.combatMoveTimer = 5;
            }
        }
    }

     fun goToEastPortals() {
        bot.customState = "Go to east portals"
        val easternGate = bot.getClosestNodeWithEntryAndDirection(75, 14233, Direction.SOUTH)
        val easternPortal: Node? = PestControlHelper.getMyPestControlSession2(bot).portals[1]
        if (easternGate != null) {
            bot.interact(easternGate)
        } else if (easternPortal != null) {
            bot.walkToPosSmart(easternPortal.location)
        } else {
            bot.customState = "Everything is null!"
        }
    }
}