package org.usfirst.frc5293.framework.input

import edu.wpi.first.wpilibj.buttons.Trigger

object NullTrigger : Trigger() {
    override fun get() = false
}

