package org.usfirst.frc5293.util;

import org.usfirst.frc5293.util.preferences.BooleanPref;
import org.usfirst.frc5293.util.preferences.DoublePref;
import org.usfirst.frc5293.util.preferences.IntPref;

public final class Prefs {

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
                true
        );
    }

    public static class ToteElevator {
        public static final DoublePref speed = new DoublePref(
                "tote_elevator:speed",
                0.5
        );
    }
}
