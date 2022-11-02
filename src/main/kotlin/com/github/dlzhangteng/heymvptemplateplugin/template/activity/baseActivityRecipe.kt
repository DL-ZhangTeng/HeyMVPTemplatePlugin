package com.github.dlzhangteng.heymvptemplateplugin.template.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.dlzhangteng.heymvptemplateplugin.template.layout.baseXml

fun RecipeExecutor.baseActivityRecipe(
    moduleTemplateData: ModuleTemplateData,
    mPageName: String,
    mActivityLayoutName: String,
    mIsGenerateActivityLayout: Boolean,
    mActivityPackageName: String,
) {
//    generateManifest(
//        moduleData = moduleTemplateData,
//        activityClass = "${mPageName}Activity",
//        packageName = mActivityPackageName,
//        isLauncher = false,
//        hasNoActionBar = false,
//        generateActivityTitle = false
//    )

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
}