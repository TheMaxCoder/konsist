package com.lemon.konsist.core.declaration.kobasedeclaration

import com.lemon.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoBaseDeclarationTest {
    @Test
    fun `file-path`() {
        // given
        val sut = getSut("file-path")
            .functions()
            .first()

        // then
        sut.filePath.startsWith("//") shouldBeEqualTo false
        sut.filePath.endsWith("kobasedeclaration/snippet/file-path.kt") shouldBeEqualTo true
    }

    @Test
    fun `text-with-location`() {
        // given
        val sut = getSut("text-with-location")
            .functions()
            .first()

        // then
        val location = "/kotlin/com/lemon/konsist/core/declaration/kobasedeclaration/snippet/text-with-location.kt:1:1"
        val declaration = "Declaration:\nfun sampleFunction() {\n}"
        sut.textWithLocation.run {
            startsWith("Location: /")
            contains(location)
            endsWith(declaration)
        }
    }

    @Test
    fun `containing-file`() {
        // given
        val sut = getSut("containing-file")
            .files()
            .first()

        // then
        sut.containingFile.name.endsWith("file.kt") shouldBeEqualTo true
    }

    @Test
    fun `location-with-single-digit`() {
        // given
        val sut = getSut("location-with-single-digit")
            .functions()
            .first()

        // then
        sut.location shouldBeEqualTo "${sut.filePath}:3:1"
    }

    @Test
    fun `location-with-double-digit`() {
        // given
        val sut = getSut("location-with-double-digit")
            .functions(includeNested = true)
            .first()

        // then
        sut.location shouldBeEqualTo "${sut.filePath}:12:25"
    }

    @Test
    fun `text`() {
        // given
        val sut = getSut("text")
            .declarations()
            .first()

        // then
        sut.text shouldBeEqualTo """
            fun sampleFunction() {
                "SampleText"
            }
        """.trimIndent()
    }

    @Test
    fun `to-string`() {
        // given
        val sut = getSut("to-string")
            .functions()
            .first()

        // then
        sut.toString() shouldBeEqualTo sut.textWithLocation
    }

    private fun getSut(fileName: String) = getSnippetKoScope("core/declaration/kobasedeclaration/snippet/", fileName)
}
