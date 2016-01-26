package org.usfirst.frc5293.translations.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class OperationPipeline<T> {

    protected final List<Function<T, T>> ops = new ArrayList<>();

    protected List<Function<T, T>> getOperations() {
        return ops;
    }
}
