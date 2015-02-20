package org.usfirst.frc5293.commands.teleop.control;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.translations.CameraEngine;
import org.usfirst.frc5293.translations.util.Point;

public class CameraControl extends ContinuousCommand {

    private CameraEngine engine = new CameraEngine();

    public CameraControl() {
        requires(Subsystems.getCamera());
    }

    @Override
    protected void execute() {
        Point result = engine.getResult();

        SmartDashboard.putNumber("Camera X Rotation", result.x);
        SmartDashboard.putNumber("Camera Y Rotation", result.y);
        
        Subsystems.getCamera().positionRelative(result.x, result.y);
    }
}
