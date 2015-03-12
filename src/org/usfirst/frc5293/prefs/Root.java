package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.BooleanPref;
import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;

import java.util.ArrayList;
import java.util.List;

public class Root implements PrefGroup {
    private final List<Pref<?>> all = new ArrayList<>();

    private final BooleanPref isSensitiveScalingEnabled = new BooleanPref(
            "root:is_sensitive_scaling_enabled",
            true
    ); { all.add(isSensitiveScalingEnabled); }

    @Override
    public List<Pref<?>> getAll() {
        return all;
    }

    public BooleanPref isSensitiveScalingEnabled() {
        return isSensitiveScalingEnabled;
    }
}
