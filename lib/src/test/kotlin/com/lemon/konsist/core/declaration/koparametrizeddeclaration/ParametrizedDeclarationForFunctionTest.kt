package com.lemon.konsist.core.declaration.koparametrizeddeclaration

import com.lemon.konsist.TestSnippetProvider
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class ParametrizedDeclarationForFunctionTest {
    @Test
    fun `function-contains-no-parameters`() {
        // given
        val sut = getSnippetFile("function-contains-no-parameters")
            .functions()
            .first()

        // then
        sut.parameters shouldBeEqualTo emptyList()
    }

    @Test
    fun `function-contains-parameter`() {
        // given
        val sut = getSnippetFile("function-contains-parameter")
            .functions()
            .first()

        // then
        sut
            .parameters
            .run {
                size shouldBeEqualTo 1
                first().name shouldBeEqualTo "sampleParameter"
            }
    }

    @Test
    fun `function-has-parameter`() {
        // given
        val sut = getSnippetFile("function-has-parameter")
            .functions()
            .first()

        // then
        sut.run {
            hasParameterNamed("sampleProperty") shouldBeEqualTo true
            hasParameterNamed("otherProperty") shouldBeEqualTo false
        }
    }

    private fun getSnippetFile(fileName: String) =
        TestSnippetProvider.getSnippetKoScope("core/declaration/koparametrizeddeclaration/snippet/forfunction/", fileName)
}