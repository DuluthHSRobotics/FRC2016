package org.usfirst.frc5293;

import org.usfirst.frc5293.util.preferences.BooleanPref;
import org.usfirst.frc5293.util.preferences.DoublePref;
import org.usfirst.frc5293.util.preferences.IntPref;

public final class Prefs {

    // TOOD: Have global switch to completely disable the remote settings if we need to

    public static class EaseIn {
        public static final IntPref easeInDuration = new IntPref(
                "ease_in:duration",
                500
        );

        public static final DoublePref easeInChange = new DoublePref(
                "ease_in:change",
                0.1
        );

        public static final BooleanPref isEnabled = new BooleanPref(
                "ease_in:enabled",
                false
        );
    }

    public static class ToteElevator {
        public static final DoublePref speed = new DoublePref(
                "tote_elevator:speed",
                0.5
        );

        public static final DoublePref voltageRamp = new DoublePref(
                "tote_elevator:voltage_ramp",
                6.0
        );

        public static final BooleanPref isVoltageRampEnabled = new BooleanPref(
                "tote_elevator:is_voltage_ramp_enabled",
                false // TODO: at least for right now
        );
    }


}
