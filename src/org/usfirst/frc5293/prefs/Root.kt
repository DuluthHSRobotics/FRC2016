package org.usfirst.frc5293.prefs

import org.usfirst.frc5293.prefs.util.Pref
import org.usfirst.frc5293.prefs.util.PrefGroup

import java.util.ArrayList

class Root : PrefGroup {
    // ... there is nothing really here

    override val all: List<Pref<*>> = ArrayList()
}
