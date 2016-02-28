package org.usfirst.frc5293.framework.input

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.Joystick

object NullJoystick : Joystick(0, 0, 0) {

    override fun getX(hand: Hand?): Double {
        return 0.0
    }

    override fun getY(hand: Hand?): Double {
        return 0.0
    }

    override fun getZ(hand: Hand?): Double {
        return 0.0
    }

    override fun getTwist(): Double {
        return 0.0
    }

    override fun getThrottle(): Double {
        return 0.0
    }

    override fun getRawAxis(axis: Int): Double {
        return 0.0
    }

    override fun getAxis(axis: AxisType): Double {
        return 0.0
    }

    override fun getAxisCount(): Int {
        return 0
    }

    override fun getTrigger(hand: Hand?): Boolean {
        return false
    }

    override fun getTop(hand: Hand?): Boolean {
        return false
    }

    override fun getBumper(hand: Hand?): Boolean {
        return false
    }

    override fun getRawButton(button: Int): Boolean {
        return false
    }

    override fun getButtonCount(): Int {
        return 0
    }

    override fun getPOV(pov: Int): Int {
        return 0
    }

    override fun getPOVCount(): Int {
        return 0
    }

    override fun getButton(button: ButtonType): Boolean {
        return false
    }

    override fun getMagnitude(): Double {
        return 0.0
    }

    override fun getDirectionRadians(): Double {
        return 0.0
    }

    override fun getDirectionDegrees(): Double {
        return 0.0
    }

    override fun getAxisChannel(axis: AxisType): Int {
        return 0
    }

    override fun setAxisChannel(axis: AxisType, channel: Int) {
    }

    override fun setRumble(type: RumbleType, value: Float) {
    }

    override fun setOutput(outputNumber: Int, value: Boolean) {
    }

    override fun setOutputs(value: Int) {
    }

    override fun getPOV(): Int {
        return 0
    }
}
