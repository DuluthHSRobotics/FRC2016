package org.usfirst.frc5293.commands.teleop.events;

import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ActionCommand;
import org.usfirst.frc5293.commands.util.ActionCommandGroup;

public class ShooterKickerOnPressed extends ActionCommandGroup {

    public ShooterKickerOnPressed() {
        super(Subsystems.getShooterKicker());

        addSequential(new ActionCommand(Subsystems.getShooterKicker()) {
            @Override
            protected void action() {
                Subsystems.getShooterKicker().setAngle(70);
            }
        });

        addSequential(new WaitCommand(3.0 /* seconds */));

        addSequential(new ActionCommand(Subsystems.getShooterKicker()) {
            @Override
            protected void action() {
                Subsystems.getShooterKicker().setAngle(0);
            }
        });
    }
}
