package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc5293.devices.util.SpeedControllerGroup;

public final class ToteElevatorPrototype implements ToteElevator {
    private final SpeedControllerGroup controllerGroup;
    private final DigitalInput bottomLimitSwitch;

    public ToteElevatorPrototype() {
        controllerGroup = new SpeedControllerGroup(new Victor(9), new Victor(8));

        bottomLimitSwitch = new DigitalInput(4);
        LiveWindow.addSensor("Tote Elevator", "Button Limit Switch", bottomLimitSwitch);
    }

    public SpeedController getController() {
        return controllerGroup;
    }

    public DigitalInput getBottomLimitSwitch() {
        return bottomLimitSwitch;
    }
}
