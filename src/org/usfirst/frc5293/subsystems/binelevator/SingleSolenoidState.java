package org.usfirst.frc5293.subsystems.binelevator;

public enum SingleSolenoidState {
    EXTEND(true),
    RETRACT(false);

    private final boolean value;

    private SingleSolenoidState(boolean value) {
        this.value = value;
    }

    public boolean getInternalValue() {
        return value;
    }
}
