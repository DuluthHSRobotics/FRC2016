package org.usfirst.frc5293.impl.systems.camera.mount

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.translations.camera.CameraEngine

class CameraMountInput(val joystick: Joystick, val mount: CameraMountSubsystem) {
    private val originButton: JoystickButton

    init {
        this.originButton = JoystickButton(this.joystick, 1 /* Trigger */)
        this.originButton.whenActive(CameraSetOriginOnPressed(mount))
    }
}

class CameraSetOriginOnPressed(private val mount: CameraMountSubsystem) : SubsystemCommand(mount) {

    override fun action() {
        val point = CameraEngine.result
        mount.setOrigin(point.x, point.y)
    }
}

class CameraMountControl(mount: CameraMountSubsystem) : SubsystemCommand(mount) {

    override fun action() {
        //        val result = CameraEngine.result
        //
        //        SmartDashboard.putNumber("Camera X Rotation", result.x)
        //        SmartDashboard.putNumber("Camera Y Rotation", result.y)
        //
        //        Subsystems.camera.positionRelative(result.x, result.y)
    }
}
