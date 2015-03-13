package org.usfirst.frc5293.subsystems.binelevator;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc5293.Devices;

public class MainExtender {
    private final DoubleSolenoid left = Devices.getBinElevator().getLeft();
    private final DoubleSolenoid right = Devices.getBinElevator().getRight();

    private DoubleSolenoidState state = DoubleSolenoidState.STOPPED;

    public void extend() {
        setState(DoubleSolenoidState.EXTEND);
    }

    public void retract() {
        setState(DoubleSolenoidState.RETRACT);
    }

    public void reverse() {
        if (!isExtended()) {
            extend();
        } else {
            retract();
        }
    }

    private boolean isExtended() {
        return getState().equals(DoubleSolenoidState.EXTEND);
    }

    private void setState(DoubleSolenoidState state) {
        this.state = state;
        left.set(state.getInternalValue());
        right.set(state.getInternalValue());
    }

    public DoubleSolenoidState getState() {
        return state;
    }
}
