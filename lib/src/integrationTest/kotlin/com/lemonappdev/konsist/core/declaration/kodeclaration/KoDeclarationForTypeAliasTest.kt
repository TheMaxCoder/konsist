package com.lemonappdev.konsist.core.declaration.kodeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import com.lemonappdev.konsist.core.const.KoModifier.PRIVATE
import com.lemonappdev.konsist.core.const.KoModifier.PUBLIC
import com.lemonappdev.konsist.testdata.NonExistingAnnotation
import com.lemonappdev.konsist.testdata.SampleAnnotation
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldHaveSize
import org.amshove.kluent.shouldNotBeEqualTo
import org.junit.jupiter.api.Test

class KoDeclarationForTypeAliasTest {
    @Test
    fun `typealias-is-top-level`() {
        // given
        val sut = getSnippetFile("typealias-is-top-level")
            .typeAliases()
            .first()

        // then
        sut.isTopLevel() shouldBeEqualTo true
    }

    @Test
    fun `typealias-has-annotation`() {
        // given
        val sut = getSnippetFile("typealias-has-annotation")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            annotations shouldHaveSize 1
            hasAnnotations("SampleAnnotation") shouldBeEqualTo true
            hasAnnotations("NonExistingAnnotation") shouldBeEqualTo false
            hasAnnotations("com.lemonappdev.konsist.testdata.SampleAnnotation") shouldBeEqualTo true
            hasAnnotations("com.lemonappdev.konsist.testdata.NonExistingAnnotation") shouldBeEqualTo false
            hasAnnotationOf<SampleAnnotation>() shouldBeEqualTo true
            hasAnnotationOf<NonExistingAnnotation>() shouldBeEqualTo false
        }
    }

    @Test
    fun `typealias-has-modifier`() {
        // given
        val sut = getSnippetFile("typealias-has-modifier")
            .typeAliases()
            .first()

        // then
        sut.modifiers shouldBeEqualTo listOf(PRIVATE)
    }

    @Test
    fun `typealias-has-modifiers-and-annotation-with-parameter`() {
        // given
        val sut = getSnippetFile("typealias-has-modifiers-and-annotation-with-parameter")
            .typeAliases()
            .first()

        // then
        sut.modifiers shouldBeEqualTo listOf(PRIVATE)
    }

    @Test
    fun `typealias-has-modifiers-and-annotation-without-parameter`() {
        // given
        val sut = getSnippetFile("typealias-has-modifiers-and-annotation-without-parameter")
            .typeAliases()
            .first()

        // then
        sut.modifiers shouldBeEqualTo listOf(PRIVATE)
    }

    @Test
    fun `typealias-has-modifiers-and-annotations`() {
        // given
        val sut = getSnippetFile("typealias-has-modifiers-and-annotations")
            .typeAliases()
            .first()

        // then
        sut.modifiers shouldBeEqualTo listOf(PRIVATE)
    }

    @Test
    fun `typealias-has-no-visibility-modifier`() {
        // given
        val sut = getSnippetFile("typealias-has-no-visibility-modifier")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            isPublicOrDefault() shouldBeEqualTo true
            hasPublicModifier() shouldBeEqualTo false
            hasPrivateModifier() shouldBeEqualTo false
            hasProtectedModifier() shouldBeEqualTo false
            hasInternalModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `typealias-has-public-visibility-modifier`() {
        // given
        val sut = getSnippetFile("typealias-has-public-visibility-modifier")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            isPublicOrDefault() shouldBeEqualTo true
            hasPublicModifier() shouldBeEqualTo true
            hasPrivateModifier() shouldBeEqualTo false
            hasProtectedModifier() shouldBeEqualTo false
            hasInternalModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `typealias-has-private-visibility-modifier`() {
        // given
        val sut = getSnippetFile("typealias-has-private-visibility-modifier")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            isPublicOrDefault() shouldBeEqualTo false
            hasPublicModifier() shouldBeEqualTo false
            hasPrivateModifier() shouldBeEqualTo true
            hasProtectedModifier() shouldBeEqualTo false
            hasInternalModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `typealias-has-protected-visibility-modifier`() {
        // given
        val sut = getSnippetFile("typealias-has-protected-visibility-modifier")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            isPublicOrDefault() shouldBeEqualTo false
            hasPublicModifier() shouldBeEqualTo false
            hasPrivateModifier() shouldBeEqualTo false
            hasProtectedModifier() shouldBeEqualTo true
            hasInternalModifier() shouldBeEqualTo false
        }
    }

    @Test
    fun `typealias-has-internal-visibility-modifier`() {
        // given
        val sut = getSnippetFile("typealias-has-internal-visibility-modifier")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            isPublicOrDefault() shouldBeEqualTo false
            hasPublicModifier() shouldBeEqualTo false
            hasPrivateModifier() shouldBeEqualTo false
            hasProtectedModifier() shouldBeEqualTo false
            hasInternalModifier() shouldBeEqualTo true
        }
    }

    @Test
    fun `typealias-has-fully-qualified-name`() {
        // given
        val sut = getSnippetFile("typealias-has-fully-qualified-name")
            .typeAliases()
            .first()

        // then
        sut.fullyQualifiedName shouldBeEqualTo "com.samplepackage.SampleTypeAlias"
    }

    @Test
    fun `typealias-is-in-package`() {
        // given
        val sut = getSnippetFile("typealias-is-in-package")
            .typeAliases()
            .first()

        // then
        sut.packageName shouldBeEqualTo "com.samplepackage"
    }

    @Test
    fun `typealias-is-not-in-package`() {
        // given
        val sut = getSnippetFile("typealias-is-not-in-package")
            .typeAliases()
            .first()

        // then
        sut.packageName shouldBeEqualTo ""
    }

    @Test
    fun `typealias-has-protected-modifier`() {
        // given
        val sut = getSnippetFile("typealias-has-protected-modifier")
            .typeAliases()
            .first()

        // then
        sut.hasModifiers() shouldBeEqualTo true
    }

    @Test
    fun `typealias-has-public-modifier`() {
        // given
        val sut = getSnippetFile("typealias-has-public-modifier")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            hasModifiers(PUBLIC) shouldBeEqualTo true
            hasModifiers(PRIVATE) shouldBeEqualTo false
        }
    }

    @Test
    fun `typealias-has-no-modifiers`() {
        // given
        val sut = getSnippetFile("typealias-has-no-modifiers")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            hasModifiers() shouldBeEqualTo false
            hasModifiers(PRIVATE) shouldBeEqualTo false
        }
    }

    @Test
    fun `typealias-has-kdoc`() {
        // given
        val sut = getSnippetFile("typealias-has-kdoc")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            koDoc shouldNotBeEqualTo null
            hasKoDoc() shouldBeEqualTo true
        }
    }

    @Test
    fun `typealias-has-no-kdoc`() {
        // given
        val sut = getSnippetFile("typealias-has-no-kdoc")
            .typeAliases()
            .first()

        // then
        assertSoftly(sut) {
            koDoc shouldBeEqualTo null
            hasKoDoc() shouldBeEqualTo false
        }
    }

    private fun getSnippetFile(fileName: String) = getSnippetKoScope("core/declaration/kodeclaration/snippet/fortypealias/", fileName)
}