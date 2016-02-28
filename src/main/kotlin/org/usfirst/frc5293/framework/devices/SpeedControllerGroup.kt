package org.usfirst.frc5293.framework.devices

import edu.wpi.first.wpilibj.SpeedController

/**
 * A pseudo speed controller that groups its underlying speed controllers. All actions on the group
 * will be propagated to the underlying speed controllers.
 */
class SpeedControllerGroup(val controllers: Collection<SpeedController>) : SpeedController {

    private var isInverted = false
    private var isDisabled = false

    constructor(vararg controllers: SpeedController) : this(controllers.asList())

    override fun get(): Double {
        return controllers.iterator().next().get()
    }

    override fun set(speed: Double, syncGroup: Byte) {
        if (isDisabled) return

        val actualSpeed = sign * speed
        controllers.forEach({ it.set(actualSpeed, syncGroup) })
    }

    override fun set(speed: Double) {
        if (isDisabled) return

        val actualSpeed = sign * speed
        controllers.forEach({ it.set(actualSpeed) })
    }

    override fun setInverted(isInverted: Boolean) {
        this.isInverted = isInverted
    }

    override fun getInverted(): Boolean {
        return this.isInverted
    }

    override fun pidWrite(output: Double) {
        controllers.forEach({ it.pidWrite(output) })
    }

    override fun disable() {
        stopMotor()
        this.isDisabled = true
        controllers.forEach({ it.disable() })
    }

    override fun stopMotor() {
        set(0.0)
    }

    private val sign: Double = if (isInverted) -1.0 else +1.0
}
