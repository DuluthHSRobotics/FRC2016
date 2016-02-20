package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.Servo;

public class ShooterKicker {
    private final Servo kicker;

    public ShooterKicker() {
        kicker = new Servo(7);
    }

    public Servo getKicker() {
        return kicker;
    }
}
