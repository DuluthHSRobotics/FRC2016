package org.usfirst.frc5293.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.commands.teleop.control.CameraControl
import org.usfirst.frc5293.util.MathUtil

class Camera : Subsystem() {

    var originX = 0.5
        set(originX) {
            this.originX = MathUtil.limit(originX, 0.0, 1.0)
        }

    var originY = 0.5
        set(originY) {
            this.originY = MathUtil.limit(originY, 0.0, 1.0)
        }

    override fun initDefaultCommand() {
        defaultCommand = CameraControl()
    }

    /**
     * Positions the camera to the value of rotation along the power-axis and the y-axis

     * @param xRotation the positionAbsolute of rotation along the power-axis in the range of [0.0,1.0]
     * *
     * @param yRotation the positionAbsolute of rotation along the y-axis in the range of [0.0,1.0]
     */
    fun positionAbsolute(xRotation: Double, yRotation: Double) {
        val limitedX = MathUtil.limit(xRotation, 0.0, 1.0)
        val limitedY = MathUtil.limit(yRotation, 0.0, 1.0)

        Devices.camera.sideServo.set(limitedX)
        Devices.camera.topServo.set(limitedY)
    }

    fun positionRelative(rotationX: Double, rotationY: Double) {
        // Make the rotation values relative to 0.5 so that left is [0.0, 0.5) and right is (0.5, 0.0]
        val limitedRotationX = MathUtil.limit(rotationX, 0.0, 1.0)
        val limitedRotationY = MathUtil.limit(rotationY, 0.0, 1.0)

        val resultX = getRelativeOffsetResult(limitedRotationX, originX)
        val resultY = getRelativeOffsetResult(limitedRotationY, originY)

        positionAbsolute(resultX, resultY)
    }

    private fun getRelativeOffsetResult(rotation: Double, origin: Double): Double {
        val min = 0.0
        val max = 1.0
        val center = (max - min) / 2

        val limitedRotation = MathUtil.limit(rotation, min, max)
        val limitedOrigin = MathUtil.limit(origin, min, max)

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
