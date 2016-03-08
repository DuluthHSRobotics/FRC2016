package org.usfirst.frc5293.framework.util

interface Logging {
    val logger: Logger
        get() = Logger(this.javaClass.name)
}

enum class LogLevel(val friendlyName: String) {
    DEBUG("debug"),
    INFO("info"),
    ERROR("error"),
    FATAL("fatal")
}

class Logger(val loggerName: String) {

    private fun format(level: String, message: String): String {
        return "${level.toUpperCase()} [$loggerName] - $message"
    }

    fun log(level: LogLevel, message: String) {
        println(format(level.friendlyName, message))
    }

    fun debug(message: String) = log(LogLevel.DEBUG, message)

    fun info(message: String) = log(LogLevel.INFO, message)
}