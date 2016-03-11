package org.usfirst.frc5293.tests

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldEqual
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.lazyByRequest

class LazyGroupSpecs: Spek() { init {

    given("Lazy group with an example property") {
        val group = object : LazyGroup() {
            val price by lazyByRequest {
                2.99
            }
        }

        on("trying to intialize the group") {
            group.init()

            it("should result the property being initlaized") {
                shouldEqual(group.price, 2.99)
            }
        }
    }
}}