package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc5293.subsystems.util.MecanumDrive;

public final class Drivetrain {
    private static final int FRONT_LEFT_ID = 1;
    private static final int BACK_LEFT_ID = 0;
    private static final int FRONT_RIGHT_ID = 3;
    private static final int BACK_RIGHT_ID = 2;

    private final SpeedController frontLeft;
    private final SpeedController backLeft;
    private final SpeedController frontRight;
    private final SpeedController backRight;
    private final MecanumDrive control;

    public Drivetrain() {
        frontLeft = new Talon(FRONT_LEFT_ID);
        LiveWindow.addActuator("Drivetrain", "Front Left (Talon)", (Talon) frontLeft);

        backLeft = new Talon(BACK_LEFT_ID);
        LiveWindow.addActuator("Drivetrain", "Back Left (Talon)", (Talon) backLeft);

        frontRight = new Talon(FRONT_RIGHT_ID);
        LiveWindow.addActuator("Drivetrain", "Front Right (Talon)", (Talon) frontRight);

        backRight = new Talon(BACK_RIGHT_ID);
        LiveWindow.addActuator("Drivetrain", "Back Right (Talon)", (Talon) backRight);

        control = new MecanumDrive(
                frontLeft, backLeft,
                frontRight, backRight);

        control.setInvertedMotor(MecanumDrive.MotorType.FRONT_LEFT, true);
        control.setInvertedMotor(MecanumDrive.MotorType.BACK_LEFT, true);
        control.setSafetyEnabled(true);
        control.setExpiration(0.1);
        control.setSensitivity(0.5);
        control.setMaxOutput(1.0);
    }

    public SpeedController getFrontLeft() {
        return frontLeft;
    }

    public SpeedController getBackLeft() {
        return backLeft;
    }

    public SpeedController getFrontRight() {
        return frontRight;
    }

    public SpeedController getBackRight() {
        return backRight;
    }

    public MecanumDrive getControl() {
        return control;
    }
}
