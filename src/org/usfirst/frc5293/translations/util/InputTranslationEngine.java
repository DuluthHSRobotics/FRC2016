package org.usfirst.frc5293.translations.util;

import java.util.function.Function;

public abstract class InputTranslationEngine<T> {

    private OperationPipeline<T> pipeline;

    public InputTranslationEngine(OperationPipeline<T> pipeline) {
        this.pipeline = pipeline;
    }

    public T getResult(T state) {
        for (Function<T, T> op : pipeline.getOperations()) {
            state = op.apply(state);
        }

        return state;
    }
}
