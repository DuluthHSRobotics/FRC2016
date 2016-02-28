package org.usfirst.frc5293.prefs.util

abstract class Pref<T>(
        val key: String,

        /**
         * Get the default preference value
         * @return the default preference value
         */
        val default: T) {

    /**
     * @return the current preference value
     */
    abstract fun get(): T

    /**
     * Updates the current preference value
     * @param value the value to set
     */
    abstract fun set(value: T)

    /**
     * Gets these current value and checks if it is set to the default value
     * @return if the current value is equal to the default value
     */
    val isDefault: Boolean
        get() = get() == default

    /**
     * Forcibly pushes the default value set at construction time.
     * NOTE: This will override the current setting with the default.
     */
    fun reset() {
        set(default)
    }

    /**
     * Refreshes the current preference value by pushing the current setting
     */
    fun refresh() {
        set(get() ?: default)
    }
}
