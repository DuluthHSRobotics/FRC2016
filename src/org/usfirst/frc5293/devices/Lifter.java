package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc5293.devices.util.NullSpeedController;

public final class Lifter {

    private final SpeedController topMotor;
    private final SpeedController bottomMotor;

    public Lifter() {
        topMotor = NullSpeedController.getInstance();
        bottomMotor = NullSpeedController.getInstance();
    }

    public SpeedController getTopMotor() {
        return topMotor;
    }

    public SpeedController getBottomMotor() {
        return bottomMotor;
    }
}
