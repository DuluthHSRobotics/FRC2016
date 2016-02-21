package org.usfirst.frc5293.prefs.util

import edu.wpi.first.wpilibj.Preferences

class IntPref(key: String, default: Int) : Pref<Int>(key, default) {
    override fun get() = Preferences.getInstance().getInt(key, default)

    override fun set(value: Int) = Preferences.getInstance().putInt(key, value)
}
