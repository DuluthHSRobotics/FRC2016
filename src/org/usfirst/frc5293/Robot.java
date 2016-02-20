package org.usfirst.frc5293;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.commands.AccelerationCommand;
import org.usfirst.frc5293.commands.util.EmptyCommand;

import java.util.Optional;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    private Optional<Command> autonomousCommand = Optional.empty();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Do not change the initialization order as systems that rely
        // on other systems to be previously initialized will break
        Prefs.init();
    	Devices.init();
        Subsystems.init();
        Input.init();

        // create the command used for the autonomous period
        autonomousCommand = Optional.empty(); // disable autonomous

        // create background task for updating the acceleration from the board
        new AccelerationCommand().start();

        // track currently running commands
        SmartDashboard.putData(Scheduler.getInstance());
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {
        autonomousCommand.ifPresent(Command::cancel);
    }

    public void disabledPeriodic() {
    	Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        autonomousCommand.ifPresent(Command::start);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.ifPresent(Command::cancel);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
