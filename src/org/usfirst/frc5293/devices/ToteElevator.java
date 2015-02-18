package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;

public interface ToteElevator {
    SpeedController getController();
    DigitalInput getBottomLimitSwitch();
}
