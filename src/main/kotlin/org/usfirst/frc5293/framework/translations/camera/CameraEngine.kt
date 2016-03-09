package org.usfirst.frc5293.framework.translations.camera

import org.usfirst.frc5293.framework.translations.util.Point
import org.usfirst.frc5293.framework.translations.util.StreamingTranslationEngine

class CameraEngine(x: () -> Double, y: () -> Double) : StreamingTranslationEngine<Point>(CameraPipeline()) {

    override val initial =
            Point(x = x(),
                  y = y())
}
