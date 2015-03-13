package org.usfirst.frc5293.subsystems.binelevator;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public enum DoubleSolenoidState {
    STOPPED(DoubleSolenoid.Value.kOff),
    EXTEND(DoubleSolenoid.Value.kForward),
    RETRACT(DoubleSolenoid.Value.kReverse);

    private DoubleSolenoid.Value value;

    private DoubleSolenoidState(DoubleSolenoid.Value value) {
        this.value = value;
    }

    public DoubleSolenoid.Value getInternalValue() {
        return value;
    }
}
