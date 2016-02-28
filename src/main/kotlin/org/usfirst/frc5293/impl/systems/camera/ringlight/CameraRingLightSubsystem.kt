package org.usfirst.frc5293.impl.systems.camera.ringlight

import edu.wpi.first.wpilibj.Relay
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem

class CameraRingLightSubsystem(ringLight: CameraRingLightDevice) : EmptySubsytem() {

    private val relay by lazy { ringLight.relay }

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
