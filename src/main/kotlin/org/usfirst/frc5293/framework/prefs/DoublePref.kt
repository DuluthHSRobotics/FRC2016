package org.usfirst.frc5293.framework.prefs

import edu.wpi.first.wpilibj.Preferences

class DoublePref(key: String, default: Double) : Pref<Double>(key, default) {

    override fun get(): Double {
        return Preferences.getInstance().getDouble(key, default)
    }

    override fun set(value: Double) {
        Preferences.getInstance().putDouble(key, value)
    }
}
