package org.usfirst.frc5293.util;

import org.usfirst.frc5293.util.preferences.DoublePref;
import org.usfirst.frc5293.util.preferences.IntPref;

public final class Prefs {

    public static class EaseIn {
        public static final IntPref easeInDuration = new IntPref(
                "ease_in::duration",
                500
        );

        public static final DoublePref easeInChange = new DoublePref(
                "ease_in::change",
                0.1
        );
    }

}
