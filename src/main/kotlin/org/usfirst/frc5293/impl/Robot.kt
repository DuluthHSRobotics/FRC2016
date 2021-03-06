package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.util.Logging

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
class Robot : IterativeRobot(), Logging {

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    override fun robotInit() {
        // The order of initialization is important!
        val groups = listOf(
                Prefs,
                Devices,
                Subsystems,
                TeleopControls,
                AutonomousControls,
                SensorControls)

        groups.forEach { it.init() }

        AutonomousControls.cancelAll()
        TeleopControls.cancelAll()
        SensorControls.startAll()

        logger.info("Successfully initialized robot")
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    override fun disabledInit() {
        LiveWindow.setEnabled(false)

        AutonomousControls.cancelAll()
        TeleopControls.cancelAll()
    }

    override fun disabledPeriodic() {
        Scheduler.getInstance().run()

        logger.info("Auto Power -> ${Prefs.autonomous.drivePower.get()}")
        logger.info("Auto Time -> ${Prefs.autonomous.driveTime.get()}")
    }

    override fun autonomousInit() {
        TeleopControls.cancelAll()
        AutonomousControls.startAll()
        SensorControls.startAll()
    }

    /**
     * This function is called periodically during autonomous
     */
    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopInit() {
        AutonomousControls.cancelAll()
        TeleopControls.startAll()
        SensorControls.startAll()
    }

    /**
     * This function is called periodically during operator control
     */
    override fun teleopPeriodic() {
        // track currently running commands
        SmartDashboard.putData(Scheduler.getInstance())
        Scheduler.getInstance().run()
    }

    override fun testInit() {
        SensorControls.startAll()
        LiveWindow.setEnabled(true)
    }

    /**
     * This function is called periodically during test mode
     */
    override fun testPeriodic() {
        LiveWindow.run()
    }
}
