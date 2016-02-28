package org.usfirst.frc5293.framework.translations.camera

import org.usfirst.frc5293.framework.translations.util.Point
import org.usfirst.frc5293.framework.translations.util.StreamingTranslationEngine
import org.usfirst.frc5293.impl.Inputs

object CameraEngine : StreamingTranslationEngine<Point>(CameraPipeline) {

    override val initial =
            Point(x = Inputs.camera.joystick.twist,
                  y = Inputs.camera.joystick.y)
}
