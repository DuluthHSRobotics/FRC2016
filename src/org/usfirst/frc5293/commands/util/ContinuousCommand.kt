package org.usfirst.frc5293.commands.util

/**
 * An empty command that will never finish
 */
open class ContinuousCommand : EmptyCommand() {
    override fun isFinished(): Boolean {
        return false
    }
}
