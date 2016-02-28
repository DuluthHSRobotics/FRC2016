package org.usfirst.frc5293.groups.lift

enum class Direction {
    NONE,
    UP,
    DOWN
}

interface LiftSubsystem {
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