package org.usfirst.frc5293.commands.util

abstract class ActionCommand : EmptyCommand() {

    protected abstract fun action()

    override fun execute() {
        action()
        done()
    }
}

fun ActionCommand(action: () -> Unit) =
    object : ActionCommand() {
        override fun action() {
            action()
        }
    }