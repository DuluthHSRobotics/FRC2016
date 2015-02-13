package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5293.Devices;
import org.usfirst.frc5293.commands.BinElevatorControl;

public class BinElevator extends Subsystem {

    public static enum State {
        STOPPED(DoubleSolenoid.Value.kOff),
        EXTEND(DoubleSolenoid.Value.kForward),
        RETRACT(DoubleSolenoid.Value.kReverse);

        private DoubleSolenoid.Value value;

        private State(DoubleSolenoid.Value value) {
            this.value = value;
        }

        public DoubleSolenoid.Value getInternalValue() {
            return value;
        }
    }

    private final DoubleSolenoid left = Devices.BinElevator.getLeft();
    private final DoubleSolenoid right = Devices.BinElevator.getRight();

    private BinElevatorControl command;

    private State state = State.STOPPED;

    protected void initDefaultCommand() {
        command = new BinElevatorControl();
        setDefaultCommand(command);
    }

    public void extend() {
        setState(State.EXTEND);
    }

    public void retract() {
        setState(State.RETRACT);
    }

    private void setState(State state) {
        this.state = state;
        left.set(state.getInternalValue());
        right.set(state.getInternalValue());
    }

    public State getState() {
        return state;
    }

    public BinElevatorControl getControlCommand() {
        return command;
    }
}
