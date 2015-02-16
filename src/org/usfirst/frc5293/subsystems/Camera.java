package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5293.Devices;
import org.usfirst.frc5293.commands.CameraControl;
import org.usfirst.frc5293.util.MathUtil;

public class Camera extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CameraControl());
    }

    /**
     * Positions the camera to the value of rotation along the x-axis and the y-axis
     * @param xRotation the position of rotation along the x-axis in the range of [0,1]
     * @param yRotation the position of rotation along the y-axis in the range of [0,1]
     */
    public void position(double xRotation, double yRotation) {
        xRotation = MathUtil.limit(xRotation, 0.0, 1.0);
        yRotation = MathUtil.limit(yRotation, 0.0, 1.0);

        Devices.Camera.getSideServo().set(xRotation);
        Devices.Camera.getTopServo().set(yRotation);
    }
}
