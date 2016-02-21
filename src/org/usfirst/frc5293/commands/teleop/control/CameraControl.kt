package org.usfirst.frc5293.commands.teleop.control

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.ContinuousCommand
import org.usfirst.frc5293.translations.camera.CameraEngine

class CameraControl : ContinuousCommand() {

    init {
        requires(Subsystems.camera)
    }

    override fun execute() {
        val result = CameraEngine.result

        SmartDashboard.putNumber("Camera X Rotation", result.x)
        SmartDashboard.putNumber("Camera Y Rotation", result.y)

        Subsystems.camera.positionRelative(result.x, result.y)
    }
}
