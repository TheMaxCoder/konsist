package com.lemonappdev.konsist.core.declaration.koclass

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoClassDeclarationForKoEnumConstantProviderTest {
    @Test
    fun `class-has-no-constant`() {
        // given
        val sut = getSnippetFile("class-has-no-constant")
            .classes()
            .first()

        // then
        assertSoftly(sut) {
            enumConstants shouldBeEqualTo emptyList()
            numEnumConstants shouldBeEqualTo 0
            hasEnumConstants() shouldBeEqualTo false
            hasEnumConstants("SAMPLE_CONSTANT") shouldBeEqualTo false
        }
    }

    @Test
    fun `class-contains-constant`() {
        // given
        val sut = getSnippetFile("class-contains-constant")
            .classes()
            .first()

        // then
        sut.enumConstants.map { it.name } shouldBeEqualTo listOf("SAMPLE_CONSTANT")
    }

    @Test
    fun `class-has-constants`() {
        // given
        val sut = getSnippetFile("class-has-constants")
            .classes()
            .first()

        // then
        assertSoftly(sut) {
            numEnumConstants shouldBeEqualTo 2
            hasEnumConstants() shouldBeEqualTo true
            hasEnumConstants("SAMPLE_CONSTANT_1") shouldBeEqualTo true
            hasEnumConstants("SAMPLE_CONSTANT_1", "SAMPLE_CONSTANT_2") shouldBeEqualTo true
            hasEnumConstants("OTHER_CONSTANT_1") shouldBeEqualTo false
        }
    }
    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/koclass/snippet/forkoenumconstantprovider/", fileName)
}