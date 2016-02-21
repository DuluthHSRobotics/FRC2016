package org.usfirst.frc5293.translations.camera

import org.usfirst.frc5293.Input
import org.usfirst.frc5293.translations.util.Point
import org.usfirst.frc5293.translations.util.StreamingTranslationEngine

object CameraEngine : StreamingTranslationEngine<Point>(CameraPipeline) {

    private val input = Input.camera

    override val initial =
            Point(x = input.joystick.twist,
                  y = input.joystick.y)

}
