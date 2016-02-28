package org.usfirst.frc5293.impl.systems.shooter.lift

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem

class ShooterLiftSubsystem(val lift: ShooterLiftDevice) : EmptySubsytem(), MotorSubsystem {

    override var power: Double
        get() = lift.motor.get()
        set(value) {
            SmartDashboard.putNumber("Shooter Lift", value)
            return lift.motor.set(value)
        }
}