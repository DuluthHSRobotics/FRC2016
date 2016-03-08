package org.usfirst.frc5293.impl.systems.shooter.lifter

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem

class ShooterLifterSubsystem(val lifter: ShooterLifterDevice) : EmptySubsytem(), MotorSubsystem {

    override var power: Double
        get() = lifter.motor.get()
        set(value) {
            SmartDashboard.putNumber("Shooter Lift", value)
            return lifter.motor.set(value)
        }
}