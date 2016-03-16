package org.usfirst.frc5293.framework.prefs

import edu.wpi.first.wpilibj.Preferences
import org.usfirst.frc5293.framework.util.Logging

class DoublePref(key: String, default: Double) : Pref<Double>(key, default), Logging {

    override fun get(): Double {
        return Preferences.getInstance().getDouble(key, default)
    }

    override fun set(value: Double) {
        super.set(value)
        Preferences.getInstance().putDouble(key, value)
    }
}
