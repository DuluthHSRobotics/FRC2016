package org.usfirst.frc5293.impl.systems.camera.mount

import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.util.math.limit

class CameraMountSubsystem(private val camera: CameraMountDevice?) : EmptySubsytem() {

    var originX = 0.5
        set(originX) {
            this.originX = originX.limit(0.0, 1.0)
        }

    var originY = 0.5
        set(originY) {
            this.originY = originY.limit(0.0, 1.0)
        }

    /**
     * Positions the camera to the value of rotation along the power-axis and the y-axis

     * @param xRotation the positionAbsolute of rotation along the power-axis in the range of [0.0,1.0]
     * *
     * @param yRotation the positionAbsolute of rotation along the y-axis in the range of [0.0,1.0]
     */
    fun positionAbsolute(xRotation: Double, yRotation: Double) {
        val limitedX = xRotation.limit(0.0, 1.0)
        val limitedY = yRotation.limit(0.0, 1.0)

        camera?.sideServo?.set(limitedX)
        camera?.topServo?.set(limitedY)
    }

    fun positionRelative(rotationX: Double, rotationY: Double) {
        // Make the rotation values relative to 0.5 so that left is [0.0, 0.5) and right is (0.5, 0.0]
        val limitedRotationX = rotationX.limit(0.0, 1.0)
        val limitedRotationY = rotationY.limit(0.0, 1.0)

        val resultX = getRelativeOffsetResult(limitedRotationX, originX)
        val resultY = getRelativeOffsetResult(limitedRotationY, originY)

        positionAbsolute(resultX, resultY)
    }

    private fun getRelativeOffsetResult(rotation: Double, origin: Double): Double {
        val min = 0.0
        val max = 1.0
        val center = (max - min) / 2

        val limitedRotation = rotation.limit(min, max)
        val limitedOrigin = origin.limit(min, max)

        if (limitedRotation == center) {
            return limitedOrigin
        } else if (limitedRotation < center) {
            val percent = max - limitedRotation / center
            return limitedOrigin - percent * limitedOrigin
        } else {
            // rotation > center
            val p = (limitedRotation - center) / center
            return limitedOrigin + p * (1 - limitedOrigin)
        }
    }

    fun setOrigin(x: Double, y: Double) {
        originX = x
        originY = y
    }
}

