package org.usfirst.frc5293.framework.commands

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.CommandGroup
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.command.WaitCommand

abstract class ScheduledCommandGroup : CommandGroup() {

    private val ctx = CommandScheduler.Ctx(onRequire = { this.requires(it) })

    protected fun schedule(block: CommandScheduler.() -> Unit) = this.schedule(ctx, block)
}

class CommandScheduler(private val group: CommandGroup, private val ctx: Ctx) {

    class Ctx(val onRequire: (Subsystem) -> Unit)

    private sealed class Element(val command: Command) {
        class Sync(command: Command) : Element(command)
        class Async(command: Command) : Element(command)
    }

    //

    private var requirements: List<Subsystem> = emptyList()

    private var sequence: List<Element> = emptyList()

    private var isScheduled = false

    fun requires(subsystem: Subsystem) {
        requirements += subsystem
    }

    fun await(action: () -> Unit) {
        sequence += Element.Sync(ActionCommand(action))
    }

    fun delay(seconds: Double) {
        await { WaitCommand(seconds) }
    }

    fun schedule() {
        require(!isScheduled, { -> "Can only schedule a sequence of commands once" })
        isScheduled = true

        requirements.forEach { ctx.onRequire(it) }

        sequence.forEach {
            when (it) {
                is Element.Sync -> group.addSequential(it.command)
                is Element.Async -> group.addParallel(it.command)
            }
        }

        // note that the `CommandGroup` knows when it's finished
    }
}

fun <T : CommandGroup> T.schedule(ctx: CommandScheduler.Ctx, block: CommandScheduler.() -> Unit) {
    val scheduler = CommandScheduler(this, ctx)
    block(scheduler)
    scheduler.schedule()
}