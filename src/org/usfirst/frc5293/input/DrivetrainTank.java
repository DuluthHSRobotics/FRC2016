package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc5293.input.util.OrButtonGroup;

public class DrivetrainTank {

    private final Joystick leftJoystick;
    private final Joystick rightJoystick;

    public DrivetrainTank(Joystick leftJoystick, Joystick rightJoystick) {
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
    }

    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }
}

