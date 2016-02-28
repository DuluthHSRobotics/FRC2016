package org.usfirst.frc5293.groups.shooter.lift

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Inputs
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.EmptyCommand

class Control : EmptyCommand() {

    init {
        requires(Subsystems.shooterLift)
    }

    override fun execute() {
//        if (!Inputs.shooterLifter.enableButton.get()) {
//            Subsystems.shooterLift.stop()
//            return
//        }

        val deadzone = 0.20
        val raw = Inputs.shooterLifter.joystick.y

        SmartDashboard.putNumber("SL Y Raw", raw)

        if (Math.abs(raw) > deadzone) {
            Subsystems.shooterLift.power = raw
            return
        } else {
            Subsystems.shooterLift.stop()
            return
        }
    }
}