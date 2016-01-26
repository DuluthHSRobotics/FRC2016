package org.usfirst.frc5293.input.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

public final class NullJoystick extends Joystick {

    private NullJoystick() {
        super(0, 0, 0);
    }

    public static final NullJoystick INSTANCE = new NullJoystick();

    @Override
    public double getX(Hand hand) {
        return 0;
    }

    @Override
    public double getY(Hand hand) {
        return 0;
    }

    @Override
    public double getZ(Hand hand) {
        return 0;
    }

    @Override
    public double getTwist() {
        return 0;
    }

    @Override
    public double getThrottle() {
        return 0;
    }

    @Override
    public double getRawAxis(int axis) {
        return 0;
    }

    @Override
    public double getAxis(AxisType axis) {
        return 0;
    }

    @Override
    public int getAxisCount() {
        return 0;
    }

    @Override
    public boolean getTrigger(Hand hand) {
        return false;
    }

    @Override
    public boolean getTop(Hand hand) {
        return false;
    }

    @Override
    public boolean getBumper(Hand hand) {
        return false;
    }

    @Override
    public boolean getRawButton(int button) {
        return false;
    }

    @Override
    public int getButtonCount() {
        return 0;
    }

    @Override
    public int getPOV(int pov) {
        return 0;
    }

    @Override
    public int getPOVCount() {
        return 0;
    }

    @Override
    public boolean getButton(ButtonType button) {
        return false;
    }

    @Override
    public double getMagnitude() {
        return 0;
    }

    @Override
    public double getDirectionRadians() {
        return 0;
    }

    @Override
    public double getDirectionDegrees() {
        return 0;
    }

    @Override
    public int getAxisChannel(AxisType axis) {
        return 0;
    }

    @Override
    public void setAxisChannel(AxisType axis, int channel) {
    }

    @Override
    public void setRumble(RumbleType type, float value) {
    }

    @Override
    public void setOutput(int outputNumber, boolean value) {
    }

    @Override
    public void setOutputs(int value) {
    }

    @Override
    public int getPOV() {
        return 0;
    }
}
