package org.usfirst.frc5293.commands.teleop.events

import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.SubsystemCommand
import org.usfirst.frc5293.translations.camera.CameraEngine

class CameraSetOriginOnPressed : SubsystemCommand(Subsystems.camera) {

    override fun action() {
        val point = CameraEngine.result
        Subsystems.camera.setOrigin(point.x, point.y)
    }
}
