package org.usfirst.frc5293.commands;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.commands.util.ContinuousCommand;

public class AccelerationCommand extends ContinuousCommand {

    private BuiltInAccelerometer accelerometer;

    @Override
    protected void initialize() {
        accelerometer = new BuiltInAccelerometer(Accelerometer.Range.k2G);
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Acceleration X", accelerometer.getX());
        SmartDashboard.putNumber("Acceleration Y", accelerometer.getY());
        SmartDashboard.putNumber("Acceleration Z", accelerometer.getZ());
    }
}
