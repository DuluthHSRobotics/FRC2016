package org.usfirst.frc5293.framework.translations.driving

import org.usfirst.frc5293.framework.translations.util.OperationPipeline
import org.usfirst.frc5293.framework.translations.util.TankDrivingState

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

