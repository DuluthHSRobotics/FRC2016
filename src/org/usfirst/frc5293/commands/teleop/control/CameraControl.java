package org.usfirst.frc5293.commands.teleop.control;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.translations.camera.CameraEngine;
import org.usfirst.frc5293.translations.util.Point;

public class CameraControl extends ContinuousCommand {

    public CameraControl() {
        requires(Subsystems.getCamera());
    }

    @Override
    protected void execute() {
        Point result = CameraEngine.getInstance().getResult();

        SmartDashboard.putNumber("Camera X Rotation", result.x);
        SmartDashboard.putNumber("Camera Y Rotation", result.y);
        
        Subsystems.getCamera().positionRelative(result.x, result.y);
    }
}
