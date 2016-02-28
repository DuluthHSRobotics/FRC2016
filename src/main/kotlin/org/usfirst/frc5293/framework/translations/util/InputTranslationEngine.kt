package org.usfirst.frc5293.framework.translations.util

abstract class InputTranslationEngine<T>(private val pipeline: OperationPipeline<T>) {

    fun getResult(state: T): T = pipeline.getResult(state)
}
