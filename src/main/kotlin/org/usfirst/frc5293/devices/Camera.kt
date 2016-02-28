package org.usfirst.frc5293.devices

import edu.wpi.first.wpilibj.Relay
import edu.wpi.first.wpilibj.Servo

class Camera(val sideServo: Servo, val topServo: Servo)

class CameraRingLight(val relay: Relay)