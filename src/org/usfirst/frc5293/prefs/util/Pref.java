package org.usfirst.frc5293.prefs.util;

public abstract class Pref<T> {
    protected final String key;
    protected final T defaultValue;

    public Pref(String key, T defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    /**
     * @return the current preference value
     */
    public abstract T get();

    /**
     * Updates the current preference value
     * @param value the value to set
     */
    public abstract void set(T value);

    /**
     * Gets these current value and checks if it is set to the default value
     * @return if the current value is equal to the default value
     */
    public boolean isDefault() {
        return !get().equals(getDefault());
    }

    /**
     * Get the default preference value
     * @return the default preference value
     */
    public T getDefault() {
        return defaultValue;
    }

    /**
     * Forcibly pushes the default value set at construction time.
     * NOTE: This will override the current setting with the default.
     */
    public void forcePushDefault() {
        set(defaultValue);
    }

    /**
     * Refreshes the current preference value by pushing the current setting
     */
    public void refresh() {
        set(get());
    }
}
