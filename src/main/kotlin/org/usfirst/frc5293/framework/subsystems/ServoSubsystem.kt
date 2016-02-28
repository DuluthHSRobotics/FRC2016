package org.usfirst.frc5293.framework.subsystems

interface ServoSubsystem : VariableSubsystem {
    override var value: Double
    var angle: Double
}