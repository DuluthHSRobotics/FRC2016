package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.Devices;

public class CameraRingLight extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        // input will set callback
    }

    public void enable() {
        set(true);
    }

    public void disable() {
        set(false);
    }

    public void set(boolean isEnabled) {
        final Relay.Value value =
                (isEnabled)
                ? Relay.Value.kForward
                : Relay.Value.kOff;

        getRelay().set(value);
        SmartDashboard.putBoolean("Camera Ring Light Enabled?", isEnabled);
    }

    public boolean get() {
        return getRelay().get().equals(Relay.Value.kOn);
    }

    public void swap() {
        set(!get());
    }

    private Relay getRelay() {
        return Devices.getCameraRingLight().getRelay();
    }
}
