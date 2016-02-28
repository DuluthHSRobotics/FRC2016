package org.usfirst.frc5293.framework.subsystems

enum class Direction {
    NONE,
    UP,
    DOWN
}

interface DirectionalSubsystem {
    var direction: Direction

    fun up() {
        direction = Direction.UP
    }

    fun down() {
        direction = Direction.DOWN
    }

    fun stop() {
        direction = Direction.NONE
    }
}