package org.usfirst.frc5293.impl.systems.shooter.limitswitch

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.livewindow.LiveWindow

class ShooterBallLimitSwitchDevice(val limitSwitch: DigitalInput) {
    init {
        LiveWindow.addSensor("Shooter", "Ball Limit Switch", limitSwitch)
    }
}