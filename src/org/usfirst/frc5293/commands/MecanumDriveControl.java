package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;

public class MecanumDriveControl extends ContinuousCommand {

    public MecanumDriveControl() {
        requires(Subsystems.getDrivetrain());
    }

    @Override
    protected void execute() {
        double x = Input.getJoystick1().getX();
        double y = Input.getJoystick1().getY();
        double r = Input.getJoystick2().getTwist();

        if (!Prefs.getDrivetrain().isXEnabled().get()) {
            x = 0;
        }

        if (!Prefs.getDrivetrain().isYEnabled().get()) {
            y = 0;
        }

        if (!Prefs.getDrivetrain().isRotationEnabled().get()) {
            r = 0;
        }

        Subsystems.getDrivetrain().drive(x, y, -r);
    }

    @Override
    protected void end() {
    	Subsystems.getDrivetrain().stop();
    }
}
