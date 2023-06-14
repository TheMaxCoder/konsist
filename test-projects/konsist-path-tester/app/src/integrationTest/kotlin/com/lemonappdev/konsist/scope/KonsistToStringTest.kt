package com.lemonappdev.konsist.scope

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.helper.ext.toCanonicalPath
import com.lemonappdev.konsist.helper.util.PathProvider.appMainSourceSetDirectory
import com.lemonappdev.konsist.helper.util.PathProvider.appMainSourceSetProjectDirectory
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KonsistToStringTest {
    @Test
    fun `toString method`() {
        // given
        val sut = Konsist
            .scopeFromDirectory("$appMainSourceSetProjectDirectory/sample/".toCanonicalPath().toCanonicalPath())
            .toString()

        // then
        sut shouldBeEqualTo """
            $appMainSourceSetDirectory/sample/AppClass.kt
            $appMainSourceSetDirectory/sample/data/AppDataClass.kt
        """
            .trimIndent()
            .toCanonicalPath()
    }
}
