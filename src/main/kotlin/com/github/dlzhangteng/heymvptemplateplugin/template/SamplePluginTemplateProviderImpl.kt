package com.github.dlzhangteng.heymvptemplateplugin.template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.dlzhangteng.heymvptemplateplugin.template.activity.baseActivityTemplate
import com.github.dlzhangteng.heymvptemplateplugin.template.fragment.baseFragmentTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        baseActivityTemplate,
        baseFragmentTemplate,
    )
}