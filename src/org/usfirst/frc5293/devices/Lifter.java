package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public final class Lifter {
    private final SpeedController motor;

    public Lifter() {
        motor = new Talon(2);
    }

    public SpeedController getMotor() {
        return motor;
    }
}
