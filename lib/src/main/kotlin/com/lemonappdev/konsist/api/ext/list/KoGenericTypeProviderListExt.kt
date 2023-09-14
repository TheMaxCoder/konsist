package com.lemonappdev.konsist.api.ext.list

import com.lemonappdev.konsist.api.provider.KoGenericTypeProvider

/**
 * List containing declarations with generic type.
 *
 * @return A list containing declarations with the generic types.
 */
fun <T : KoGenericTypeProvider> List<T>.withGenericType(): List<T> = filter { it.isGenericType }

/**
 * List containing declarations without generic type.
 *
 * @return A list containing declarations without the generic types.
 */
fun <T : KoGenericTypeProvider> List<T>.withoutGenericType(): List<T> = filterNot { it.isGenericType }
