package com.github.dlzhangteng.heymvptemplateplugin.template.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.github.dlzhangteng.heymvptemplateplugin.template.getLayoutName
import java.io.File

val baseActivityTemplate
    get() = template {
        name = "ZTHeyMVPActivity"
        description = "一键创建 HeyMVPActivity "
        minApi = MIN_API
        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val mActivityPackageName = stringParameter {
            name = "Root Package Name"
            constraints = listOf(Constraint.PACKAGE, Constraint.NONEMPTY)
            default = "com.zhangteng.heymvp"
            visible = { !isNewModule }
            help = "Activity 包名"
        }

        val mPageName = stringParameter {
            name = "Create Page Name"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            default = "Main"
            help = "需要生成页面的名字,不需要再写 名字后缀:如Activity、Fragment,会自动生成,以及对应文件名后缀"
        }

        val mIsGenerateActivityLayout = booleanParameter {
            name = "Generate Activity Layout"
            default = true
            help = "默认勾选,如果使用已存在布局 则无需勾选,若不勾选,创建后记得修改Act或 Fragment 绑定的视图文件！！！"
        }

        val mActivityLayoutName = stringParameter {
            name = "Activity Layout Name"
            default = "activity_main"
            visible = { mIsGenerateActivityLayout.value }
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { "activity${getLayoutName(mPageName.value)}" }
        }

        thumb { File("template_empty_activity.png") }

        widgets(
            TextFieldWidget(mPageName),
            TextFieldWidget(mActivityLayoutName),
            CheckBoxWidget(mIsGenerateActivityLayout),
            PackageNameWidget(mActivityPackageName),
        )

        recipe = { data: TemplateData ->
            baseActivityRecipe(
                data as ModuleTemplateData,
                mPageName.value,
                mActivityLayoutName.value,
                mIsGenerateActivityLayout.value,
                mActivityPackageName.value
            )
        }

    }
