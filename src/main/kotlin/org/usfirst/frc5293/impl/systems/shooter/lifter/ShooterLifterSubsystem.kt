package org.usfirst.frc5293.impl.systems.shooter.lifter

import edu.wpi.first.wpilibj.SpeedController
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem
import org.usfirst.frc5293.framework.util.Logging

class ShooterLifterSubsystem(val lifter: SpeedController) : EmptySubsytem(), MotorSubsystem, Logging {

    init {
        logger.info("AHHAHAHAHA SHOOTER ELEVATION")
    }

    override var power: Double
        get() {
            val x = lifter.get()
            SmartDashboard.putNumber("Shooter Lift", x)
            return x
        }

        set(value) {
            SmartDashboard.putNumber("Shooter Lift", value)
            return lifter.set(value)
        }
}