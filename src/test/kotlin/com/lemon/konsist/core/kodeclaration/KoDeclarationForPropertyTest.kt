package com.lemon.konsist.core.kodeclaration

import NonExistingAnnotation
import SampleAnnotation
import SampleAnnotation1
import SampleAnnotation2
import com.lemon.konsist.TestSnippetProvider.getSnippetKoScope
import com.lemon.konsist.core.const.Modifier
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldHaveSize
import org.junit.jupiter.api.Test

class KoDeclarationForPropertyTest {
    @Test
    fun `property-is-top-level`() {
        // given
        val sut = getSut("property-is-top-level")

        // then
        sut.properties(includeNested = true).first().isTopLevel shouldBe true
    }

    @Test
    fun `property-is-not-top-level`() {
        // given
        val sut = getSut("property-is-not-top-level")

        // then
        sut.properties(includeNested = true).first { it.name == "sampleNestedProperty" }.isTopLevel shouldBe false
    }

    @Test
    fun `property-without-annotation`() {
        // given
        val sut = getSut("property-without-annotation")

        // then
        sut.properties().first().annotations shouldHaveSize 0
    }

    @Test
    fun `property-with-annotation`() {
        // given
        val sut = getSut("property-with-annotation")

        // then
        sut.properties().first().apply {
            annotations shouldHaveSize 1
            hasAnnotation(SampleAnnotation::class) shouldBe true
            hasAnnotation(NonExistingAnnotation::class) shouldBe false
        }
    }

    @Test
    fun `property-with-two-annotations`() {
        // given
        val sut = getSut("property-with-two-annotations")

        // then
        sut.properties().first().apply {
            annotations shouldHaveSize 2
            hasAnnotation(SampleAnnotation1::class) shouldBe true
            hasAnnotation(SampleAnnotation2::class) shouldBe true
            hasAnnotation(NonExistingAnnotation::class) shouldBe false
        }
    }

    @Test
    fun `property-without-visibility-modifier`() {
        // given
        val sut = getSut("property-without-visibility-modifier")

        // then
        sut.properties().first().apply {
            isPublic shouldBe true
            isPrivate shouldBe false
            isProtected shouldBe false
            isInternal shouldBe false
        }
    }

    @Test
    fun `property-with-public-visibility-modifier`() {
        // given
        val sut = getSut("property-with-public-visibility-modifier")

        // then
        sut.properties().first().apply {
            isPublic shouldBe true
            isPrivate shouldBe false
            isProtected shouldBe false
            isInternal shouldBe false
        }
    }

    @Test
    fun `property-with-private-visibility-modifier`() {
        // given
        val sut = getSut("property-with-private-visibility-modifier")

        // then
        sut.properties().first().apply {
            isPublic shouldBe false
            isPrivate shouldBe true
            isProtected shouldBe false
            isInternal shouldBe false
        }
    }

    @Test
    fun `property-with-protected-visibility-modifier`() {
        // given
        val sut = getSut("property-with-protected-visibility-modifier")

        // then
        sut.properties().first().apply {
            isPublic shouldBe false
            isPrivate shouldBe false
            isProtected shouldBe true
            isInternal shouldBe false
        }
    }

    @Test
    fun `property-with-internal-visibility-modifier`() {
        // given
        val sut = getSut("property-with-internal-visibility-modifier")

        // then
        sut.properties().first().apply {
            isPublic shouldBe false
            isPrivate shouldBe false
            isProtected shouldBe false
            isInternal shouldBe true
        }
    }

    @Test
    fun `property-with-fully-qualified-name`() {
        // given
        val sut = getSut("property-with-fully-qualified-name")

        // then
        sut.properties()
            .first()
            .fullyQualifiedName shouldBeEqualTo "com.samplepackage.sampleProperty"
    }

    @Test
    fun `property-with-package`() {
        // given
        val sut = getSut("property-with-package")

        // then
        sut.properties()
            .first()
            .packageDirective shouldBeEqualTo "com.samplepackage"
    }

    @Test
    fun `property-without-package`() {
        // given
        val sut = getSut("property-without-package")

        // then
        sut.properties()
            .first()
            .packageDirective shouldBeEqualTo ""
    }

    @Test
    fun `property-with-protected-modifier`() {
        // given
        val sut = getSut("property-with-protected-modifier")

        // then
        sut.properties()
            .first()
            .hasModifiers() shouldBe true
    }

    @Test
    fun `property-with-public-modifier`() {
        // given
        val sut = getSut("property-with-public-modifier")

        // then
        sut.properties()
            .first()
            .apply {
                hasModifiers(Modifier.PUBLIC) shouldBe true
                hasModifiers(Modifier.PRIVATE) shouldBe false
            }
    }

    @Test
    fun `property-reside-in-package`() {
        // given
        val sut = getSut("property-reside-in-package")

        // then
        sut.properties()
            .first()
            .resideInAPackages("samplepackage") shouldBe true
    }

    @Test
    fun `property-not-reside-in-package`() {
        // given
        val sut = getSut("property-not-reside-in-package")

        // then
        sut.properties()
            .first()
            .resideInAPackages("otherpackage") shouldBe false
    }

    private fun getSut(fileName: String) = getSnippetKoScope("core/kodeclaration/snippet/forproperty/$fileName.kt.txt")
}
