package com.lemonappdev.konsist.core.provider

import com.lemonappdev.konsist.api.provider.KoContainingDeclarationProvider

internal interface KoContainingDeclarationProviderCore : KoContainingDeclarationProvider, KoBaseProviderCore {
    override val containingDeclaration: KoContainingDeclarationProvider?
        get() = null
}
