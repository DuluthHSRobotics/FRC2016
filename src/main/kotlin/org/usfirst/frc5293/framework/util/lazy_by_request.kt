package org.usfirst.frc5293.framework.util

import kotlin.reflect.KProperty

class LazySource {
    private val registrations: MutableList<Lazy<*>> = arrayListOf()

    fun <T> register(lazy: Lazy<T>) {
        registrations.add(lazy)
    }

    fun invalidate() {
        registrations.forEach { it.value }
    }
}

class LazyByRequest<T>(
        source: LazySource,
        initializer: () -> T) {

    val lazy = lazy<T>(LazyThreadSafetyMode.SYNCHRONIZED, initializer)

    init {
        source.register(lazy)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        // Access the value to invalidate it
        val value = lazy.value
//        require(lazy.isInitialized(), { "Failed to init lazy prop" })

//        println("[init] prop: '${property.name}' = `$value`")
        return value
    }
}

fun <T> lazyByRequest(source: LazySource, initializer: () -> T) = LazyByRequest(source, initializer)

abstract class LazyGroup() : Initializable {

    protected val lazySource = LazySource()

    override fun init() {
        lazySource.invalidate()
    }

    protected open fun <T> lazyByRequest(initializer: () -> T) =
            LazyByRequest(lazySource, initializer)
}

abstract class DelegatedLazyGroup(private val actualGroup: LazyGroup) : LazyGroup(), Initializable {

    override fun init() {
        actualGroup.init()
    }

    override fun <T> lazyByRequest(initializer: () -> T) =
            LazyByRequest(actualGroup.lazySource, initializer)
}
