package com.lemonappdev.konsist.api.ext.sequence

import com.lemonappdev.konsist.core.declaration.KoImportDeclarationImpl
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoImportDeclarationSequenceExtTest {
    @Test
    fun `withAlias() returns import with any alias`() {
        // given
        val importName = "name"
        val alias1 = "AliasName"
        val import1: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns alias1
        }
        val import2: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns importName
        }
        val imports = sequenceOf(import1, import2)

        // when
        val sut = imports.withAlias()

        // then
        sut.toList() shouldBeEqualTo listOf(import1)
    }

    @Test
    fun `withAlias(name) returns imports with one of given alias names`() {
        // given
        val importName = "name"
        val aliasName1 = "AliasName1"
        val aliasName2 = "AliasName2"
        val aliasName3 = "AliasName3"
        val import1: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns aliasName1
        }
        val import2: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns aliasName2
        }
        val import3: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns aliasName3
        }
        val import4: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns importName
        }
        val imports = sequenceOf(import1, import2, import3, import4)

        // when
        val sut = imports.withAlias(aliasName1, aliasName2)

        // then
        sut.toList() shouldBeEqualTo listOf(import1, import2)
    }

    @Test
    fun `withoutAlias() returns import without any alias`() {
        // given
        val importName = "name"
        val alias1 = "AliasName"
        val import1: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns alias1
        }
        val import2: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns importName
        }
        val imports = sequenceOf(import1, import2)

        // when
        val sut = imports.withoutAlias()

        // then
        sut.toList() shouldBeEqualTo listOf(import2)
    }

    @Test
    fun `withoutAlias(name) returns imports without alias with any of given names`() {
        // given
        val importName = "name"
        val aliasName1 = "AliasName1"
        val aliasName2 = "AliasName2"
        val aliasName3 = "AliasName3"
        val import1: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns aliasName1
        }
        val import2: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns aliasName2
        }
        val import3: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns aliasName3
        }
        val import4: KoImportDeclarationImpl = mockk {
            every { name } returns importName
            every { alias } returns importName
        }
        val imports = sequenceOf(import1, import2, import3, import4)

        // when
        val sut = imports.withoutAlias(aliasName1, aliasName2)

        // then
        sut.toList() shouldBeEqualTo listOf(import3, import4)
    }

    @Test
    fun `withWildcard() returns import with wildcard`() {
        // given
        val import1: KoImportDeclarationImpl = mockk {
            every { isWildcard } returns true
        }
        val import2: KoImportDeclarationImpl = mockk {
            every { isWildcard } returns false
        }
        val imports = sequenceOf(import1, import2)

        // when
        val sut = imports.withWildcard()

        // then
        sut.toList() shouldBeEqualTo listOf(import1)
    }

    @Test
    fun `withoutWildcard() returns import without wildcard`() {
        // given
        val import1: KoImportDeclarationImpl = mockk {
            every { isWildcard } returns true
        }
        val import2: KoImportDeclarationImpl = mockk {
            every { isWildcard } returns false
        }
        val imports = sequenceOf(import1, import2)

        // when
        val sut = imports.withoutWildcard()

        // then
        sut.toList() shouldBeEqualTo listOf(import2)
    }
}