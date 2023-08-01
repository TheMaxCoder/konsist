package com.lemonappdev.konsist.core.declaration.koprimaryconstructordeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import com.lemonappdev.konsist.api.provider.KoNameProvider
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBeEqualTo
import org.junit.jupiter.api.Test

class KoPrimaryConstructorDeclarationForKoParentProviderTest {
    @Test
    fun `primary-constructor-parent`() {
        // given
        val sut = getSnippetFile("primary-constructor-parent")
            .classes()
            .first()
            .primaryConstructor

        // then
        assertSoftly(sut) {
            it?.parent shouldNotBeEqualTo null
            (it?.parent as KoNameProvider).name shouldBeEqualTo "SampleClass"
        }
    }

    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/koprimaryconstructordeclaration/snippet/forkoparentprovider/", fileName)
}