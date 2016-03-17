package org.usfirst.frc5293.impl.systems.shooter.kicker

import edu.wpi.first.wpilibj.buttons.Button
import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.framework.commands.ScheduledCommandGroup
import org.usfirst.frc5293.framework.commands.SubsystemActionCommand
import org.usfirst.frc5293.framework.util.Logging
import org.usfirst.frc5293.impl.Prefs
import org.usfirst.frc5293.impl.Subsystems

class ShooterKickerControl(val kickButton: Button, kicker: ShooterKickerSubsystem) {
    init {
        kickButton.whileHeld(object : EmptyCommand() {

            init {
                requires(kicker)
            }

            override fun execute() {
                kicker.angle = Prefs.root.shooterKickerAngle.get()
            }
        })

        kickButton.whenReleased(SubsystemActionCommand(kicker) {
            kicker.angle = 0.0
        })
    }
}