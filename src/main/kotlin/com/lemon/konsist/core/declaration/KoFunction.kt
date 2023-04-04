package com.lemon.konsist.core.declaration

import com.lemon.konsist.core.declaration.logger.KoLogger
import com.lemon.konsist.core.declaration.provider.KoLocalClassProvider
import com.lemon.konsist.core.declaration.provider.KoLocalFunctionProvider
import com.lemon.konsist.core.declaration.provider.KoLocalPropertyProvider
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtTypeReference
import org.jetbrains.kotlin.psi.psiUtil.getTextWithLocation
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstanceOrNull

class KoFunction private constructor(private val ktFunction: KtFunction) :
    KoParametrizedDeclaration(ktFunction),
    KoLocalClassProvider,
    KoLocalFunctionProvider,
    KoLocalPropertyProvider {

    val isOperator by lazy { ktFunction.modifierList?.hasModifier(KtTokens.OPERATOR_KEYWORD) ?: false }

    val isInline by lazy { ktFunction.modifierList?.hasModifier(KtTokens.INLINE_KEYWORD) ?: false }

    private val localDeclarations by lazy {
        val psiChildren = ktFunction
            .bodyBlockExpression
            ?.children
            ?.toList()
            ?: emptyList()

        psiChildren.mapNotNull {
            if (it is KtClass && !it.isInterface()) {
                KoClass.getInstance(it)
            } else if (it is KtFunction) {
                KoFunction.getInstance(it)
            } else if (it is KtProperty) {
                KoProperty.getInstance(it)
            } else {
                KoLogger.logError("Unknown local declaration type: ${it.getTextWithLocation()}")
                null
            }
        }
    }

    val hasExplicitReturnType by lazy { ktFunction.hasDeclaredReturnType() }

    val getExplicitReturnType by lazy {
        ktFunction
            .children
            .firstIsInstanceOrNull<KtTypeReference>()
            ?.text
    }

    override fun localDeclarations(): List<KoDeclaration> = localDeclarations

    companion object {
        private val cache = KoDeclarationCache<KoFunction>()
        fun getInstance(ktFunction: KtFunction) = if (cache.hasKey(ktFunction)) {
            cache.get(ktFunction)
        } else {
            cache.set(ktFunction, KoFunction(ktFunction))
            cache.get(ktFunction)
        }
    }
}
