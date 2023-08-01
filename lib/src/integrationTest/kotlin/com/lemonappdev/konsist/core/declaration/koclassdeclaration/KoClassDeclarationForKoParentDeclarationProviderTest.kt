package com.lemonappdev.konsist.core.declaration.koclassdeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoClassDeclarationForKoParentDeclarationProviderTest {
    @Test
    fun `class-has-parent-class-and-interfaces`() {
        // given
        val sut = getSnippetFile("class-has-parent-class-and-interfaces")
            .classes()
            .first()

        // then
        assertSoftly(sut) {
            parentDeclarations.map { it.name }.toList() shouldBeEqualTo listOf(
                "SampleParentClass",
                "SampleParentInterface1",
                "SampleParentInterface2",
            )
            hasParentDeclarations() shouldBeEqualTo true
            hasParentDeclarations("SampleParentClass") shouldBeEqualTo true
            hasParentDeclarations("OtherInterface") shouldBeEqualTo false
            hasParentDeclarations("SampleParentClass", "SampleParentInterface1") shouldBeEqualTo true
            hasParentDeclarations("SampleParentClass", "SampleParentInterface1", "OtherInterface") shouldBeEqualTo false
        }
    }

    @Test
    fun `class-has-no-parent-declarations`() {
        // given
        val sut = getSnippetFile("class-has-no-parent-declarations")
            .classes()
            .first()

        // then
        assertSoftly(sut) {
            parentDeclarations.toList() shouldBeEqualTo emptyList()
            hasParentDeclarations() shouldBeEqualTo false
            hasParentDeclarations("SampleClass") shouldBeEqualTo false
        }
    }

    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/koclassdeclaration/snippet/forkoparentdeclarationprovider/", fileName)
}