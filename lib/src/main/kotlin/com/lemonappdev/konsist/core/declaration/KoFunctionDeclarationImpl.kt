package com.lemonappdev.konsist.core.declaration

import com.lemonappdev.konsist.api.declaration.KoBaseDeclaration
import com.lemonappdev.konsist.api.declaration.KoFunctionDeclaration
import com.lemonappdev.konsist.api.provider.KoParentProvider
import com.lemonappdev.konsist.core.cache.KoDeclarationCache
import com.lemonappdev.konsist.core.provider.KoAnnotationDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoDeclarationFullyQualifiedNameProviderCore
import com.lemonappdev.konsist.core.provider.KoExplicitReturnTypeProviderCore
import com.lemonappdev.konsist.core.provider.KoExtensionProviderCore
import com.lemonappdev.konsist.core.provider.KoImplementationProviderCore
import com.lemonappdev.konsist.core.provider.KoModifierProviderCore
import com.lemonappdev.konsist.core.provider.KoPackageDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoParametersProviderCore
import com.lemonappdev.konsist.core.provider.KoReceiverTypeProviderCore
import com.lemonappdev.konsist.core.provider.KoTopLevelProviderCore
import com.lemonappdev.konsist.core.util.TagUtil
import org.jetbrains.kotlin.psi.KtCallableDeclaration
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtTypeParameterListOwner

@Suppress("detekt.TooManyFunctions")
internal class KoFunctionDeclarationImpl private constructor(
    override val ktFunction: KtFunction,
    override val parentDeclaration: KoParentProvider?,
) :
    KoBaseDeclarationImpl(ktFunction),
    KoAnnotationDeclarationProviderCore,
    KoPackageDeclarationProviderCore,
    KoDeclarationFullyQualifiedNameProviderCore,
    KoModifierProviderCore,
    KoTopLevelProviderCore,
    KoParametersProviderCore,
    KoFunctionDeclaration,
    KoExtensionProviderCore,
    KoExplicitReturnTypeProviderCore,
    KoReceiverTypeProviderCore,
    KoImplementationProviderCore {
    override val ktTypeParameterListOwner: KtTypeParameterListOwner
        get() = ktCallableDeclaration

    override val ktCallableDeclaration: KtCallableDeclaration
        get() = ktFunction

    private val localDeclarations: Sequence<KoBaseDeclaration>
        get() {
            val psiChildren = ktFunction
                .bodyBlockExpression
                ?.children
                ?.asSequence()
                ?: emptySequence()

            return psiChildren
                .mapNotNull {
                    if (it is KtClass && !it.isInterface()) {
                        KoClassDeclarationImpl.getInstance(it, this)
                    } else if (it is KtFunction) {
                        getInstance(it, this)
                    } else if (it is KtProperty) {
                        KoPropertyDeclarationImpl.getInstance(it, this)
                    } else {
                        null
                    }
                }
        }

    override fun localDeclarations(): Sequence<KoBaseDeclaration> = localDeclarations

    override fun hasValidReturnTag(enabled: Boolean): Boolean = TagUtil.hasValidReturnTag(enabled, explicitReturnType?.name, kDoc)

    override fun hasValidParamTag(enabled: Boolean): Boolean = TagUtil.hasValidParamTag(enabled, parameters, kDoc)

    override fun hasValidReceiverTag(enabled: Boolean): Boolean = TagUtil.hasValidReceiverTag(enabled, kDoc)

    internal companion object {

        private val cache: KoDeclarationCache<KoFunctionDeclaration> = KoDeclarationCache()
        internal fun getInstance(ktFunction: KtFunction, parentDeclaration: KoParentProvider?): KoFunctionDeclaration =
            cache.getOrCreateInstance(ktFunction, parentDeclaration) {
                KoFunctionDeclarationImpl(ktFunction, parentDeclaration)
            }
    }
}
