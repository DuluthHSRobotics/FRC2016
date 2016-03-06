package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
class Robot : IterativeRobot() {

    private var autonomousCommand: Command? = null

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    override fun robotInit() {
        // The order of initialization is important!
        val roots = listOf(Prefs, Devices, Inputs, Subsystems, Controls)
        roots.forEach { it.init() }

        // create the command used for the autonomous period
        autonomousCommand = null // disable autonomous
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    override fun disabledInit() {
        LiveWindow.setEnabled(false)

        if (autonomousCommand != null) {
            autonomousCommand?.cancel()
        }

        Controls.cancelAll()
    }

    override fun disabledPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun autonomousInit() {
        if (autonomousCommand != null) {
            autonomousCommand?.start()
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
            autonomousCommand?.cancel()
        }

        Controls.startAll()
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
        LiveWindow.setEnabled(true)
    }

    /**
     * This function is called periodically during test mode
     */
    override fun testPeriodic() {
        LiveWindow.run()
    }
}
