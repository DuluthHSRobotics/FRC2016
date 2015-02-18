package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc5293.Prefs;

public final class ToteElevatorCompetition implements ToteElevator {
    private final CANTalon master;
    private final CANTalon slave;
    private final DigitalInput bottomLimitSwitch;

    public ToteElevatorCompetition() {
        master = new CANTalon(0);

        if (Prefs.getToteElevator().getIsVoltageRampEnabled().get()) {
            master.setVoltageRampRate(Prefs.getToteElevator().getVoltageRamp().get());
        }

        // Put the other Talon SRX in Follower mode so that it will just follow what the talon
        slave = new CANTalon(1);
        slave.changeControlMode(CANTalon.ControlMode.Follower);
        slave.set(master.getDeviceID());

        bottomLimitSwitch = new DigitalInput(4);
        LiveWindow.addSensor("Tote Elevator", "Button Limit Switch", bottomLimitSwitch);
    }

    public SpeedController getController() {
        return master;
    }

    public DigitalInput getBottomLimitSwitch() {
        return bottomLimitSwitch;
    }
}

