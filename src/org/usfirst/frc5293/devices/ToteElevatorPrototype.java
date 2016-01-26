package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc5293.devices.util.NullSpeedController;
import org.usfirst.frc5293.devices.util.SpeedControllerGroup;

public final class ToteElevatorPrototype implements ToteElevator {
    private final SpeedControllerGroup controllerGroup;
    private final DigitalInput bottomLimitSwitch;

    public ToteElevatorPrototype() {
        controllerGroup = new SpeedControllerGroup(NullSpeedController.INSTANCE, NullSpeedController.INSTANCE);

        bottomLimitSwitch = new DigitalInput(0);
        LiveWindow.addSensor("Tote Elevator", "Button Limit Switch", bottomLimitSwitch);
    }

    public SpeedController getController() {
        return controllerGroup;
    }

    public DigitalInput getBottomLimitSwitch() {
        return bottomLimitSwitch;
    }
}
