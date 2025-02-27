package com.lemonappdev.konsist.api.ext.list

import com.lemonappdev.konsist.api.declaration.KoEnumConstantDeclaration
import com.lemonappdev.konsist.api.provider.KoEnumConstantProvider
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoEnumConstantProviderListExtTest {
    @Test
    fun `enumConstants returns constants from all declarations`() {
        // given
        val constants1: KoEnumConstantDeclaration = mockk()
        val constants2: KoEnumConstantDeclaration = mockk()
        val constants3: KoEnumConstantDeclaration = mockk()
        val declaration1: KoEnumConstantProvider = mockk {
            every { enumConstants } returns listOf(constants1, constants2)
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { enumConstants } returns listOf(constants3)
        }
        val declaration3: KoEnumConstantProvider = mockk {
            every { enumConstants } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.enumConstants

        // then
        sut shouldBeEqualTo listOf(constants1, constants2, constants3)
    }

    @Test
    fun `withEnumConstants() returns declaration with any constant`() {
        // given
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstants() } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstants() } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withEnumConstants()

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutEnumConstants() returns declaration without any constant`() {
        // given
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstants() } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstants() } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutEnumConstants()

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withEnumConstantNamed(name) returns declaration with given enum constant`() {
        // given
        val name = "SampleName"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstantWithName(name) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstantWithName(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withEnumConstantNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withEnumConstantNamed(String) returns declaration with any of given enum constants`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstantWithName(name1, name2) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstantWithName(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withEnumConstantNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutEnumConstantNamed(name) returns declaration without given enum constant`() {
        // given
        val name = "SampleName"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstantWithName(name) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstantWithName(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutEnumConstantNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutEnumConstantNamed(String) returns declaration without any of given enum constants`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstantWithName(name1, name2) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstantWithName(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutEnumConstantNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllEnumConstantsNamed(name) returns declaration with given enum constant`() {
        // given
        val name = "SampleName"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstantsWithAllNames(name) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstantsWithAllNames(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllEnumConstantsNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withAllEnumConstantsNamed(String) returns declaration with all given enum constants`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstantsWithAllNames(name1, name2) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstantsWithAllNames(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllEnumConstantsNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllEnumConstantsNamed(name) returns declaration without given enum constant`() {
        // given
        val name = "SampleName"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstantsWithAllNames(name) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstantsWithAllNames(name) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllEnumConstantsNamed(name)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutAllEnumConstantsNamed(String) returns declaration without all of given enum constants`() {
        // given
        val name1 = "SampleName1"
        val name2 = "SampleName2"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstantsWithAllNames(name1, name2) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstantsWithAllNames(name1, name2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllEnumConstantsNamed(name1, name2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withEnumConstant{} returns declaration with enum constant which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoEnumConstantDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstant(predicate) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstant(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withEnumConstant(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutEnumConstant{} returns declaration without enum constant which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoEnumConstantDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstant(predicate) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstant(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutEnumConstant(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllEnumConstants{} returns declaration with all enum constants satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoEnumConstantDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasAllEnumConstants(predicate) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasAllEnumConstants(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllEnumConstants(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllEnumConstants{} returns declaration with all enum constants which not satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (KoEnumConstantDeclaration) -> Boolean = { it.hasNameEndingWith(suffix) }
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasAllEnumConstants(predicate) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasAllEnumConstants(predicate) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllEnumConstants(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withEnumConstants{} returns declaration with enum constants which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (List<KoEnumConstantDeclaration>) -> Boolean =
            { it.all { enumConstant -> enumConstant.hasNameEndingWith(suffix) } }
        val enumConstant1: KoEnumConstantDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns true
        }
        val enumConstant2: KoEnumConstantDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns false
        }
        val declaration1: KoEnumConstantProvider = mockk {
            every { enumConstants } returns listOf(enumConstant1)
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { enumConstants } returns listOf(enumConstant2)
        }
        val declaration3: KoEnumConstantProvider = mockk {
            every { enumConstants } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withEnumConstants(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration1, declaration3)
    }

    @Test
    fun `withoutEnumConstants{} returns declaration without enum constants which satisfy predicate`() {
        // given
        val suffix = "Name"
        val predicate: (List<KoEnumConstantDeclaration>) -> Boolean =
            { it.all { enumConstant -> enumConstant.hasNameEndingWith(suffix) } }
        val enumConstant1: KoEnumConstantDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns true
        }
        val enumConstant2: KoEnumConstantDeclaration = mockk {
            every { hasNameEndingWith(suffix) } returns false
        }
        val declaration1: KoEnumConstantProvider = mockk {
            every { enumConstants } returns listOf(enumConstant1)
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { enumConstants } returns listOf(enumConstant2)
        }
        val declaration3: KoEnumConstantProvider = mockk {
            every { enumConstants } returns emptyList()
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withoutEnumConstants(predicate)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withAllEnumConstants(String) returns declaration with all of given constants`() {
        // given
        val constant1 = "SampleConstant1"
        val constant2 = "SampleConstant2"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1, constant2) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1, constant2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withAllEnumConstants(constant1, constant2)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withoutAllEnumConstants(String) returns declaration without any of given constants`() {
        // given
        val constant1 = "SampleConstant1"
        val constant2 = "SampleConstant2"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1, constant2) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1, constant2) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutAllEnumConstants(constant1, constant2)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withSomeEnumConstants(String) returns declaration with given constant`() {
        // given
        val constant = "SampleConstant"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withSomeEnumConstants(constant)

        // then
        sut shouldBeEqualTo listOf(declaration1)
    }

    @Test
    fun `withSomeEnumConstants(String) returns declarations with at least one of given constants`() {
        // given
        val constant1 = "SampleConstant1"
        val constant2 = "SampleConstant2"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1) } returns true
            every { hasEnumConstants(constant2) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1) } returns false
            every { hasEnumConstants(constant2) } returns true
        }
        val declaration3: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1) } returns false
            every { hasEnumConstants(constant2) } returns false
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withSomeEnumConstants(constant1, constant2)

        // then
        sut shouldBeEqualTo listOf(declaration1, declaration2)
    }

    @Test
    fun `withoutSomeEnumConstants(String) returns declaration with given constant`() {
        // given
        val constant = "SampleConstant"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant) } returns false
        }
        val declarations = listOf(declaration1, declaration2)

        // when
        val sut = declarations.withoutSomeEnumConstants(constant)

        // then
        sut shouldBeEqualTo listOf(declaration2)
    }

    @Test
    fun `withoutSomeEnumConstants(String) returns declarations with at least one of given constants`() {
        // given
        val constant1 = "SampleConstant1"
        val constant2 = "SampleConstant2"
        val declaration1: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1) } returns true
            every { hasEnumConstants(constant2) } returns true
        }
        val declaration2: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1) } returns false
            every { hasEnumConstants(constant2) } returns true
        }
        val declaration3: KoEnumConstantProvider = mockk {
            every { hasEnumConstants(constant1) } returns false
            every { hasEnumConstants(constant2) } returns false
        }
        val declarations = listOf(declaration1, declaration2, declaration3)

        // when
        val sut = declarations.withoutSomeEnumConstants(constant1, constant2)

        // then
        sut shouldBeEqualTo listOf(declaration3)
    }
}
