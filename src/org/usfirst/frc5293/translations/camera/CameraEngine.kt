package org.usfirst.frc5293.translations.camera

import org.usfirst.frc5293.Input
import org.usfirst.frc5293.translations.util.Point
import org.usfirst.frc5293.translations.util.StreamingTranslationEngine
import org.usfirst.frc5293.util.Initializable
import org.usfirst.frc5293.util.LazyByRequest
import org.usfirst.frc5293.util.LazySource
import org.usfirst.frc5293.util.lazyByRequest

object CameraEngine : StreamingTranslationEngine<Point>(CameraPipeline) {

    override val initial =
            Point(x = Input.camera.joystick.twist,
                  y = Input.camera.joystick.y)
}
