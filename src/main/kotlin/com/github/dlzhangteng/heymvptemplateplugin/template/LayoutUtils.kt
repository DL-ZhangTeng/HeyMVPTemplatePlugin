package com.github.dlzhangteng.heymvptemplateplugin.template

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest

/**
 * 获取layoutName
 */
fun getLayoutName(pageName: String): String {
    val stringBuilder: StringBuilder = StringBuilder()
    val activityChildNames: ArrayList<String> = splitByUpperCase(
        pageName
    )
    activityChildNames.forEach {
        stringBuilder.append("_").append(it.lowercase())
    }
    return stringBuilder.toString()
}

/**
 * 根据大写字母拆分数组
 */
fun splitByUpperCase(str: String): ArrayList<String> {
    val rs = ArrayList<String>()
    var index = 0
    val len = str.length
    for (i in 1 until len) {
        if (Character.isUpperCase(str[i])) {
            rs.add(str.substring(index, i))
            index = i
        }
    }
    rs.add(str.substring(index, len))
    return rs
}

/**
 * description 添加activity到Manifest
 * @param activityClass activity相对路径如：.activity.BaseActivity
 */
fun addActivityToManifest(
    recipeExecutor: RecipeExecutor,
    moduleTemplateData: ModuleTemplateData,
    activityClass: String
) {
    recipeExecutor.generateManifest(
        moduleData = moduleTemplateData,
        activityClass = activityClass,
        packageName = "",
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false
    )
}
