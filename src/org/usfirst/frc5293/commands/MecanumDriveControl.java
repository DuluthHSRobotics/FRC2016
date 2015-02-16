package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.prefs.Drivetrain;

public class MecanumDriveControl extends ContinuousCommand {

    private final Input.MecanumDrive input;
    private Drivetrain prefs = Prefs.getDrivetrain();

    public MecanumDriveControl() {
        requires(Subsystems.getDrivetrain());
        input = Input.getMecanumDrive();
    }

    @Override
    protected void execute() {
        double x = input.getStrafeJoystick().getX();
        double y = input.getStrafeJoystick().getY();
        double r = input.getRotationJoystick().getTwist();

        if (!prefs.isXEnabled().get()) {
            x = 0;
        }

        if (!prefs.isYEnabled().get()) {
            y = 0;
        }

        if (!prefs.isRotationEnabled().get()) {
            r = 0;
        }

        if (prefs.isSensitiveRotationEnabled().get() && input.getSensitiveButton().get()) {
            r *= prefs.getSensitiveScaleRotation().get();
        }

        Subsystems.getDrivetrain().drive(
                prefs.getScaleX().get() * -x,
                prefs.getScaleY().get() * y,
                prefs.getScaleRotation().get() * -r);
    }

    @Override
    protected void end() {
    	Subsystems.getDrivetrain().stop();
    }
}
