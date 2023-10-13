package com.lemonappdev.konsist.core.provider

import com.lemonappdev.konsist.api.declaration.KoExternalParentDeclaration
import com.lemonappdev.konsist.api.provider.KoExternalParentProvider
import kotlin.reflect.KClass

internal interface KoExternalParentProviderCore :
    KoExternalParentProvider,
    KoBaseProviderCore,
    KoParentProviderCore {
    override val externalParents: List<KoExternalParentDeclaration>
        get() = parents
            .filterIsInstance<KoExternalParentDeclaration>()

    override val numExternalParents: Int
        get() = externalParents.size

    override fun countExternalParents(predicate: (KoExternalParentDeclaration) -> Boolean): Int =
        externalParents.count { predicate(it) }

    override fun hasExternalParents(): Boolean = externalParents.isNotEmpty()

    override fun hasExternalParentWithName(name: String, vararg names: String): Boolean {
        val givenNames = names.toList() + name

        return givenNames.any {
            externalParents.any { parentInterface -> it == parentInterface.name }
        }
    }

    override fun hasExternalParentsWithAllNames(name: String, vararg names: String): Boolean {
        val givenNames = names.toList() + name

        return givenNames.all {
            externalParents.any { parentInterface -> it == parentInterface.name }
        }
    }

    override fun hasExternalParent(predicate: (KoExternalParentDeclaration) -> Boolean): Boolean = externalParents.any(predicate)

    override fun hasAllExternalParents(predicate: (KoExternalParentDeclaration) -> Boolean): Boolean = externalParents.all(predicate)

    override fun hasExternalParentOf(name: KClass<*>, vararg names: KClass<*>): Boolean =
        checkIfExternalParentOf(name) || names.any { checkIfExternalParentOf(it) }

    override fun hasAllExternalParentsOf(name: KClass<*>, vararg names: KClass<*>): Boolean =
        checkIfExternalParentOf(name) && names.all { checkIfExternalParentOf(it) }

    private fun checkIfExternalParentOf(kClass: KClass<*>): Boolean = externalParents.any { parent ->
        parent.name == kClass.simpleName || parent.fullyQualifiedName == kClass.qualifiedName
    }
}