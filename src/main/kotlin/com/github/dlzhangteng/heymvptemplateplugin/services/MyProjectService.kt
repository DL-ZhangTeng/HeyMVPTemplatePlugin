package com.github.dlzhangteng.heymvptemplateplugin.services

import com.github.dlzhangteng.heymvptemplateplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
