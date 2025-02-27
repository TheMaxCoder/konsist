package com.lemonappdev.konsist.api.provider

import com.lemonappdev.konsist.api.declaration.KoTypeDeclaration
import kotlin.reflect.KClass

/**
 * An interface representing a Kotlin declaration that provides access to its receiver type information.
 */
interface KoReceiverTypeProvider : KoBaseProvider {
    /**
     * Receiver type of the declaration.
     */
    val receiverType: KoTypeDeclaration?

    /**
     * Whether declaration has receiver type.
     *
     * @param name the receiver type to check.
     * @return `true` if the declaration has receiver type with the specified name, `false` otherwise.
     */
    @Deprecated("Will be removed in v1.0.0", ReplaceWith("hasReceiverType { it.name == name }"))
    fun hasReceiverType(name: String): Boolean

    /**
     * Whether declaration has a specified receiver type.
     *
     * @param predicate The predicate function used to determine if a declaration receiver type satisfies a condition.
     * @return `true` if the declaration has the specified receiver type (or any receiver type if [predicate] is `null`), `false` otherwise.
     */
    fun hasReceiverType(predicate: ((KoTypeDeclaration) -> Boolean)? = null): Boolean

    /**
     * Whether declaration has a receiver type of the specified Kotlin class.
     *
     * @param kClass The Kotlin class representing the receiver type to check for.
     * @return `true` if the declaration has a receiver type matching the specified KClass, `false` otherwise.
     */
    fun hasReceiverTypeOf(kClass: KClass<*>): Boolean
}
