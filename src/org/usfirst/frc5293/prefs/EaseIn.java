package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.*;

import java.util.ArrayList;
import java.util.List;

public class EaseIn implements PrefGroup {
    private final IntPref easeInDuration = new IntPref(
            "ease_in:duration",
            500
    );

    private final DoublePref easeInChange = new DoublePref(
            "ease_in:change",
            0.1
    );

    private final BooleanPref isEnabled = new BooleanPref(
            "ease_in:enabled",
            false
    );

    private final List<Pref<?>> all = new ArrayList<>();

    public EaseIn() {
        all.add(easeInDuration);
        all.add(easeInChange);
        all.add(isEnabled);
    }

    @Override
    public List<Pref<?>> getAll() {
        return all;
    }

    public IntPref getEaseInDuration() {
        return easeInDuration;
    }

    public DoublePref getEaseInChange() {
        return easeInChange;
    }

    public BooleanPref isEnabled() {
        return isEnabled;
    }
}
