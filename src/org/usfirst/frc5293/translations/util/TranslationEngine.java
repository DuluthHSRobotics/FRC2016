package org.usfirst.frc5293.translations.util;

import java.util.List;
import java.util.function.Function;

public abstract class TranslationEngine<T> {
    protected abstract List<Function<T, T>> getOperations();
}
