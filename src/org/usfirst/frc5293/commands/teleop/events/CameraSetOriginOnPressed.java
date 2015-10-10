package org.usfirst.frc5293.commands.teleop.events;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ActionCommand;
import org.usfirst.frc5293.translations.camera.CameraEngine;
import org.usfirst.frc5293.translations.util.Point;

public class CameraSetOriginOnPressed extends ActionCommand {

    public CameraSetOriginOnPressed() {
        super(Subsystems.getCamera());
    }

    @Override
    protected void action() {
        Point point = CameraEngine.getInstance().getResult();
        Subsystems.getCamera().setOrigin(point.x, point.y);
    }
}
