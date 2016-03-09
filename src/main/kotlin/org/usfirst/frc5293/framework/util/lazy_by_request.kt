package org.usfirst.frc5293.framework.util

import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class LazySink {
    val registrations: MutableList<Lazy<*>> = arrayListOf()

    fun <T> register(lazy: Lazy<T>) {
        registrations.add(lazy)
    }

    fun invalidate() {
        registrations.forEach { it.value }
    }
}

class LazyByRequest<T>(
        sink: LazySink,
        initializer: () -> T) {

    val lazy = lazy<T>(initializer)

    init {
        sink.register(lazy)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return lazy.value
    }
}

fun <T> lazyByRequest(sink: LazySink, initializer: () -> T) = LazyByRequest(sink, initializer)

abstract class LazyGroup() : Initializable {

    protected val sink = LazySink()

    protected val subgroups: MutableList<Any> = arrayListOf()

    override fun init() {
        sink.invalidate()
    }

    protected open fun <T> lazyByRequest(initializer: () -> T) =
            LazyByRequest(sink, initializer)

//    protected fun add(group: LazyGroup) {
//        subgroups.add(group)
//    }
}

//abstract class DelegatedLazyGroup(private val actualGroup: LazyGroup) : LazyGroup(), Initializable {
//
//    init {
//        actualGroup.add(this)
//    }
//
//    override fun init() {
//        actualGroup.init()
//    }
//
//    override fun <T> lazyByRequest(initializer: () -> T) =
//            LazyByRequest(actualGroup.sink, initializer)
//}