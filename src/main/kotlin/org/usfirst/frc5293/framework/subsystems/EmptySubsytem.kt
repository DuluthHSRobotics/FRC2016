package org.usfirst.frc5293.framework.subsystems

import edu.wpi.first.wpilibj.command.Subsystem

abstract class EmptySubsytem : Subsystem() {
    override fun initDefaultCommand() {
        defaultCommand = null
    }
}