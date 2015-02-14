package org.usfirst.frc5293;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc5293.util.CustomRobotDrive;

/**
 * The Devices is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Devices {
    public static final class ToteElevator {
        private static CANTalon master;
        private static CANTalon slave;
        private static DigitalInput bottomLimitSwitch;

        public static void init() {
            master = new CANTalon(0);

            if (Prefs.getToteElevator().getIsVoltageRampEnabled().get()) {
                master.setVoltageRampRate(Prefs.getToteElevator().getVoltageRamp().get());
            }

            // TODO: For what ever reason we cannot directly connect the CANTalon to LiveWindow since it does not implement
            // TODO: the LiveWindowSendable interface.
//            LiveWindow.addActuator("Tote Elevator", "TalonSRX 4", (CANTalon) master);

            // Put the other Talon SRX in Follower mode so that it will just follow what the talon
            slave = new CANTalon(1);
            slave.changeControlMode(CANTalon.ControlMode.Follower);
            slave.set(master.getDeviceID());
//            LiveWindow.addActuator("Tote Elevator", "TalonSRX 5", (CANTalon) slave);

            bottomLimitSwitch = new DigitalInput(4);
            LiveWindow.addSensor("Tote Elevator", "Button Limit Switch", ToteElevator.bottomLimitSwitch);
        }

        public static CANTalon getMaster() {
            return master;
        }

        public static CANTalon getSlave() {
            return slave;
        }

        public static DigitalInput getBottomLimitSwitch() {
            return bottomLimitSwitch;
        }
    }

    public static final class Drivetrain {
        private static final int FRONT_LEFT_ID = 1;
        private static final int BACK_LEFT_ID = 0;
        private static final int FRONT_RIGHT_ID = 3;
        private static final int BACK_RIGHT_ID = 2;

        private static SpeedController frontLeft;
        private static SpeedController backLeft;
        private static SpeedController frontRight;
        private static SpeedController backRight;
        private static CustomRobotDrive control;

        public static void init() {
            frontLeft = new Talon(FRONT_LEFT_ID);
            LiveWindow.addActuator("Drivetrain", "Front Left (Talon)", (Talon) frontLeft);

            backLeft = new Talon(BACK_LEFT_ID);
            LiveWindow.addActuator("Drivetrain", "Back Left (Talon)", (Talon) backLeft);

            frontRight = new Talon(FRONT_RIGHT_ID);
            LiveWindow.addActuator("Drivetrain", "Front Right (Talon)", (Talon) frontRight);

            backRight = new Talon(BACK_RIGHT_ID);
            LiveWindow.addActuator("Drivetrain", "Back Right (Talon)", (Talon) backRight);

            control = new CustomRobotDrive(
                    frontLeft, backLeft,
                    frontRight, backRight);

            control.setInvertedMotor(CustomRobotDrive.MotorType.FRONT_LEFT, true);
            control.setInvertedMotor(CustomRobotDrive.MotorType.BACK_LEFT, true);
            control.setSafetyEnabled(true);
            control.setExpiration(0.1);
            control.setSensitivity(0.5);
            control.setMaxOutput(1.0);
        }

        public static SpeedController getFrontLeft() {
            return frontLeft;
        }

        public static SpeedController getBackLeft() {
            return backLeft;
        }

        public static SpeedController getFrontRight() {
            return frontRight;
        }

        public static SpeedController getBackRight() {
            return backRight;
        }

        public static CustomRobotDrive getControl() {
            return control;
        }
    }

    public static final class BinElevator {
        private static SpeedController victor;
        private static DoubleSolenoid left;
        private static DoubleSolenoid right;

        public static void init() {
            victor = new VictorSP(6);
            LiveWindow.addActuator("Bin Elevator", "Victor SP 6", (VictorSP) victor);

            left = new DoubleSolenoid(0, 0, 1);
            LiveWindow.addActuator("Bin Grabber", "Double Sol Grabber (Left)", left);

            right = new DoubleSolenoid(1, 0, 1);
            LiveWindow.addActuator("Bin Grabber", "Double Sol Grabber (Right)", right);
        }

        public static SpeedController getVictor() {
            return victor;
        }

        public static DoubleSolenoid getLeft() {
            return left;
        }

        public static DoubleSolenoid getRight() {
            return right;
        }
    }

    public static void init() {
        Drivetrain.init();
        ToteElevator.init();
        BinElevator.init();
    }
}
