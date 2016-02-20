package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.teleop.events.ShooterKickerOnPressed;
import org.usfirst.frc5293.commands.teleop.events.ShooterKickerTryStart;
import org.usfirst.frc5293.commands.util.ActionCommand;
import org.usfirst.frc5293.commands.util.ActionCommandGroup;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShooterKicker {
    private final Joystick joystick;
    private final JoystickButton kick;

    public ShooterKicker(Joystick joystick) {
        this.joystick = joystick;

        kick = new JoystickButton(this.joystick, 7);
        kick.whenPressed(new ShooterKickerTryStart());
    }

    public Joystick getJoystick() {
        return joystick;
    }
}
