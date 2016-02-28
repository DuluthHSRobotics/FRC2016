package org.usfirst.frc5293

import org.usfirst.frc5293.prefs.Root
import org.usfirst.frc5293.prefs.util.DoublePref
import org.usfirst.frc5293.prefs.util.Pref
import org.usfirst.frc5293.prefs.util.PrefGroup
import org.usfirst.frc5293.util.LazyGroup

import java.util.ArrayList

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
