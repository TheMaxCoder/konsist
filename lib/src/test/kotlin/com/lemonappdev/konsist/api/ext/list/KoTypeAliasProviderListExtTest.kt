package com.lemonappdev.konsist.api.ext.list

import com.lemonappdev.konsist.api.declaration.KoTypeAliasDeclaration
import com.lemonappdev.konsist.api.provider.KoTypeAliasProvider
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoTypeAliasProviderListExtTest {
    @Test
    fun `typeAliases returns type aliases from all declarations`() {
        // given
        val typeAlias1: KoTypeAliasDeclaration = mockk()
        val typeAlias2: KoTypeAliasDeclaration = mockk()
        val typeAlias3: KoTypeAliasDeclaration = mockk()
        val declaration1: KoTypeAliasProvider = mockk {
            every { typeAliases } returns listOf(typeAlias1, typeAlias2)
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { typeAliases } returns listOf(typeAlias3)
        }
        val declaration3: KoTypeAliasProvider = mockk {
            every { typeAliases } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.typeAliases

        // then
        sut shouldBeEqualTo listOf(typeAlias1, typeAlias2, typeAlias3)
    }

    @Test
    fun `withTypeAlias() returns declaration with typealias`() {
        // given
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliases() } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliases() } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withTypeAliases()

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutTypeAlias() returns declaration without typealias`() {
        // given
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliases() } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliases() } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutTypeAliases()

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withTypeAliasNamed(name) returns declaration with given type alias`() {
        // given
        val name = "SampleName"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliasWithName(name) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliasWithName(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withTypeAliasNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withTypeAliasNamed(String) returns declaration with any of given type aliases`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliasWithName(name1, name2) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliasWithName(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withTypeAliasNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutTypeAliasNamed(name) returns declaration without given type alias`() {
        // given
        val name = "SampleName"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliasWithName(name) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliasWithName(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutTypeAliasNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutTypeAliasNamed(String) returns declaration without any of given type aliases`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliasWithName(name1, name2) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliasWithName(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutTypeAliasNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllTypeAliasesNamed(name) returns declaration with given type alias`() {
        // given
        val name = "SampleName"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliasesWithAllNames(name) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliasesWithAllNames(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllTypeAliasesNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withAllTypeAliasesNamed(String) returns declaration with all given type aliases`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliasesWithAllNames(name1, name2) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliasesWithAllNames(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllTypeAliasesNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllTypeAliasesNamed(name) returns declaration without given type alias`() {
        // given
        val name = "SampleName"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliasesWithAllNames(name) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliasesWithAllNames(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllTypeAliasesNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutAllTypeAliasesNamed(String) returns declaration without all of given type aliases`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliasesWithAllNames(name1, name2) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliasesWithAllNames(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllTypeAliasesNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withTypeAlias{} returns declaration with type alias which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoTypeAliasDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAlias(predicate) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAlias(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withTypeAlias(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutTypeAlias{} returns declaration without type alias which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoTypeAliasDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAlias(predicate) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAlias(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutTypeAlias(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllTypeAliases{} returns declaration with all type aliases satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoTypeAliasDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasAllTypeAliases(predicate) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasAllTypeAliases(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllTypeAliases(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllTypeAliases{} returns declaration with all type aliases which not satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoTypeAliasDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasAllTypeAliases(predicate) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasAllTypeAliases(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllTypeAliases(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withTypeAliases{} returns declaration with type aliases which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (List<KoTypeAliasDeclaration>) -> Boolean =
            { it.all { typeAlias -> typeAlias.hasNameEndingWith(suffix) } }
        val typeAlias1: KoTypeAliasDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns true
        }
        val typeAlias2: KoTypeAliasDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns false
        }
        val declaration1: KoTypeAliasProvider = mockk {
            every { typeAliases } returns listOf(typeAlias1)
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { typeAliases } returns listOf(typeAlias2)
        }
        val declaration3: KoTypeAliasProvider = mockk {
            every { typeAliases } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withTypeAliases(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1, declaration3)
    }

    @Test
    fun `withoutTypeAliases{} returns declaration without type aliases which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (List<KoTypeAliasDeclaration>) -> Boolean =
            { it.all { typeAlias -> typeAlias.hasNameEndingWith(suffix) } }
        val typeAlias1: KoTypeAliasDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns true
        }
        val typeAlias2: KoTypeAliasDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns false
        }
        val declaration1: KoTypeAliasProvider = mockk {
            every { typeAliases } returns listOf(typeAlias1)
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { typeAliases } returns listOf(typeAlias2)
        }
        val declaration3: KoTypeAliasProvider = mockk {
            every { typeAliases } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withoutTypeAliases(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllTypeAliases(String) returns declarations with all of given typeAliases`() {
        // given
        val typeAlias1 = "SampleTypeAlias1"
        val typeAlias2 = "SampleTypeAlias2"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1, typeAlias2) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1, typeAlias2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllTypeAliases(typeAlias1, typeAlias2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllTypeAliases(String) returns declaration without any of given typeAliases`() {
        // given
        val typeAlias1 = "SampleTypeAlias1"
        val typeAlias2 = "SampleTypeAlias2"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1, typeAlias2) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1, typeAlias2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllTypeAliases(typeAlias1, typeAlias2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withSomeTypeAliases(String) returns declaration with given typeAlias`() {
        // given
        val typeAlias = "SampleTypeAlias"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withSomeTypeAliases(typeAlias)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withSomeTypeAliases(String) returns declarations with at least one of given typeAliases`() {
        // given
        val typeAlias1 = "SampleTypeAlias1"
        val typeAlias2 = "SampleTypeAlias2"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1) } returns true
            every { hasTypeAliases(typeAlias2) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1) } returns false
            every { hasTypeAliases(typeAlias2) } returns true
        }
        val declaration3: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1) } returns false
            every { hasTypeAliases(typeAlias2) } returns false
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withSomeTypeAliases(typeAlias1, typeAlias2)

        // then
        sut shouldBeEqualTo listOf(declaration1, declaration2)
    }

    @Test
    fun `withoutSomeTypeAliases(String) returns declaration without given typeAlias`() {
        // given
        val typeAlias = "SampleTypeAlias"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutSomeTypeAliases(typeAlias)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutSomeTypeAliases(String) returns declarations without at least one of given typeAliases`() {
        // given
        val typeAlias1 = "SampleTypeAlias1"
        val typeAlias2 = "SampleTypeAlias2"
        val declaration1: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1) } returns true
            every { hasTypeAliases(typeAlias2) } returns true
        }
        val declaration2: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1) } returns false
            every { hasTypeAliases(typeAlias2) } returns true
        }
        val declaration3: KoTypeAliasProvider = mockk {
            every { hasTypeAliases(typeAlias1) } returns false
            every { hasTypeAliases(typeAlias2) } returns false
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withoutSomeTypeAliases(typeAlias1, typeAlias2)

        // then
        sut shouldBeEqualTo listOf(declaration3)
    }
}
