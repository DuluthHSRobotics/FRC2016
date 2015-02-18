package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.Devices;
import org.usfirst.frc5293.commands.MecanumDriveControl;
import org.usfirst.frc5293.util.CustomRobotDrive;

public class Drivetrain extends Subsystem {

    private final CustomRobotDrive drive = Devices.getDrivetrain().getControl();

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDriveControl());
    }

    public void drive(double x, double y, double r) {
        // TODO: Just for debug right now
        SmartDashboard.putNumber("Joystick X", x);
        SmartDashboard.putNumber("Joystick Y", y);
        SmartDashboard.putNumber("Joystick Rotation", r);

        drive.mecanumDrive_Cartesian(x, y, r, 0);

        SmartDashboard.putNumber("Front Left", Devices.getDrivetrain().getFrontLeft().get());
        SmartDashboard.putNumber("Front Right", Devices.getDrivetrain().getFrontRight().get());
        SmartDashboard.putNumber("Back Left", Devices.getDrivetrain().getBackLeft().get());
        SmartDashboard.putNumber("Back Right", Devices.getDrivetrain().getBackRight().get());
    }

    public void stop() {
    	drive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
}

