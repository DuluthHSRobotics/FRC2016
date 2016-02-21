package org.usfirst.frc5293.input.util

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.Joystick

object NullJoystick : Joystick(0, 0, 0) {

    override fun getX(hand: GenericHID.Hand?): Double {
        return 0.0
    }

    override fun getY(hand: GenericHID.Hand?): Double {
        return 0.0
    }

    override fun getZ(hand: GenericHID.Hand?): Double {
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

    override fun getAxis(axis: Joystick.AxisType): Double {
        return 0.0
    }

    override fun getAxisCount(): Int {
        return 0
    }

    override fun getTrigger(hand: GenericHID.Hand?): Boolean {
        return false
    }

    override fun getTop(hand: GenericHID.Hand?): Boolean {
        return false
    }

    override fun getBumper(hand: GenericHID.Hand?): Boolean {
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

    override fun getButton(button: Joystick.ButtonType): Boolean {
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

    override fun getAxisChannel(axis: Joystick.AxisType): Int {
        return 0
    }

    override fun setAxisChannel(axis: Joystick.AxisType, channel: Int) {
    }

    override fun setRumble(type: Joystick.RumbleType, value: Float) {
    }

    override fun setOutput(outputNumber: Int, value: Boolean) {
    }

    override fun setOutputs(value: Int) {
    }

    override fun getPOV(): Int {
        return 0
    }
}
