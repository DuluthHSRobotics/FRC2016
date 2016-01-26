package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc5293.devices.util.InvertedSpeedController;
import org.usfirst.frc5293.devices.util.SpeedControllerGroup;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public final class Shooter {
    private final SpeedControllerGroup controllerGroup;

    public Shooter() {
        controllerGroup = new SpeedControllerGroup(
                new InvertedSpeedController(new Talon(0)),
                new InvertedSpeedController(new Talon(1)));
    }

    public SpeedController getController() {
        return controllerGroup;
    }
}

