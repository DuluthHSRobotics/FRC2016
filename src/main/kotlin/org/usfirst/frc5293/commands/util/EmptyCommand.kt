package org.usfirst.frc5293.commands.util

import edu.wpi.first.wpilibj.command.Command

/**
 * An empty command with all the methods implemented with stubs
 */
open class EmptyCommand : Command() {
    private var _isFinished = false

    override fun isFinished(): Boolean {
        return _isFinished
    }

    override fun initialize() {
    }

    override fun execute() {
    }

    override fun interrupted() {
    }

    fun done() {
        _isFinished = true
    }

    override fun end() {
    }
}
