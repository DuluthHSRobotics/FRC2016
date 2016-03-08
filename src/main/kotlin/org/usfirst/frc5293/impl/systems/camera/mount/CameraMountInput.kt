package org.usfirst.frc5293.impl.systems.camera.mount

import edu.wpi.first.wpilibj.buttons.Button
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.translations.camera.CameraEngine

class CameraMountInput(
        val x: () -> Double,
        val y: () -> Double,
        val originButton: Button)

class CameraMountControl(val input: CameraMountInput, val mount: CameraMountSubsystem) {

    val engine = CameraEngine(input.x, input.y)

    init {
        input.originButton.whenActive(SubsystemCommand(mount) {
            val point = engine.result
            mount.setOrigin(point.x, point.y)
        })
    }
}
