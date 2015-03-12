package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public final class BinElevator {
    private static final int PNEUMATICS_CAN_ID = 0;

    private final DoubleSolenoid left;
    private final DoubleSolenoid right;

    public BinElevator() {
        left = new DoubleSolenoid(PNEUMATICS_CAN_ID, 1, 6);
        left.set(DoubleSolenoid.Value.kOff);
        LiveWindow.addActuator("Bin Grabber", "Double Sol Grabber (Left)", left);

        right = new DoubleSolenoid(PNEUMATICS_CAN_ID, 0, 7);
        right.set(DoubleSolenoid.Value.kOff);
        LiveWindow.addActuator("Bin Grabber", "Double Sol Grabber (Right)", right);
    }

    public DoubleSolenoid getLeft() {
        return left;
    }

    public DoubleSolenoid getRight() {
        return right;
    }
}
