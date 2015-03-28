package org.usfirst.frc5293.translations.util;

import java.util.List;
import java.util.function.Function;

public abstract class InputTranslationEngine<T> {
    protected abstract List<Function<T, T>> getOperations();

    public T getResult(T state) {
        for (Function<T, T> op : getOperations()) {
            state = op.apply(state);
        }

        return state;
    }
}
