package org.usfirst.frc5293.prefs.util

import edu.wpi.first.wpilibj.Preferences

class BooleanPref(key: String, default: Boolean) : Pref<Boolean>(key, default) {

    override fun get(): Boolean {
        return Preferences.getInstance().getBoolean(key, default)
    }

    override fun set(value: Boolean) {
        Preferences.getInstance().putBoolean(key, value)
    }
}
