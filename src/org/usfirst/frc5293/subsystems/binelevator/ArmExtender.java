package org.usfirst.frc5293.subsystems.binelevator;

import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc5293.Devices;

public class ArmExtender {
    private final Solenoid solenoid = Devices.getBinElevator().getExtender();

    private SingleSolenoidState state = SingleSolenoidState.RETRACT;

    public void extend() {
        setState(SingleSolenoidState.EXTEND);
    }

    public void retract() {
        setState(SingleSolenoidState.RETRACT);
    }

    public void reverse() {
        if (!isExtended()) {
            extend();
        } else {
            retract();
        }
    }

    private boolean isExtended() {
        return getState().equals(SingleSolenoidState.EXTEND);
    }

    private void setState(SingleSolenoidState state) {
        this.state = state;
        solenoid.set(state.getInternalValue());
    }

    public SingleSolenoidState getState() {
        return state;
    }
}
