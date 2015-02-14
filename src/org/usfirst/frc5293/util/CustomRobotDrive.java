/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc5293.util;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Utility class for handling Robot drive based on a definition of the motor configuration.
 * The robot drive class handles basic driving for a robot. Currently, 2 and 4 motor tank and
 * mecanum drive trains are supported. In the future other drive types like swerve might
 * be implemented. Motor channel numbers are supplied on creation of the class. Those are
 * used for either the drive function (intended for hand created drive code, such as autonomous)
 * or with the Tank/Arcade functions intended to be used for Operator Control driving.
 */
public class CustomRobotDrive implements MotorSafety {

    /**
     * The location of a motor on the robot for the purpose of driving
     */
    public static enum MotorType {
        FRONT_LEFT(0),
        FRONT_RIGHT(1),
        BACK_LEFT(2),
        BACK_RIGHT(3);

        /**
         * The integer value representing the motor type
         */
        public final int value;

        private MotorType(int value) {
            this.value = value;
        }
    }

    public static final double DEFAULT_EXPIRATION_TIME = 0.1;
    public static final double DEFAULT_SENSITIVITY = 0.5;
    public static final double DEFAULT_MAX_OUTPUT = 1.0;
    protected static final int MAX_NUMBER_OF_MOTORS = 4;

    protected static boolean kArcadeRatioCurve_Reported = false;
    protected static boolean kMecanumCartesian_Reported = false;

    protected final int invertedMotors[] = new int[4];
    protected double sensitivity;
    protected double maxOutput;
    protected SpeedController frontLeftMotor;
    protected SpeedController frontRightMotor;
    protected SpeedController backLeftMotor;
    protected SpeedController backRightMotor;
    protected MotorSafetyHelper safetyHelper;

    /**
     * Constructor for CustomRobotDrive with 4 motors specified as SpeedController objects.
     * Speed controller input version of CustomRobotDrive (see previous comments).
     * @param backLeftMotor The back left SpeedController object used to drive the robot.
     * @param frontLeftMotor The front left SpeedController object used to drive the robot
     * @param backRightMotor The back right SpeedController object used to drive the robot.
     * @param frontRightMotor The front right SpeedController object used to drive the robot.
     */
    public CustomRobotDrive(SpeedController frontLeftMotor, SpeedController backLeftMotor,
                            SpeedController frontRightMotor, SpeedController backRightMotor) {
        if (frontLeftMotor == null || backLeftMotor == null || frontRightMotor == null || backRightMotor == null) {
            this.frontLeftMotor = this.backLeftMotor = this.frontRightMotor = this.backRightMotor = null;
            throw new NullPointerException("Null motor provided");
        }

        this.frontLeftMotor = frontLeftMotor;
        this.backLeftMotor = backLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backRightMotor = backRightMotor;
        this.sensitivity = DEFAULT_SENSITIVITY;
        this.maxOutput = DEFAULT_MAX_OUTPUT;

        for (int i = 0; i < MAX_NUMBER_OF_MOTORS; i++) {
            invertedMotors[i] = 1;
        }

        setupMotorSafety();
        drive(0, 0);
    }

    /**
     * Drive the motors at "speed" and "curve".
     *
     * The speed and curve are -1.0 to +1.0 values where 0.0 represents stopped and
     * not turning. The algorithm for adding in the direction attempts to provide a constant
     * turn radius for differing speeds.
     *
     * This function will most likely be used in an autonomous routine.
     *
     * @param outputMagnitude The forward component of the output magnitude to send to the motors.
     * @param curve The rate of turn, constant for different forward speeds.
     */
    public void drive(double outputMagnitude, double curve) {
        double leftOutput, rightOutput;

        if(!kArcadeRatioCurve_Reported) {
            UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(), tInstances.kRobotDrive_ArcadeRatioCurve);
            kArcadeRatioCurve_Reported = true;
        }

