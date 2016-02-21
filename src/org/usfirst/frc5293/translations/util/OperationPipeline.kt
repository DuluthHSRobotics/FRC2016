package org.usfirst.frc5293.translations.util

interface  OperationPipeline<T> {
    val operations: List<(T) -> T>

    fun getResult(initial: T) = operations.fold(initial) { x, f -> f(x) }
}
