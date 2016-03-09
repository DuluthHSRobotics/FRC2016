package org.usfirst.frc5293.impl.systems.shooter.kicker

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.ServoSubsystem

class ShooterKickerSubsystem(kicker: ShooterKickerDevice) : EmptySubsytem(), ServoSubsystem {

    private val servo by lazy { kicker.servo }

    override var value: Double
        get() = servo.get()
        set(x) {
            servo.set(x)
        }

    override var angle: Double
        get() = servo.angle
        set(angle) {
            servo.angle = angle
        }
}