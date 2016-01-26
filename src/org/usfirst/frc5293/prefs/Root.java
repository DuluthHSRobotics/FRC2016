package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;

import java.util.ArrayList;
import java.util.List;

public class Root implements PrefGroup {
    // ... there is nothing really here

    private final List<Pref<?>> all = new ArrayList<>();

    @Override
    public List<Pref<?>> getAll() {
        return all;
    }
}
