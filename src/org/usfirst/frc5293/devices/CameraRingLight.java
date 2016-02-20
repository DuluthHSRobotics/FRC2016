package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.Relay;

public final class CameraRingLight {
    private final Relay spike;

    public CameraRingLight() {
        spike = new Relay(0, Relay.Direction.kForward);
        spike.set(Relay.Value.kForward);
    }

    public Relay getRelay() {
        return spike;
    }
}
