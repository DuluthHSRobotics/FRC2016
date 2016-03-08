package org.usfirst.frc5293.framework.input

import edu.wpi.first.wpilibj.buttons.Button

object NullButton : Button() {
    override fun get() = false
}