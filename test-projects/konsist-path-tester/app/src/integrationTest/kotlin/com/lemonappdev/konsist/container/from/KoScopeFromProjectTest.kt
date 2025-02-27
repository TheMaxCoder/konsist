package com.lemonappdev.konsist.container.from

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.helper.ext.mapToFilePaths
import com.lemonappdev.konsist.helper.ext.toOsSeparator
import com.lemonappdev.konsist.helper.util.PathProvider.appIntegrationTestSourceSetDirectory
import com.lemonappdev.konsist.helper.util.PathProvider.appMainSourceSetDirectory
import com.lemonappdev.konsist.helper.util.PathProvider.dataMainSourceSetDirectory
import com.lemonappdev.konsist.helper.util.PathProvider.dataTestSourceSetDirectory
import com.lemonappdev.konsist.helper.util.PathProvider.projectRootDirectory
import com.lemonappdev.konsist.helper.util.PathProvider.rootMainSourceSetDirectory
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoScopeFromProjectTest {
    @Suppress("detekt.LongMethod")
    @Test
    fun `scopeFromProject ignoreBuildConfig true`() {
        // given
        val sut = Konsist
            .scopeFromProject(ignoreBuildConfig = true)
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appIntegrationTestSourceSetDirectory/konsist/container/KoScopeTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromDirectoryTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromFileTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromFilesTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromModuleTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromPackageTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromProductionTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromProjectTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromSourceSetTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koannotation/KoAnnotationForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koannotation/KoAnnotationForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koargument/KoArgumentForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koargument/KoArgumentForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassDeclarationForKoHasTestClassProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koconstructor/KoConstructorForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koconstructor/KoConstructorForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koenumconstant/KoEnumConstantForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koenumconstant/KoEnumConstantForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofile/KoFileForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofile/KoFileForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofunction/KoFunctionForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofunction/KoFunctionForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kogetter/KoGetterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kogetter/KoGetterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koimport/KoImportForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koimport/KoImportForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koinitblock/KoInitBlockForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koinitblock/KoInitBlockForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kointerface/KoInterfaceForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kointerface/KoInterfaceForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kokdoc/KoKDocForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kokdoc/KoKDocForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koobject/KoObjectForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koobject/KoObjectForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kopackage/KoPackageForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kopackage/KoPackageForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparameter/KoParameterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparameter/KoParameterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparent/KoParentForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparent/KoParentForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koproperty/KoPropertyForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koproperty/KoPropertyForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kosetter/KoSetterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kosetter/KoSetterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotype/KoTypeForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotype/KoTypeForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotypealias/KoTypeAliasForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotypealias/KoTypeAliasForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/ext/KoScopeExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/ext/PathExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/util/PathProvider.kt",
                "$appIntegrationTestSourceSetDirectory/sample/AppClassTest.kt",
                "$appIntegrationTestSourceSetDirectory/sample/data/AppDataClassTest.kt",
                "$appMainSourceSetDirectory/sample/AppClass.kt",
                "$appMainSourceSetDirectory/sample/data/AppDataClass.kt",
                "$dataMainSourceSetDirectory/sample/LibClass.kt",
                "$dataMainSourceSetDirectory/sample/data/LibDataClass.kt",
                "$dataTestSourceSetDirectory/sample/LibClassSpec.kt",
                "$dataTestSourceSetDirectory/sample/LibClassTest.kt",
                "$dataTestSourceSetDirectory/sample/data/LibDataClassTest.kt",
                "$rootMainSourceSetDirectory/sample/RootClass.kt",
                "$rootMainSourceSetDirectory/sample/data/RootDataClass.kt",
                "$rootMainSourceSetDirectory/sample/src/RootSrcClass.kt",
            ).toOsSeparator(),
        )
    }

    @Suppress("detekt.LongMethod")
    @Test
    fun `scopeFromProject ignoreBuildConfig false`() {
        // given
        val sut = Konsist
            .scopeFromProject(ignoreBuildConfig = false)
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appIntegrationTestSourceSetDirectory/konsist/container/KoScopeTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromDirectoryTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromFileTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromFilesTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromModuleTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromPackageTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromProductionTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromProjectTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromSourceSetTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koannotation/KoAnnotationForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koannotation/KoAnnotationForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koargument/KoArgumentForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koargument/KoArgumentForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassDeclarationForKoHasTestClassProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koconstructor/KoConstructorForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koconstructor/KoConstructorForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koenumconstant/KoEnumConstantForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koenumconstant/KoEnumConstantForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofile/KoFileForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofile/KoFileForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofunction/KoFunctionForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofunction/KoFunctionForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kogetter/KoGetterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kogetter/KoGetterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koimport/KoImportForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koimport/KoImportForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koinitblock/KoInitBlockForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koinitblock/KoInitBlockForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kointerface/KoInterfaceForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kointerface/KoInterfaceForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kokdoc/KoKDocForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kokdoc/KoKDocForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koobject/KoObjectForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koobject/KoObjectForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kopackage/KoPackageForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kopackage/KoPackageForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparameter/KoParameterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparameter/KoParameterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparent/KoParentForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparent/KoParentForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koproperty/KoPropertyForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koproperty/KoPropertyForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kosetter/KoSetterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kosetter/KoSetterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotype/KoTypeForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotype/KoTypeForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotypealias/KoTypeAliasForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotypealias/KoTypeAliasForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/ext/KoScopeExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/ext/PathExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/util/PathProvider.kt",
                "$appIntegrationTestSourceSetDirectory/sample/AppClassTest.kt",
                "$appIntegrationTestSourceSetDirectory/sample/data/AppDataClassTest.kt",
                "$appMainSourceSetDirectory/sample/AppClass.kt",
                "$appMainSourceSetDirectory/sample/data/AppDataClass.kt",
                "$projectRootDirectory/buildSrc/RootBuildScrKotlinClass.kt",
                "$dataMainSourceSetDirectory/sample/LibClass.kt",
                "$dataMainSourceSetDirectory/sample/data/LibDataClass.kt",
                "$dataTestSourceSetDirectory/sample/LibClassSpec.kt",
                "$dataTestSourceSetDirectory/sample/LibClassTest.kt",
                "$dataTestSourceSetDirectory/sample/data/LibDataClassTest.kt",
                "$rootMainSourceSetDirectory/sample/RootClass.kt",
                "$rootMainSourceSetDirectory/sample/data/RootDataClass.kt",
                "$rootMainSourceSetDirectory/sample/src/RootSrcClass.kt",
            ).toOsSeparator(),
        )
    }

    @Test
    fun `scopeFromProject for data module`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "data")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$dataMainSourceSetDirectory/sample/LibClass.kt",
                "$dataMainSourceSetDirectory/sample/data/LibDataClass.kt",
                "$dataTestSourceSetDirectory/sample/LibClassSpec.kt",
                "$dataTestSourceSetDirectory/sample/LibClassTest.kt",
                "$dataTestSourceSetDirectory/sample/data/LibDataClassTest.kt",
            ).toOsSeparator(),
        )
    }

    @Test
    fun `scopeFromProject for root module`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "root")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$rootMainSourceSetDirectory/sample/RootClass.kt",
                "$rootMainSourceSetDirectory/sample/data/RootDataClass.kt",
                "$rootMainSourceSetDirectory/sample/src/RootSrcClass.kt",
            ).toOsSeparator(),
        )
    }

    @Test
    fun `scopeFromProject for main source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(sourceSetName = "main")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appMainSourceSetDirectory/sample/AppClass.kt",
                "$appMainSourceSetDirectory/sample/data/AppDataClass.kt",
                "$dataMainSourceSetDirectory/sample/LibClass.kt",
                "$dataMainSourceSetDirectory/sample/data/LibDataClass.kt",
                "$rootMainSourceSetDirectory/sample/RootClass.kt",
                "$rootMainSourceSetDirectory/sample/data/RootDataClass.kt",
                "$rootMainSourceSetDirectory/sample/src/RootSrcClass.kt",
            ).toOsSeparator(),
        )
    }

    @Suppress("detekt.LongMethod")
    @Test
    fun `scopeFromProject for integrationTest source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(sourceSetName = "integrationTest")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appIntegrationTestSourceSetDirectory/konsist/container/KoScopeTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromDirectoryTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromFileTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromFilesTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromModuleTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromPackageTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromProductionTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromProjectTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromSourceSetTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koannotation/KoAnnotationForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koannotation/KoAnnotationForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koargument/KoArgumentForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koargument/KoArgumentForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassDeclarationForKoHasTestClassProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koconstructor/KoConstructorForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koconstructor/KoConstructorForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koenumconstant/KoEnumConstantForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koenumconstant/KoEnumConstantForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofile/KoFileForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofile/KoFileForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofunction/KoFunctionForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofunction/KoFunctionForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kogetter/KoGetterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kogetter/KoGetterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koimport/KoImportForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koimport/KoImportForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koinitblock/KoInitBlockForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koinitblock/KoInitBlockForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kointerface/KoInterfaceForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kointerface/KoInterfaceForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kokdoc/KoKDocForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kokdoc/KoKDocForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koobject/KoObjectForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koobject/KoObjectForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kopackage/KoPackageForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kopackage/KoPackageForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparameter/KoParameterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparameter/KoParameterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparent/KoParentForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparent/KoParentForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koproperty/KoPropertyForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koproperty/KoPropertyForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kosetter/KoSetterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kosetter/KoSetterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotype/KoTypeForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotype/KoTypeForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotypealias/KoTypeAliasForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotypealias/KoTypeAliasForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/ext/KoScopeExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/ext/PathExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/util/PathProvider.kt",
                "$appIntegrationTestSourceSetDirectory/sample/AppClassTest.kt",
                "$appIntegrationTestSourceSetDirectory/sample/data/AppDataClassTest.kt",
            ).toOsSeparator(),
        )
    }

    @Test
    fun `scopeFromProject for test source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(sourceSetName = "test")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$dataTestSourceSetDirectory/sample/LibClassSpec.kt",
                "$dataTestSourceSetDirectory/sample/LibClassTest.kt",
                "$dataTestSourceSetDirectory/sample/data/LibDataClassTest.kt",
            ).toOsSeparator(),
        )
    }

    @Test
    fun `scopeFromProject for app module and main source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "app", sourceSetName = "main")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appMainSourceSetDirectory/sample/AppClass.kt",
                "$appMainSourceSetDirectory/sample/data/AppDataClass.kt",
            ).toOsSeparator(),
        )
    }

    @Suppress("detekt.LongMethod")
    @Test
    fun `scopeFromProject for app module and integrationTest source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "app", sourceSetName = "integrationTest")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appIntegrationTestSourceSetDirectory/konsist/container/KoScopeTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromDirectoryTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromFileTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromFilesTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromModuleTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromPackageTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromProductionTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromProjectTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromSourceSetTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/container/from/KoScopeFromTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koannotation/KoAnnotationForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koannotation/KoAnnotationForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koargument/KoArgumentForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koargument/KoArgumentForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassDeclarationForKoHasTestClassProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koclass/KoClassForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koconstructor/KoConstructorForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koconstructor/KoConstructorForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koenumconstant/KoEnumConstantForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koenumconstant/KoEnumConstantForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofile/KoFileForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofile/KoFileForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofunction/KoFunctionForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kofunction/KoFunctionForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kogetter/KoGetterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kogetter/KoGetterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koimport/KoImportForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koimport/KoImportForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koinitblock/KoInitBlockForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koinitblock/KoInitBlockForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kointerface/KoInterfaceForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kointerface/KoInterfaceForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kokdoc/KoKDocForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kokdoc/KoKDocForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koobject/KoObjectForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koobject/KoObjectForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kopackage/KoPackageForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kopackage/KoPackageForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparameter/KoParameterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparameter/KoParameterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparent/KoParentForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koparent/KoParentForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koproperty/KoPropertyForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/koproperty/KoPropertyForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kosetter/KoSetterForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kosetter/KoSetterForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotype/KoTypeForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotype/KoTypeForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotypealias/KoTypeAliasForKoModuleProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/declaration/kotypealias/KoTypeAliasForKoSourceSetProviderTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/ext/KoScopeExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/ext/PathExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/helper/util/PathProvider.kt",
                "$appIntegrationTestSourceSetDirectory/sample/AppClassTest.kt",
                "$appIntegrationTestSourceSetDirectory/sample/data/AppDataClassTest.kt",
            ).toOsSeparator(),
        )
    }

    @Test
    fun `scopeFromProject for app module and test source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "app", sourceSetName = "test")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(emptyList())
    }

    @Test
    fun `scopeFromProject for data module and main source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "data", sourceSetName = "main")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$dataMainSourceSetDirectory/sample/LibClass.kt",
                "$dataMainSourceSetDirectory/sample/data/LibDataClass.kt",
            ).toOsSeparator(),
        )
    }

    @Test
    fun `scopeFromProject for data module and integrationTest source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "data", sourceSetName = "integrationTest")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(emptyList())
    }

    @Test
    fun `scopeFromProject for data module and test source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "data", sourceSetName = "test")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$dataTestSourceSetDirectory/sample/LibClassSpec.kt",
                "$dataTestSourceSetDirectory/sample/LibClassTest.kt",
                "$dataTestSourceSetDirectory/sample/data/LibDataClassTest.kt",
            ).toOsSeparator(),
        )
    }

    @Test
    fun `scopeFromProject for root module and main source set`() {
        // given
        val sut = Konsist
            .scopeFromProject(moduleName = "root", sourceSetName = "main")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$rootMainSourceSetDirectory/sample/RootClass.kt",
                "$rootMainSourceSetDirectory/sample/data/RootDataClass.kt",
                "$rootMainSourceSetDirectory/sample/src/RootSrcClass.kt",
            ).toOsSeparator(),
        )
    }
}
