package com.lemonappdev.konsist.core.declaration.koinitblockdeclaration

import com.lemonappdev.konsist.TestSnippetProvider
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoInitBlockDeclarationTest {
    @Test
    fun `init-block-to-string`() {
        // given
        val sut = getSnippetFile("init-block-to-string")
            .classes()
            .first()
            .initBlocks
            ?.first()

        // then
        sut.toString() shouldBeEqualTo sut?.locationWithText
    }

    private fun getSnippetFile(fileName: String) =
        TestSnippetProvider.getSnippetKoScope("core/declaration/koinitblockdeclaration/snippet/forgeneral/", fileName)
}