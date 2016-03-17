package org.usfirst.frc5293.framework.util

import kotlin.reflect.KClass
import kotlin.reflect.KProperty

sealed class LazyContainer<T>() {
    abstract fun invalidate(): T

    class OfLazy<T>(private val lazy: Lazy<T>) : LazyContainer<T>() {
        override fun invalidate(): T {
            return lazy.value
        }
    }

    class OfFunction<T>(private val factory: () -> T) : LazyContainer<T>() {
        fun create(): T {
            return factory.invoke()
        }

        override fun invalidate(): T {
            return create()
        }
    }
}

class LazySink {

    val registrations: MutableList<LazyContainer<*>> = arrayListOf()

    fun <T> registerLazy(lazy: Lazy<T>): LazyContainer.OfLazy<T> {
        val x = LazyContainer.OfLazy(lazy)
        registrations.add(x)
        return x
    }

    fun <T> registerLazy(initializer: () -> T): LazyContainer.OfLazy<T> {
        return registerLazy(lazy(initializer))
    }

    fun <T> registerFactory(factory: () -> T): LazyContainer.OfFunction<T> {
        val f = LazyContainer.OfFunction(factory)
        registrations.add(f)
        return f
    }

    fun invalidate() {
        registrations.forEach {
            it.invalidate()
        }
    }
}

class SinkedLazyProperty<T>(
        sink: LazySink,
        initializer: () -> T) {

    val container = sink.registerLazy(initializer)

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return container.invalidate()
    }
}

class SinkedFactoryProperty<T>(
        sink: LazySink,
        initializer: () -> T) {

    val container = sink.registerFactory(initializer)

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return container.create()
    }
}

class FactoryProperty<T>(
        private val initializer: () -> T) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return initializer()
    }
}

fun <T> factory(initializer: () -> T): FactoryProperty<T> = FactoryProperty(initializer)

abstract class LazyGroup() : Initializable {

    protected val sink = LazySink()

    protected val subgroups: MutableList<Any> = arrayListOf()

    override fun init() {
        sink.invalidate()
    }

    protected open fun <T> lazyByRequest(initializer: () -> T) =
            SinkedLazyProperty(sink, initializer)

    protected open fun <T> factoryByRequest(initializer: () -> T) =
            SinkedFactoryProperty(sink, initializer)
}