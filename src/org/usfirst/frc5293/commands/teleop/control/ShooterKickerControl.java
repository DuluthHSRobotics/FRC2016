package org.usfirst.frc5293.commands.teleop.control;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;

import java.util.concurrent.atomic.AtomicBoolean;

public class ShooterKickerControl extends ContinuousCommand {

    public ShooterKickerControl() {
        requires(Subsystems.getShooterKicker());
    }

    @Override
    protected void execute() {
        final double deadzone = 0.10;
        final double raw = Input.getShooterKicker().getJoystick().getY();

        if (Math.abs(raw) > deadzone) {
            Subsystems.getShooterKicker().set(raw);
        }
    }
}
