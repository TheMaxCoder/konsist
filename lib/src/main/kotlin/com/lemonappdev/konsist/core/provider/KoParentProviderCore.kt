package com.lemonappdev.konsist.core.provider

import com.lemonappdev.konsist.api.declaration.KoParentDeclaration
import com.lemonappdev.konsist.api.provider.KoParentProvider
import com.lemonappdev.konsist.core.declaration.KoParentDeclarationCore
import org.jetbrains.kotlin.psi.KtClassOrObject
import org.jetbrains.kotlin.psi.KtSuperTypeListEntry
import kotlin.reflect.KClass

internal interface KoParentProviderCore :
    KoParentProvider,
    KoContainingDeclarationProviderCore,
    KoBaseProviderCore {
    val ktClassOrObject: KtClassOrObject

    override val parents: List<KoParentDeclaration>
        get() = ktClassOrObject
            .getSuperTypeList()
            ?.children
            ?.filterIsInstance<KtSuperTypeListEntry>()
            ?.map { KoParentDeclarationCore.getInstance(it, this) }
            ?: emptyList()

    override val numParents: Int
        get() = parents.size

    override fun countParents(predicate: (KoParentDeclaration) -> Boolean): Int =
        parents.count { predicate(it) }

    @Deprecated("Will be removed in v1.0.0.", ReplaceWith("hasParentsWithAllNames(*names)"))
    override fun hasParents(vararg names: String): Boolean = when {
        names.isEmpty() -> parents.isNotEmpty()
        else -> names.all {
            parents.any { parent -> it == parent.name }
        }
    }

    override fun hasParents(): Boolean = parents.isNotEmpty()

    override fun hasParentWithName(name: String, vararg names: String): Boolean {
        val givenNames = names.toList() + name

        return givenNames.any {
            parents.any { parent -> it == parent.name }
        }
    }

    override fun hasParentsWithAllNames(name: String, vararg names: String): Boolean {
        val givenNames = names.toList() + name

        return givenNames.all {
            parents.any { parent -> it == parent.name }
        }
    }

    override fun hasParent(predicate: (KoParentDeclaration) -> Boolean): Boolean = parents.any(predicate)

    override fun hasAllParents(predicate: (KoParentDeclaration) -> Boolean): Boolean = parents.all(predicate)

    override fun hasParentOf(name: KClass<*>, vararg names: KClass<*>): Boolean =
        checkIfParentOf(name) || names.any { checkIfParentOf(it) }

    override fun hasAllParentsOf(name: KClass<*>, vararg names: KClass<*>): Boolean =
        checkIfParentOf(name) && names.all { checkIfParentOf(it) }

    private fun checkIfParentOf(kClass: KClass<*>): Boolean = parents.any { parent ->
        parent.name == kClass.simpleName || parent.fullyQualifiedName == kClass.qualifiedName
    }
}
