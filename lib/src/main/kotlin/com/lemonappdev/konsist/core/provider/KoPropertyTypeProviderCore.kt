package com.lemonappdev.konsist.core.provider

import com.lemonappdev.konsist.api.declaration.KoTypeDeclaration
import com.lemonappdev.konsist.api.provider.KoPropertyTypeProvider
import com.lemonappdev.konsist.core.util.ReceiverUtil
import org.jetbrains.kotlin.psi.KtCallableDeclaration
import org.jetbrains.kotlin.psi.KtTypeReference
import org.jetbrains.kotlin.psi.psiUtil.isExtensionDeclaration
import kotlin.reflect.KClass

internal interface KoPropertyTypeProviderCore :
    KoPropertyTypeProvider,
    KoContainingDeclarationProviderCore,
    KoBaseProviderCore {
    val ktCallableDeclaration: KtCallableDeclaration
    override val type: KoTypeDeclaration?
        get() = ReceiverUtil.getType(getTypeReferences(), ktCallableDeclaration.isExtensionDeclaration(), this)

    private fun getTypeReferences(): List<KtTypeReference> = ktCallableDeclaration
        .children
        .filterIsInstance<KtTypeReference>()

    @Deprecated("Will be removed in v1.0.0", ReplaceWith("hasType { it.name == name }"))
    override fun hasType(name: String): Boolean = this.type?.name == name

    override fun hasType(predicate: ((KoTypeDeclaration) -> Boolean)?): Boolean =
        when (predicate) {
            null -> type != null
            else -> type?.let { predicate(it) } ?: false
        }

    override fun hasTypeOf(kClass: KClass<*>): Boolean = kClass.simpleName == type?.name
}
