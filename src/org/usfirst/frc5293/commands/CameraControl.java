package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.util.MathUtil;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CameraControl extends ContinuousCommand {

    public CameraControl() {
        requires(Subsystems.getCamera());
    }

    @Override
    protected void execute() {
        double xRotation = Input.getCamera().getJoystick().getTwist();
        double yRotation = Input.getCamera().getJoystick().getY();

        xRotation = scaleInput(-xRotation);
        yRotation = scaleInput(-yRotation);

        SmartDashboard.putNumber("Camera X Rotation", xRotation);
        SmartDashboard.putNumber("Camera Y ROtation", yRotation);
        
        Subsystems.getCamera().position(xRotation, yRotation);
    }

    /**
     * Scales the joystick input value to the servo value
     *
     * @param value  the joystick input value [-1.0..1.0]
     * @return the server input value [0.0..1.0]
     */
    private static double scaleInput(double value) {
        value = MathUtil.limit(value, -1.0, 1.0);
        return (value + 1.0) / 2.0;
    }
}
