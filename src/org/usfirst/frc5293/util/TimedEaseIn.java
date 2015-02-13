package org.usfirst.frc5293.util;

public class TimedEaseIn {
    private final long duration;
    private final double start;
    private final double change;

    private long startMs = 0;

    public TimedEaseIn(double start, double change, long duration) {
        this.start = start;
        this.change = change;
        this.duration = duration;
    }

    public double loop() {
        if (startMs == 0) {
            startMs = System.currentTimeMillis();
        }

        long deltaMs = System.currentTimeMillis() - startMs;

        return MathUtil.easeInQuad(deltaMs, start, change, duration);
    }

    public void reset() {
        startMs = 0;
    }
}
