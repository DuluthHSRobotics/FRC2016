package org.usfirst.frc5293.util.preferences;

public abstract class Pref<T> {
    protected final String key;
    protected final T defaultValue;

    public Pref(String key, T defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
        set(defaultValue);
    }

    public abstract T get();

    public abstract void set(T value);
}
