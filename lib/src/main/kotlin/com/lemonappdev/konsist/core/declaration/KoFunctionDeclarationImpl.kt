package com.lemonappdev.konsist.core.declaration

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.declaration.KoBaseDeclaration
import com.lemonappdev.konsist.api.declaration.KoFunctionDeclaration
import com.lemonappdev.konsist.api.declaration.KoTypeDeclaration
import com.lemonappdev.konsist.api.provider.KoExtensionProvider
import com.lemonappdev.konsist.api.provider.KoParentProvider
import com.lemonappdev.konsist.core.cache.KoDeclarationCache
import com.lemonappdev.konsist.core.provider.KoExtensionProviderCore
import com.lemonappdev.konsist.core.provider.KoModifierProviderCore
import com.lemonappdev.konsist.core.provider.KoReceiverTypeProviderCore
import com.lemonappdev.konsist.core.provider.KoReturnTypeProviderCore
import com.lemonappdev.konsist.core.util.ReceiverUtil
import com.lemonappdev.konsist.core.util.TagUtil
import org.jetbrains.kotlin.psi.KtCallableDeclaration
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtTypeReference
import org.jetbrains.kotlin.psi.psiUtil.isExtensionDeclaration

@Suppress("detekt.TooManyFunctions")
internal class KoFunctionDeclarationImpl private constructor(override val ktFunction: KtFunction, parentDeclaration: KoParentProvider?) :
    KoParametrizedDeclarationImpl(ktFunction, parentDeclaration),
    KoFunctionDeclaration,
    KoModifierProviderCore,
    KoExtensionProviderCore,
    KoReturnTypeProviderCore,
    KoReceiverTypeProviderCore {
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

    override fun hasValidReturnTag(enabled: Boolean): Boolean = TagUtil.hasValidReturnTag(enabled, returnType?.name, kDoc)

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
