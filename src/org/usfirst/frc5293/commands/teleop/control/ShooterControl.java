package org.usfirst.frc5293.commands.teleop.control;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.commands.util.LimitFunction;

public class ShooterControl extends ContinuousCommand {

    public ShooterControl() {
        requires(Subsystems.getShooter());
    }

    @Override
    protected void execute() {
        final double deadzone = 0.10;
        final double raw = Input.getShooter().getJoystick().getY();

        if (Math.abs(raw) > deadzone) {
            Subsystems.getShooter().setPower(raw);
        } else {
            Subsystems.getShooter().stop();
        }
    }

    @Override
    protected void end() {
        Subsystems.getShooter().stop();
    }
}
