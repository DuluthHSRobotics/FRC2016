package org.usfirst.frc5293.translations.util

abstract class StreamingTranslationEngine<T>(private val pipeline: OperationPipeline<T>) {

    protected abstract val initial: T

    val result = pipeline.getResult(initial)
}
