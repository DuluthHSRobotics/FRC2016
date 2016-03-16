package org.usfirst.frc5293.framework.prefs

import edu.wpi.first.wpilibj.Preferences

class IntPref(key: String, default: Int) : Pref<Int>(key, default) {
    override fun get() = Preferences.getInstance().getInt(key, default)

    override fun set(value: Int) {
        super.set(value)
        Preferences.getInstance().putInt(key, value)
    }
}
