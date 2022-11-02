package com.github.dlzhangteng.heymvptemplateplugin.template.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.dlzhangteng.heymvptemplateplugin.template.layout.baseXml

fun RecipeExecutor.baseFragmentRecipe(
    moduleTemplateData: ModuleTemplateData,
    mPageName: String,
    mActivityLayoutName: String,
    mIsGenerateActivityLayout: Boolean,
    mActivityPackageName: String,
) {
    val packageNameStr =
        if (moduleTemplateData.projectTemplateData.applicationPackage == null) ""
        else mActivityPackageName
            .replace(moduleTemplateData.projectTemplateData.applicationPackage.toString(), "")
    val rootPath =
        if (packageNameStr.isNotEmpty()) moduleTemplateData.projectTemplateData.applicationPackage.toString()
        else mActivityPackageName

    val baseFragment = baseFragment(
        rootPath,
        packageNameStr,
        mPageName
    )
    save(
        baseFragment,
        moduleTemplateData.srcDir.resolve("${mPageName}Fragment.java")
    )

    val basePresenter = basePresenter(
        rootPath,
        packageNameStr,
        mPageName
    )
    save(
        basePresenter,
        moduleTemplateData.srcDir.resolve("${mPageName}Presenter.java")
    )

    if (mIsGenerateActivityLayout) {
        // 保存xml
        save(baseXml(), moduleTemplateData.resDir.resolve("layout/${mActivityLayoutName}.xml"))
    }
}