package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5293.Devices;
import org.usfirst.frc5293.commands.teleop.control.CameraControl;
import org.usfirst.frc5293.util.MathUtil;

public class Camera extends Subsystem {

    private double originX = 0.5;
    private double originY = 0.5;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CameraControl());
    }

    /**
     * Positions the camera to the value of rotation along the power-axis and the y-axis
     *
     * @param xRotation the positionAbsolute of rotation along the power-axis in the range of [0.0,1.0]
     * @param yRotation the positionAbsolute of rotation along the y-axis in the range of [0.0,1.0]
     */
    public void positionAbsolute(double xRotation, double yRotation) {
        xRotation = MathUtil.limit(xRotation, 0.0, 1.0);
        yRotation = MathUtil.limit(yRotation, 0.0, 1.0);

        Devices.getCamera().getSideServo().set(xRotation);
        Devices.getCamera().getTopServo().set(yRotation);
    }

    public void positionRelative(double rotationX, double rotationY) {
        // Make the rotation values relative to 0.5 so that left is [0.0, 0.5) and right is (0.5, 0.0]
        rotationX = MathUtil.limit(rotationX, 0.0, 1.0);
        rotationY = MathUtil.limit(rotationY, 0.0, 1.0);

        double resultX = getRelativeOffsetResult(rotationX, originX);
        double resultY = getRelativeOffsetResult(rotationY, originY);

        positionAbsolute(resultX, resultY);
    }

    private double getRelativeOffsetResult(double rotation, double origin) {
        final double min = 0.0;
        final double max = 1.0;
        final double center = (max - min) / 2;

        rotation = MathUtil.limit(rotation, min, max);
        origin = MathUtil.limit(origin, min, max);

        if (rotation == center) {
            return origin;
        } else if (rotation < center) {
            double percent = max - (rotation / center);
            return origin - (percent * origin);
        } else { // rotation > center
            double p = (rotation - center) / center;
            return origin + (p * (1 - origin));
        }
    }

    public void setOrigin(double x, double y) {
        setOriginX(x);
        setOriginY(y);
    }

    public double getOriginX() {
        return originX;
    }

    public void setOriginX(double originX) {
        this.originX = MathUtil.limit(originX, 0.0, 1.0);
    }

    public double getOriginY() {
        return originY;
    }

    public void setOriginY(double originY) {
        this.originY = MathUtil.limit(originY, 0.0, 1.0);
    }
}
