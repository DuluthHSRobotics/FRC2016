package org.usfirst.frc5293.commands.teleop.events;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc5293.commands.util.ActionCommand;

import java.util.Optional;

public class ShooterKickerTryStart extends ActionCommand {

    private static Optional<Command> current = Optional.empty();

    @Override
    protected void action() {
        if (current.isPresent()) {
            return;
        }

        current = Optional.of(new ShooterKickerOnPressed());
        Scheduler.getInstance().add(current.get());
    }
}
