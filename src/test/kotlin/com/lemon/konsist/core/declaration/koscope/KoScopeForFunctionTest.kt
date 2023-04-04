package com.lemon.konsist.core.declaration.koscope

import com.lemon.konsist.TestSnippetProvider
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoScopeForFunctionTest {

    @Test
    fun `file-with-one-function`() {
        // given
        val sut = getSut("file-with-one-function")

        // then
        sut
            .functions()
            .map { it.name } shouldBeEqualTo listOf("sampleFunction")
    }

    @Test
    fun `file-without-function`() {
        // given
        val sut = getSut("file-without-function")

        // then
        sut
            .functions()
            .isEmpty()
    }

    @Test
    fun `file-with-two-functions-with-nested-function includeNested true`() {
        // given
        val sut = getSut("file-with-two-functions-with-nested-function")

        // then
        sut
            .functions(includeNested = true)
            .map { it.name } shouldBeEqualTo listOf("sampleFunction1", "sampleFunction2")
    }

    @Test
    fun `file-with-two-functions-with-nested-function includeNested false`() {
        // given
        val sut = getSut("file-with-two-functions-with-nested-function")

        // then
        sut
            .functions(includeNested = false)
            .map { it.name } shouldBeEqualTo listOf("sampleFunction1", "sampleFunction2")
    }

    private fun getSut(fileName: String) = TestSnippetProvider.getSnippetKoScope("koscope/snippet/forfunction/$fileName.kttxt")
}