package com.lemonappdev.sample

import com.lemonappdev.sample.LibClass

/**
 * Lib KDoc
 */
@Suppress("lib_argument")
class LibClass(val libParameter: String) : LibInterface {
    constructor(otherParameter: Int) : this(otherParameter.toString())

    init {
        println("Lib init block")
    }
}

interface LibInterface

var libProperty: LibClass = LibClass("")
    get() = LibClass("lib value")
    private set

object LibObject

enum class LibEnumClass {
    APP_CONSTANT
}

fun libFunction() {
    println("some text")
}

typealias libTypeAlias = String
