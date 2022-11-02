package com.github.dlzhangteng.heymvptemplateplugin.template.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.dlzhangteng.heymvptemplateplugin.template.addActivityToManifest
import com.github.dlzhangteng.heymvptemplateplugin.template.layout.baseXml

fun RecipeExecutor.baseActivityRecipe(
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
    val baseActivity = baseActivity(
        rootPath,
        packageNameStr,
        mPageName
    )
    save(
        baseActivity,
        moduleTemplateData.srcDir.resolve("${mPageName}Activity.java")
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

    addActivityToManifest(
        this,
        moduleTemplateData,
        "${packageNameStr}.${mPageName}Activity".substring(1)
    )
}