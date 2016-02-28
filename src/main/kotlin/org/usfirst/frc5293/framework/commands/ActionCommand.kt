package org.usfirst.frc5293.framework.commands

abstract class ActionCommand : EmptyCommand() {

    protected abstract fun action()

    final override fun execute() {
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