package org.usfirst.frc5293.translations.util;

import java.util.function.Function;

public abstract class StreamingTranslationEngine<T> {

    private OperationPipeline<T> pipeline;

    public StreamingTranslationEngine(OperationPipeline<T> pipeline) {
        this.pipeline = pipeline;
    }

    protected abstract T getInitial();

    public T getResult() {
        T state = getInitial();

        for (Function<T, T> op : pipeline.getOperations()) {
            state = op.apply(state);
        }

        return state;
    }
}
