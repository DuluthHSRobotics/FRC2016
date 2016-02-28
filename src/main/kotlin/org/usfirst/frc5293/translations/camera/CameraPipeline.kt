package org.usfirst.frc5293.translations.camera

import org.usfirst.frc5293.translations.operations.applyInputScaling
import org.usfirst.frc5293.translations.operations.applyInverting
import org.usfirst.frc5293.translations.operations.applyOutputLimit
import org.usfirst.frc5293.translations.operations.applyQuadScaling
import org.usfirst.frc5293.translations.util.OperationPipeline
import org.usfirst.frc5293.translations.util.Point

object CameraPipeline : OperationPipeline<Point> {

    override val operations: List<(Point) -> Point> = listOf(
            ::applyInverting,
            ::applyQuadScaling,
            ::applyInputScaling,
            ::applyOutputLimit
    )
}
