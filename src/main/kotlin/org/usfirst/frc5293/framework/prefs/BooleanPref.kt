package org.usfirst.frc5293.framework.prefs

import edu.wpi.first.wpilibj.Preferences

class BooleanPref(key: String, default: Boolean) : Pref<Boolean>(key, default) {

    override fun get(): Boolean {
        return Preferences.getInstance().getBoolean(key, default)
    }

    override fun set(value: Boolean) {
        super.set(value)
        Preferences.getInstance().putBoolean(key, value)
    }
}
