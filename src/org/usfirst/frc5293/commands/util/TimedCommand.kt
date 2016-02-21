package org.usfirst.frc5293.commands.util

import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.command.Command

abstract class TimedCommand protected constructor(private val seconds: Double) : Command() {
    private var timer: Timer? = null

    override fun initialize() {
        timer = Timer()
        timer!!.start()
    }

    override fun isFinished(): Boolean {
        return timer!!.hasPeriodPassed(seconds)
    }

    override fun end() {
        timer!!.stop()
    }

    override fun interrupted() {
        timer!!.start()
    }
}
