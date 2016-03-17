package org.usfirst.frc5293.framework.util

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler

abstract class LazyControlGroup() : LazyGroup(), Logging {

    abstract val controls: List<*>

    override fun init() {
        super.init()
        initCommands()
    }

    private fun initCommands() {
        controls.forEach {
            if (it is Initializable) {
                it.init()
            }

            if (it is Command) {
                Scheduler.getInstance().add(it)
            }
        }
    }

    fun startAll() {
        controls.forEach {
            if (it is Command) {
                it.start()
            }
        }

        logger.info("Started ${controls.count()} commands")
    }

    fun cancelAll() {
        controls.forEach {
            when (it) {
                is Command ->
                    it.cancel()
            }
        }

        logger.info("Canceled ${controls.count()} commands")
    }
}