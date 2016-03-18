package org.usfirst.frc5293.impl

import org.usfirst.frc5293.framework.prefs.BooleanPref
import org.usfirst.frc5293.framework.prefs.DoublePref
import org.usfirst.frc5293.framework.prefs.Pref
import org.usfirst.frc5293.framework.prefs.PrefGroup
import org.usfirst.frc5293.framework.util.LazyGroup

object Prefs : LazyGroup() {

    // TOOD: Have global switch to completely disable the remote settings if we need to
    val root by lazyByRequest { Root() }

    val autonomous by lazyByRequest { AutonomousPrefs() }

    val sensors by lazyByRequest { Sensors() }

    val shooterWheels by lazyByRequest { ShooterWheels() }

    val groups by lazyByRequest { listOf(root, autonomous, shooterWheels) }

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

    val windowMotorScaling = {
        val x = DoublePref("[Pref] Window Motor Power Scale", 1.0)
        all.add(x)
        x
    }()

    val shooterKickerAngle = {
        val x = DoublePref("[Pref] Shooter Kicker Angle", 90.0)
        all.add(x)
        x
    }()

    val isDrivetrainEnabled = {
        val x = BooleanPref("[Pref] Drivetrain Enabled", true)
        all.add(x)
        x
    }()
}

class AutonomousPrefs: PrefGroup {

    override val all: MutableList<Pref<*>> = arrayListOf()

    val drivePower = {
        val x = DoublePref("[Pref] Auto - Drive Power", -0.80)
        all.add(x)
        x
    }()

    val driveTime = {
        val x = DoublePref("[Pref] Auto - Drive Time (secs)", 3.0)
        all.add(x)
        x
    }()
}

class Sensors : PrefGroup {

    override val all: MutableList<Pref<*>> = arrayListOf()

    val gyroAngle = {
        val x = DoublePref("[Sensor] Gyro Angle", 0.0)
        all.add(x)
        x
    }()
}

class ShooterWheels : PrefGroup {

    override val all: MutableList<Pref<*>> = arrayListOf()

    val intakePower = {
        val x = DoublePref("[Pref] Shooter Wheel - Intake Power", -0.3)
        all.add(x)
        x
    }()

    val outtakePower = {
        val x = DoublePref("[Pref] Shooter Wheel - Outtake Power", 1.0)
        all.add(x)
        x
    }()
}
