package org.usfirst.frc5293.impl

import org.usfirst.frc5293.framework.prefs.DoublePref
import org.usfirst.frc5293.framework.prefs.Pref
import org.usfirst.frc5293.framework.prefs.PrefGroup
import org.usfirst.frc5293.framework.util.LazyGroup

object Prefs : LazyGroup() {

    // TOOD: Have global switch to completely disable the remote settings if we need to
    val root by lazyByRequest { Root() }

    val groups by lazyByRequest { listOf(root) }

    override fun init() {
        super.init()

        // Try to read in all the current settings and then push all the defaults otherwise
        // TODO: This is trying to fix that stupid bug where there was either a delay trying to get
        //       the remote settings
        refreshAll()
    }

    private fun refreshAll() {
        groups
            .flatMap({ it.all })
            .forEach({ it.refresh() })
    }
}

class Root: PrefGroup {

    override val all: MutableList<Pref<*>> = arrayListOf()

    val winchSpeedScale = {
        val x = DoublePref("[Pref] Winch Speed Scale", 0.2)
        all.add(x)
        x
    }()

    val shooterKickerAngle = {
        val x = DoublePref("[Pref] Shooter Kicker Angle", 90.0)
        all.add(x)
        x
    }()

    val shooterKickerDelay = {
        val x = DoublePref("[Pref] Shooter Kicker Delay (secs)", 2.0)
        all.add(x)
        x
    }()
}
