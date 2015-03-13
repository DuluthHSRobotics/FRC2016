package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.Devices;
import org.usfirst.frc5293.commands.teleop.control.MecanumDriveControl;
import org.usfirst.frc5293.subsystems.util.MecanumDrive;

public class Drivetrain extends Subsystem {

    private final MecanumDrive drive = Devices.getDrivetrain().getControl();

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDriveControl());
    }

    /**
     * Drive method for Mecanum wheeled robots.
     *
     * A method for driving with Mecanum wheeled robots. There are 4 wheels
     * on the robot, arranged so that the front and back wheels are toed in 45 degrees.
     * When looking at the wheels from the top, the roller axles should form an X across the robot.
     *
     * This is designed to be directly driven by joystick axes.
     *
     * @param x The speed that the robot should drive in the X direction. [-1.0..1.0]
     * @param y The speed that the robot should drive in the Y direction.
     * This input is inverted to match the forward == -1.0 that joysticks produce. [-1.0..1.0]
     * @param r The rate of rotation for the robot that is completely independent of
     * the translation. [-1.0..1.0]
     */
    public void drive(double x, double y, double r) {
        // TODO: Just for debug right now
        SmartDashboard.putNumber("Joystick X", x);
        SmartDashboard.putNumber("Joystick Y", y);
        SmartDashboard.putNumber("Joystick Rotation", r);

        drive.drive(x, y, r, 0);

        SmartDashboard.putNumber("Front Left", Devices.getDrivetrain().getFrontLeft().get());
        SmartDashboard.putNumber("Front Right", Devices.getDrivetrain().getFrontRight().get());
        SmartDashboard.putNumber("Back Left", Devices.getDrivetrain().getBackLeft().get());
        SmartDashboard.putNumber("Back Right", Devices.getDrivetrain().getBackRight().get());
    }

    public void stop() {
    	drive.drive(0, 0, 0, 0);
    }
}

