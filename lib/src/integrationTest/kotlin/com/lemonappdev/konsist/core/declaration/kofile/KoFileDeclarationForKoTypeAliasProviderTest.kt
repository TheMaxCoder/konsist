package com.lemonappdev.konsist.core.declaration.kofile

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoFileDeclarationForKoTypeAliasProviderTest {
    @Test
    fun `file-has-no-typealias`() {
        // given
        val sut = getSnippetFile("file-has-no-typealias")
            .files
            .first()

        // then
        assertSoftly(sut) {
            typeAliases shouldBeEqualTo emptyList()
            numTypeAliases shouldBeEqualTo 0
            countTypeAliases { it.hasPrivateModifier } shouldBeEqualTo 0
            hasTypeAliases() shouldBeEqualTo false
            hasTypeAliasWithName("SampleTypeAlias") shouldBeEqualTo false
            hasTypeAliasesWithAllNames("SampleTypeAlias1", "SampleTypeAlias2") shouldBeEqualTo false
            hasTypeAlias { it.hasPublicModifier } shouldBeEqualTo false
            hasAllTypeAliases { it.hasPublicOrDefaultModifier } shouldBeEqualTo true
            hasTypeAliases("SampleTypeAlias") shouldBeEqualTo false
        }
    }

    @Test
    fun `file-has-one-typealias`() {
        // given
        val sut = getSnippetFile("file-has-one-typealias")
            .files
            .first()

        // then
        assertSoftly(sut) {
            typeAliases.size shouldBeEqualTo 1
            numTypeAliases shouldBeEqualTo 1
            countTypeAliases { it.hasPublicOrDefaultModifier } shouldBeEqualTo 1
            hasTypeAliases() shouldBeEqualTo true
            hasTypeAliasWithName("SampleTypeAlias") shouldBeEqualTo true
            hasTypeAliasWithName("otherTypeAlias") shouldBeEqualTo false
            hasTypeAliasWithName("SampleTypeAlias", "otherTypeAlias") shouldBeEqualTo true
            hasTypeAliasesWithAllNames("SampleTypeAlias") shouldBeEqualTo true
            hasTypeAliasesWithAllNames("SampleTypeAlias", "otherTypeAlias") shouldBeEqualTo false
            hasTypeAlias { it.hasPublicOrDefaultModifier } shouldBeEqualTo true
            hasTypeAlias { it.hasPublicModifier } shouldBeEqualTo false
            hasAllTypeAliases { it.hasPublicOrDefaultModifier } shouldBeEqualTo true
        }
    }

    @Test
    fun `file-has-two-typealiases`() {
        // given
        val sut = getSnippetFile("file-has-two-typealiases")
            .files
            .first()

        // then
        assertSoftly(sut) {
            numTypeAliases shouldBeEqualTo 2
            countTypeAliases { it.hasNameStartingWith("Sample") } shouldBeEqualTo 2
            countTypeAliases { it.name == "SampleTypeAlias1" } shouldBeEqualTo 1
            hasTypeAliases() shouldBeEqualTo true
            hasTypeAliasWithName("SampleTypeAlias1") shouldBeEqualTo true
            hasTypeAliasWithName("otherTypeAlias") shouldBeEqualTo false
            hasTypeAliasWithName("SampleTypeAlias1", "otherName") shouldBeEqualTo true
            hasTypeAliasesWithAllNames("SampleTypeAlias1") shouldBeEqualTo true
            hasTypeAliasesWithAllNames("SampleTypeAlias1", "SampleTypeAlias2") shouldBeEqualTo true
            hasTypeAliasesWithAllNames("SampleTypeAlias1", "otherTypeAlias") shouldBeEqualTo false
            hasTypeAlias { it.hasPublicOrDefaultModifier } shouldBeEqualTo true
            hasTypeAlias { it.hasPublicModifier } shouldBeEqualTo true
            hasAllTypeAliases { it.hasPublicOrDefaultModifier } shouldBeEqualTo true
            hasAllTypeAliases { it.hasPublicModifier } shouldBeEqualTo false
            hasTypeAliases("SampleTypeAlias1") shouldBeEqualTo true
            hasTypeAliases("SampleTypeAlias1", "SampleTypeAlias2") shouldBeEqualTo true
            hasTypeAliases("OtherTypeAlias") shouldBeEqualTo false
        }
    }

    private fun getSnippetFile(fileName: String) = getSnippetKoScope(
        "core/declaration/kofile/snippet/forkotypealiasprovider/",
        fileName,
    )
}
