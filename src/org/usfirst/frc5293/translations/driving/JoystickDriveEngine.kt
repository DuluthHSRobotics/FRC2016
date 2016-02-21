package org.usfirst.frc5293.translations.driving

import org.usfirst.frc5293.Input
import org.usfirst.frc5293.translations.util.StreamingTranslationEngine
import org.usfirst.frc5293.translations.util.TankDrivingState

object JoystickDriveEngine : StreamingTranslationEngine<TankDrivingState>(JoystickDrivePipeline) {

    private val input = Input.drivetrain

    override val initial = TankDrivingState(
            left = input.left.y,
            right = input.right.y
    )
}
