package org.usfirst.frc5293

import edu.wpi.first.wpilibj.Servo
import edu.wpi.first.wpilibj.Victor
import org.usfirst.frc5293.devices.*

/**
 * The Devices is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
object Devices {

    val drivetrain by lazy { Drivetrain() }

    val camera by lazy { Camera() }

    val cameraRingLight by lazy { CameraRingLight() }

    val shooter by lazy { Shooter(
            leftMotor = Victor(8),
            rightMotor = Victor(9)
    ) }

    val lifter by lazy { Lifter() }

    val shooterKicker by lazy { ShooterKicker(Servo(7)) }
}
