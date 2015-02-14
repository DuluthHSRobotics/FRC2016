package org.usfirst.frc5293;

import org.usfirst.frc5293.prefs.EaseIn;
import org.usfirst.frc5293.prefs.util.PrefGroup;
import org.usfirst.frc5293.prefs.ToteElevator;
import org.usfirst.frc5293.prefs.util.Pref;

import java.util.ArrayList;
import java.util.List;

public final class Prefs {

    // TOOD: Have global switch to completely disable the remote settings if we need to
    private static EaseIn easeIn;
    private static ToteElevator toteElevator;

    private static List<PrefGroup> groups = new ArrayList<>();

    public static void init() {
        easeIn = new EaseIn();
        groups.add(easeIn);

        toteElevator = new ToteElevator();
        groups.add(toteElevator);

        // Try to read in all the current settings and then push all the defaults otherwise
        // TODO: This is trying to fix that stupid bug where there was either a delay trying to get
        //       the remote settings
        refreshAll();
    }

    private static void refreshAll() {
        groups.stream()
              .flatMap(group -> group.getAll().stream())
              .forEach(Pref::refresh);
    }

    public static EaseIn getEaseIn() {
        return easeIn;
    }

    public static ToteElevator getToteElevator() {
        return toteElevator;
    }
}
