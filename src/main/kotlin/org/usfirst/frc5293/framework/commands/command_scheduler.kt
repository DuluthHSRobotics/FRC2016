package org.usfirst.frc5293.framework.commands

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.CommandGroup
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.command.WaitCommand
import org.slf4j.LoggerFactory

abstract class ScheduledCommandGroup : CommandGroup() {

    private val ctx = CommandScheduler.Ctx(onRequire = { this.requires(it) })

    protected fun schedule(block: CommandScheduler.() -> Unit) = this.schedule(ctx, block)
}

class DebugWaitCommand(val timeout: Double) : WaitCommand(timeout) {

    private final val logger = LoggerFactory.getLogger(DebugWaitCommand::class.java)

    override fun initialize() {
        super.initialize()
        logger.debug("Started waiting for $timeout seconds...")
    }

    override fun end() {
        super.end()
        logger.debug("Finished waiting for $timeout seconds.")
    }
}

class CommandScheduler(private val group: CommandGroup, private val ctx: Ctx) {

    private final val logger = LoggerFactory.getLogger(CommandScheduler::class.java)

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

    fun awaitIgnored(action: () -> Unit) {
        sequence += Element.Sync(ActionCommand(action))
    }

    fun await(action: () -> Command) {
        sequence += Element.Sync(action())
    }

    fun delay(seconds: Double) {
        await { DebugWaitCommand(seconds) }
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

            logger.debug("Scheduled `$it`")
        }

        logger.debug("Scheduled ${sequence.count()} command elements")

        // note that the `CommandGroup` knows when it's finished
    }
}

fun <T : CommandGroup> T.schedule(ctx: CommandScheduler.Ctx, block: CommandScheduler.() -> Unit) {
    val scheduler = CommandScheduler(this, ctx)
    block(scheduler)
    scheduler.schedule()
}