package com.lemonappdev.konsist.api.architecture

import com.lemonappdev.konsist.core.exception.KoPreconditionFailedException
import org.amshove.kluent.shouldNotThrow
import org.amshove.kluent.shouldThrow
import org.amshove.kluent.withMessage
import org.junit.jupiter.api.Test

class LayerTest {
    @Test
    fun `throws an exception when layer is defined by package without two dots at the end`() {
        // given
        val sut = { Layer("Domain", "package") }

        // then
        sut shouldThrow KoPreconditionFailedException::class withMessage """
            Layer Domain must be defined by package ending with '..'. Now: package .
        """.trimIndent()
    }

    @Test
    fun `throws an exception when layer is defined by package without two dots at the end with dots as wildcard`() {
        // given
        val sut = { Layer("Domain", "package..feature") }

        // then
        sut shouldThrow KoPreconditionFailedException::class withMessage """
            Layer Domain must be defined by package ending with '..'. Now: package..feature .
        """.trimIndent()
    }

    @Test
    fun `throws an exception when layer is defined by package with three dots at the end`() {
        // given
        val sut = { Layer("Domain", "package...") }

        // then
        sut shouldThrow KoPreconditionFailedException::class withMessage """
            Layer Domain must be defined by package ending with '..'. Now: package... .
        """.trimIndent()
    }

    @Test
    fun `throws an exception when layer is defined by package with dots without two dots at the end`() {
        // given
        val sut = { Layer("Domain", "first.package") }

        // then
        sut shouldThrow KoPreconditionFailedException::class withMessage """
            Layer Domain must be defined by package ending with '..'. Now: first.package .
        """.trimIndent()
    }

    @Test
    fun `throws an exception when layer is defined by package containing dots with more than two dots at the end`() {
        // given
        val sut = { Layer("Domain", "first.second..third_p.package....") }

        // then
        sut shouldThrow KoPreconditionFailedException::class withMessage """
            Layer Domain must be defined by package ending with '..'. Now: first.second..third_p.package.... .
        """.trimIndent()
    }

    @Test
    fun `do not throw an exception when the package ends with two dots`() {
        // given
        val sut = { Layer("Domain", "first.second.package..") }

        // then
        sut shouldNotThrow KoPreconditionFailedException::class withMessage """
            Layer Domain must be defined by package ending with '..'. Now: first.second.third_p.package.... .
        """.trimIndent()
    }

    @Test
    fun `do not throw an exception when the package ends with two dots and there are another two dots used as wildcard`() {
        // given
        val sut = { Layer("Domain", "first.second..package..") }

        // then
        sut shouldNotThrow KoPreconditionFailedException::class withMessage """
            Layer Domain must be defined by package ending with '..'. Now: first.second.third_p.package.... .
        """.trimIndent()
    }

    @Test
    fun `throws an exception when the package ends with two dots and there more than two dots used as wildcard`() {
        // given
        val sut = { Layer("Domain", "first.second..package..feature1..") }

        // then
        sut shouldThrow KoPreconditionFailedException::class withMessage """
            Layer Domain must be defined by package ending with '..'. Now: first.second..package..feature1.. .
        """.trimIndent()
    }
}
