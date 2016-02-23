package org.usfirst.frc5293.subsystems

import edu.wpi.first.wpilibj.Relay
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.subsystems.util.EmptySubsytem

class CameraRingLight : EmptySubsytem() {

    private val relay by lazy { Devices.cameraRingLight.relay }

    var isEnabled: Boolean
        get() = relay.get() == Relay.Value.kOn
        set(isEnabled) {
            val value =
                if (isEnabled)
                    Relay.Value.kForward
                else
                    Relay.Value.kOff

            relay.set(value)
            SmartDashboard.putBoolean("Camera Ring Light Enabled?", isEnabled)
        }

    fun swap() {
        isEnabled = !isEnabled
    }
}