        if (curve < 0) {
            double value = Math.log(-curve);
            double ratio = (value - sensitivity) / (value + sensitivity);
            if (ratio == 0) {
                ratio = .0000000001;
            }
            leftOutput = outputMagnitude / ratio;
            rightOutput = outputMagnitude;
        } else if (curve > 0) {
            double value = Math.log(curve);
            double ratio = (value - sensitivity) / (value + sensitivity);
            if (ratio == 0) {
                ratio = .0000000001;
            }
            leftOutput = outputMagnitude;
            rightOutput = outputMagnitude / ratio;
        } else {
            leftOutput = outputMagnitude;
            rightOutput = outputMagnitude;
        }

        setLeftRightMotorOutputs(leftOutput, rightOutput);
    }

    /**
     * Drive method for Mecanum wheeled robots.
     *
     * A method for driving with Mecanum wheeled robots. There are 4 wheels
     * on the robot, arranged so that the front and back wheels are toed in 45 degrees.
     * When looking at the wheels from the top, the roller axles should form an X across the robot.
     *
     * This is designed to be directly driven by joystick axes.
     *
     * @param x The speed that the robot should drive in the X direction. [-1.0..1.0]
     * @param y The speed that the robot should drive in the Y direction.
     * This input is inverted to match the forward == -1.0 that joysticks produce. [-1.0..1.0]
     * @param rotation The rate of rotation for the robot that is completely independent of
     * the translation. [-1.0..1.0]
     * @param gyroAngle The current angle reading from the gyro.  Use this to implement field-oriented controls.
     */
    public void mecanumDrive_Cartesian(double x, double y, double rotation, double gyroAngle) {
        if(!kMecanumCartesian_Reported) {
            UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(), tInstances.kRobotDrive_MecanumCartesian);
            kMecanumCartesian_Reported = true;
        }

        double xIn = x;
        double yIn = y;

        // Negate y for the joystick.
        yIn = -yIn;

        // Compensate for gyro angle.
        double rotated[] = rotateVector(xIn, yIn, gyroAngle);
        xIn = rotated[0];
        yIn = rotated[1];

        double wheelSpeeds[] = new double[MAX_NUMBER_OF_MOTORS];
        wheelSpeeds[MotorType.FRONT_LEFT.value] = xIn + yIn + rotation;
        wheelSpeeds[MotorType.FRONT_RIGHT.value] = -xIn + yIn - rotation;
        wheelSpeeds[MotorType.BACK_LEFT.value] = -xIn + yIn + rotation;
        wheelSpeeds[MotorType.BACK_RIGHT.value] = xIn + yIn - rotation;

        normalize(wheelSpeeds);
        frontLeftMotor.set(wheelSpeeds[MotorType.FRONT_LEFT.value] * invertedMotors[MotorType.FRONT_LEFT.value] * maxOutput);
        frontRightMotor.set(wheelSpeeds[MotorType.FRONT_RIGHT.value] * invertedMotors[MotorType.FRONT_RIGHT.value] * maxOutput);
        backLeftMotor.set(wheelSpeeds[MotorType.BACK_LEFT.value] * invertedMotors[MotorType.BACK_LEFT.value] * maxOutput);
        backRightMotor.set(wheelSpeeds[MotorType.BACK_RIGHT.value] * invertedMotors[MotorType.BACK_RIGHT.value] * maxOutput);

        if (safetyHelper != null) safetyHelper.feed();
    }

    /** Set the speed of the right and left motors.
     * This is used once an appropriate drive setup function is called such as
     * twoWheelDrive(). The motors are set to "leftSpeed" and "rightSpeed"
     * and includes flipping the direction of one side for opposing motors.
     * @param leftOutput The speed to send to the left side of the robot.
     * @param rightOutput The speed to send to the right side of the robot.
     */
    public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
        if (backLeftMotor == null || backRightMotor == null) {
            throw new NullPointerException("Null motor provided");
        }

        if (frontLeftMotor != null) {
            frontLeftMotor.set(limit(leftOutput) * invertedMotors[MotorType.FRONT_LEFT.value] * maxOutput);
        }
        backLeftMotor.set(limit(leftOutput) * invertedMotors[MotorType.BACK_LEFT.value] * maxOutput);

        if (frontRightMotor != null) {
            frontRightMotor.set(-limit(rightOutput) * invertedMotors[MotorType.FRONT_RIGHT.value] * maxOutput);
        }
        backRightMotor.set(-limit(rightOutput) * invertedMotors[MotorType.BACK_RIGHT.value] * maxOutput);

        if (safetyHelper != null) safetyHelper.feed();
    }

    /**
     * Limit motor values to the -1.0 to +1.0 range.
     */
    protected static double limit(double num) {
        if (num > 1.0) {
            return 1.0;
        }
        if (num < -1.0) {
            return -1.0;
        }
        return num;
    }

    /**
     * Normalize all wheel speeds if the magnitude of any wheel is greater than 1.0.
     */
    protected static void normalize(double wheelSpeeds[]) {
        double maxMagnitude = Math.abs(wheelSpeeds[0]);
        int i;
        for (i=1; i < MAX_NUMBER_OF_MOTORS; i++) {
            double temp = Math.abs(wheelSpeeds[i]);
            if (maxMagnitude < temp) maxMagnitude = temp;
        }
        if (maxMagnitude > 1.0) {
            for (i=0; i < MAX_NUMBER_OF_MOTORS; i++) {
                wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
            }
        }
    }

    /**
     * Rotate a vector in Cartesian space.
     */
    protected static double[] rotateVector(double x, double y, double angle) {
        double cosA = Math.cos(angle * (Math.PI / 180.0));
        double sinA = Math.sin(angle * (Math.PI / 180.0));
        double out[] = new double[2];
        out[0] = x * cosA - y * sinA;
        out[1] = x * sinA + y * cosA;
        return out;
    }

    /**
     * Invert a motor direction.
     * This is used when a motor should run in the opposite direction as the drive
     * code would normally run it. Motors that are direct drive would be inverted, the
     * drive code assumes that the motors are geared with one reversal.
     * @param motor The motor index to invert.
     * @param isInverted True if the motor should be inverted when operated.
     */
    public void setInvertedMotor(MotorType motor, boolean isInverted) {
        invertedMotors[motor.value] = isInverted ? -1 : 1;
    }

    /**
     * Set the turning sensitivity.
     *
     * This only impacts the drive() entry-point.
     * @param sensitivity Effectively sets the turning sensitivity (or turn radius for a given value)
     */
    public void setSensitivity(double sensitivity) {
        this.sensitivity = sensitivity;
    }

    /**
     * Configure the scaling factor for using CustomRobotDrive with motor controllers in a mode other than PercentVbus.
     * @param maxOutput Multiplied with the output percentage computed by the drive functions.
     */
    public void setMaxOutput(double maxOutput) {
        this.maxOutput = maxOutput;
    }

    public void setExpiration(double timeout) {
        safetyHelper.setExpiration(timeout);
    }

    public double getExpiration() {
        return safetyHelper.getExpiration();
    }

    public boolean isAlive() {
        return safetyHelper.isAlive();
    }

    public boolean isSafetyEnabled() {
        return safetyHelper.isSafetyEnabled();
    }

    public void setSafetyEnabled(boolean enabled) {
        safetyHelper.setSafetyEnabled(enabled);
    }

    public String getDescription() {
        return "Robot Drive";
    }

    public void stopMotor() {
        if (frontLeftMotor != null) {
            frontLeftMotor.set(0.0);
        }
        if (frontRightMotor != null) {
            frontRightMotor.set(0.0);
        }
        if (backLeftMotor != null) {
            backLeftMotor.set(0.0);
        }
        if (backRightMotor != null) {
            backRightMotor.set(0.0);
        }
        if (safetyHelper != null) safetyHelper.feed();
    }

    private void setupMotorSafety() {
        safetyHelper = new MotorSafetyHelper(this);
        safetyHelper.setExpiration(DEFAULT_EXPIRATION_TIME);
        safetyHelper.setSafetyEnabled(true);
    }

    protected int getNumMotors() {
        int motors = 0;
        if (frontLeftMotor != null) motors++;
        if (frontRightMotor != null) motors++;
        if (backLeftMotor != null) motors++;
        if (backRightMotor != null) motors++;
        return motors;
    }
}
