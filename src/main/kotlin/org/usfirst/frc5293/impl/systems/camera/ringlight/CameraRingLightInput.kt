package org.usfirst.frc5293.impl.systems.camera.ringlight

import edu.wpi.first.wpilibj.buttons.Button
import org.usfirst.frc5293.framework.commands.SubsystemCommand

class CameraRingLightControl(val button: Button, val ringLight: CameraRingLightSubsystem) {
    init {
        button.whenPressed(SubsystemCommand(ringLight) {
            ringLight.swap()
        })
    }
}