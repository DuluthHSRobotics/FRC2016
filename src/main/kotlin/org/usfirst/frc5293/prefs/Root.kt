package org.usfirst.frc5293.prefs

import org.usfirst.frc5293.Prefs
import org.usfirst.frc5293.prefs.util.DoublePref
import org.usfirst.frc5293.prefs.util.Pref
import org.usfirst.frc5293.prefs.util.PrefGroup
import org.usfirst.frc5293.util.LazyGroup

import java.util.ArrayList

class Root : LazyGroup("Prefs/Root"), PrefGroup {
    // ... there is nothing really here

    val shooterLiftSpeed by lazyByRequest {
        val x = DoublePref("Shooter Lift Power", 0.50)
        all.add(x)
        x
    }

    val shooterWheelSpeed by lazyByRequest {
        val x = DoublePref("Shooter Wheel Power", 1.0)
        all.add(x)
        x
    }

    override val all: MutableList<Pref<*>> = arrayListOf()
}
