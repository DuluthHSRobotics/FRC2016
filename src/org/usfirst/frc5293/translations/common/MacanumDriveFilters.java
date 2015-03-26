package org.usfirst.frc5293.translations.common;

import org.usfirst.frc5293.translations.util.DrivingState;

public class MacanumDriveFilters {
    public static DrivingState applyInversions(DrivingState state) {
        state.x *= -1;
        state.y *=  1;
        state.r *= -1;
        return state;
    }
}
