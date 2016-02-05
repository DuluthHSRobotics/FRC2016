package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc5293.devices.util.SpeedControllerGroup;

import edu.wpi.first.wpilibj.SpeedController;

public final class Shooter {
    private final SpeedControllerGroup controllerGroup;
    private final SpeedController leftMotor;
    private final SpeedController rightMotor;

    public Shooter() {
        leftMotor = new Talon(0);
        leftMotor.setInverted(true);

        rightMotor = new Talon(1);

        controllerGroup = new SpeedControllerGroup(
                leftMotor,
                rightMotor);
    }

    public SpeedController getController() {
        return controllerGroup;
    }
}

