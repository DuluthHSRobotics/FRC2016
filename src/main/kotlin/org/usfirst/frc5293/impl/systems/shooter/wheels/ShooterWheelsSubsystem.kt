package org.usfirst.frc5293.impl.systems.shooter.wheels

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.SpeedControllerSubsystem

class ShooterWheelsSubsystem(wheels: ShooterWheelsDevice) : EmptySubsytem(), SpeedControllerSubsystem {

    private val controller by lazy { wheels.controller }

    override var power: Double
        get() = controller.get()
        set(x) {
            controller.set(x)
        }
}

