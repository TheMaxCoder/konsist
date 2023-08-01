package com.lemonappdev.konsist.api.ext.sequence

import com.lemonappdev.konsist.api.provider.KoKotlinTypeProvider
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoKotlinTypeProviderSequenceExtTest {
    @Test
    fun `withKotlinType() returns type with Kotlin basic type`() {
        // given
        val type1: KoKotlinTypeProvider = mockk {
            every { isKotlinType } returns true
        }
        val type2: KoKotlinTypeProvider = mockk {
            every { isKotlinType } returns false
        }
        val types = sequenceOf(type1, type2)

        // when
        val sut = types.withKotlinType()

        // then
        sut.toList() shouldBeEqualTo listOf(type1)
    }

    @Test
    fun `withoutKotlinType() returns type without Kotlin basic type`() {
        // given
        val type1: KoKotlinTypeProvider = mockk {
            every { isKotlinType } returns true
        }
        val type2: KoKotlinTypeProvider = mockk {
            every { isKotlinType } returns false
        }
        val types = sequenceOf(type1, type2)

        // when
        val sut = types.withoutKotlinType()

        // then
        sut.toList() shouldBeEqualTo listOf(type2)
    }
}