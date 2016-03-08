package org.usfirst.frc5293.framework.util

import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class LazySink {
    // Using an algebraic data type allows us to represent child lazy objects and sinks as the same
    // thing so that we can keep the order the registrations

    sealed class Child private constructor() { // private constructor to prevent creating more subclasses outside
        class OfLazy(val value: Lazy<*>) : Child()
        class OfSink(val sink: LazySink) : Child()
    }

    private val _registrations: MutableList<Child> = arrayListOf()

    val registrations = _registrations.toList()

    fun <T> register(lazy: Lazy<T>) {
        _registrations.add(Child.OfLazy(lazy))
    }

    fun register(sink: LazySink) {
        _registrations.add(Child.OfSink(sink))
    }

    fun invalidate() {
        _registrations.forEach {
            when (it) {
                is Child.OfLazy ->
                    // reference the lazy object to invalidate it
                    it.value

                is Child.OfSink ->
                    it.sink.invalidate()
            }
        }
    }
}

class LazyByRequest<T>(
        sink: LazySink,
        initializer: () -> T) {

    val lazy = lazy(LazyThreadSafetyMode.SYNCHRONIZED, initializer)

    init {
        sink.register(lazy)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        // Reference the value to invalidate it
        val value = lazy.value
        return value
    }
}

fun <T> lazyByRequest(sink: LazySink, initializer: () -> T) = LazyByRequest(sink, initializer)

abstract class LazyGroup(
        private val parent: LazyGroup? = null,
        private val sink: LazySink = LazySink()) : Initializable {

    init {
        parent?.register(this)
    }

    /**
     * Property available for convince when attaching child `LazyGroups` to this parent group
     */
    protected val asChild = this

    override fun init() {
        sink.invalidate()
    }

    protected fun <T> lazyByRequest(sink: LazySink, initializer: () -> T): LazyByRequest<T> {
        return LazyByRequest(sink, initializer)
    }

    protected inline fun <reified T> lazyByRequest(noinline initializer: () -> T): LazyByRequest<T> {
        val clazz = T::class
        val actualSink = onChooseSink(clazz)
        return lazyByRequest(actualSink, initializer)
    }

    fun register(child: LazySink) {
        sink.register(child)
    }

    fun register(child: LazyGroup) {
        register(child.sink)
    }

    /**
     * Override this function if you want to filter `initializer` blocks to that you can register
     * them to a different `LazySink` than the default one depending on the `initializer`'s type.
     *
     * Return a non-null `LazySink` to use that one instead of the default one for the `initializer`.
     */
    open fun onChooseSink(clazz: KClass<*>, defaultSink: LazySink = sink): LazySink = defaultSink
}
