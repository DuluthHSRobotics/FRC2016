package org.usfirst.frc5293.translations.driving

import org.usfirst.frc5293.translations.util.OperationPipeline
import org.usfirst.frc5293.translations.util.TankDrivingState

object JoystickDrivePipeline : OperationPipeline<TankDrivingState> {

//    override val operations = listOf(
//            ::applySystemDisabling
//            ::applyAxisDisabling
//            ::applyAxisLocking
//            ::applyQuadScaling
//            ::applyDefaultScaling
//            ::applySensitiveScaling
//            ::applyInversions
//    )

    override val operations: List<(TankDrivingState) -> TankDrivingState> =
            emptyList()
}

