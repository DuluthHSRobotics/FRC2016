package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public final class BinElevator {
    private final SpeedController victor;
    private final DoubleSolenoid left;
    private final DoubleSolenoid right;

    public BinElevator() {
        victor = new VictorSP(6);
        LiveWindow.addActuator("Bin Elevator", "Victor SP 6", (VictorSP) victor);

        left = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Bin Grabber", "Double Sol Grabber (Left)", left);

        right = new DoubleSolenoid(1, 0, 1);
        LiveWindow.addActuator("Bin Grabber", "Double Sol Grabber (Right)", right);
    }

    public SpeedController getVictor() {
        return victor;
    }

    public DoubleSolenoid getLeft() {
        return left;
    }

    public DoubleSolenoid getRight() {
        return right;
    }
}
