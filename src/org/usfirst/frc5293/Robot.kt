package org.usfirst.frc5293

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.commands.AccelerationCommand

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
        // Do not change the initialization order as systems that rely
        // on other systems to be previously initialized will break
        Prefs.init()

        // create the command used for the autonomous period
        autonomousCommand = null // disable autonomous

        // create background task for updating the acceleration from the board
        AccelerationCommand().start()

        // track currently running commands
        SmartDashboard.putData(Scheduler.getInstance())
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    override fun disabledInit() {
        if (autonomousCommand != null) {
            autonomousCommand?.cancel()
        }
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
    }

    /**
     * This function is called periodically during operator control
     */
    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }

    /**
     * This function is called periodically during test mode
     */
    override fun testPeriodic() {
        LiveWindow.run()
    }
}
