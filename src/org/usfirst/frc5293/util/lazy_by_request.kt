package org.usfirst.frc5293.util

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
        require(lazy.isInitialized(), { "Failed to init lazy prop" })

        println("[init] prop: '${property.name}' = `$value`")
        return value
    }
}

fun <T> lazyByRequest(source: LazySource, initializer: () -> T) = LazyByRequest(source, initializer)

abstract class LazyGroup(val name: String) : Initializable {

    private val source = LazySource()

    override fun init() {
        println("[init] group: '$name'")
        source.invalidate()
    }

    protected fun <T> lazyByRequest(initializer: () -> T) =
            LazyByRequest(source, initializer)
}