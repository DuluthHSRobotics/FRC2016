package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.command.Scheduler
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainControl

object Controls : LazyGroup() {

    val drivetain by lazyByRequest {
        DrivetrainControl()
    }

    val all by lazyByRequest {
        listOf(drivetain)
    }

    override fun init() {
        super.init()
    }

    fun startAll() {
        all.forEach { Scheduler.getInstance().add(it) }
    }

    fun cancelAll() {
        all.forEach { it.cancel() }
    }
}