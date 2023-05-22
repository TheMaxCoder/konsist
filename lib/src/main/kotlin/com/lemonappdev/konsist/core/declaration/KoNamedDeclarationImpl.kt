package com.lemonappdev.konsist.core.declaration

import com.lemonappdev.konsist.api.declaration.KoNamedDeclaration
import org.jetbrains.kotlin.psi.KtElement

internal abstract class KoNamedDeclarationImpl(private val ktElement: KtElement) : KoBaseDeclarationImpl(ktElement), KoNamedDeclaration {
    override val name by lazy { ktElement.name ?: "" }

    override fun hasNameStartingWith(prefix: String) = name.startsWith(prefix)

    override fun hasNameEndingWith(suffix: String) = name.endsWith(suffix)

    override fun hasNameContaining(text: String) = name.contains(text)

    override fun hasNameMatching(regex: Regex) = name.matches(regex)
}