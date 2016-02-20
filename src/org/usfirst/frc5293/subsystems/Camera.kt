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
        var xRotation = xRotation
        var yRotation = yRotation
        xRotation = MathUtil.limit(xRotation, 0.0, 1.0)
        yRotation = MathUtil.limit(yRotation, 0.0, 1.0)

        Devices.camera.sideServo.set(xRotation)
        Devices.camera.topServo.set(yRotation)
    }

    fun positionRelative(rotationX: Double, rotationY: Double) {
        var rotationX = rotationX
        var rotationY = rotationY
        // Make the rotation values relative to 0.5 so that left is [0.0, 0.5) and right is (0.5, 0.0]
        rotationX = MathUtil.limit(rotationX, 0.0, 1.0)
        rotationY = MathUtil.limit(rotationY, 0.0, 1.0)

        val resultX = getRelativeOffsetResult(rotationX, originX)
        val resultY = getRelativeOffsetResult(rotationY, originY)

        positionAbsolute(resultX, resultY)
    }

    private fun getRelativeOffsetResult(rotation: Double, origin: Double): Double {
        var rotation = rotation
        var origin = origin
        val min = 0.0
        val max = 1.0
        val center = (max - min) / 2

        rotation = MathUtil.limit(rotation, min, max)
        origin = MathUtil.limit(origin, min, max)

        if (rotation == center) {
            return origin
        } else if (rotation < center) {
            val percent = max - rotation / center
            return origin - percent * origin
        } else {
            // rotation > center
            val p = (rotation - center) / center
            return origin + p * (1 - origin)
        }
    }

    fun setOrigin(x: Double, y: Double) {
        originX = x
        originY = y
    }
}
