package org.usfirst.frc5293.framework.translations.camera

import org.usfirst.frc5293.framework.translations.operations.applyInputScaling
import org.usfirst.frc5293.framework.translations.operations.applyInverting
import org.usfirst.frc5293.framework.translations.operations.applyOutputLimit
import org.usfirst.frc5293.framework.translations.operations.applyQuadScaling
import org.usfirst.frc5293.framework.translations.util.OperationPipeline
import org.usfirst.frc5293.framework.translations.util.Point

object CameraPipeline : OperationPipeline<Point> {

    override val operations: List<(Point) -> Point> = listOf(
            ::applyInverting,
            ::applyQuadScaling,
            ::applyInputScaling,
            ::applyOutputLimit
    )
}
