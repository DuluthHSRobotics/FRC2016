package org.usfirst.frc5293;

import org.usfirst.frc5293.prefs.Drivetrain;
import org.usfirst.frc5293.prefs.Root;
import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;

import java.util.ArrayList;
import java.util.List;

public final class Prefs {

    // TOOD: Have global switch to completely disable the remote settings if we need to
    private static Root root;
    private static Drivetrain drivetrain;

    private static List<PrefGroup> groups = new ArrayList<>();

    public static void init() {
        root = new Root();
        groups.add(root);

        drivetrain = new Drivetrain();
        groups.add(drivetrain);

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

    public static Root getRoot() {
        return root;
    }

    public static Drivetrain getDrivetrain() {
        return drivetrain;
    }
}
