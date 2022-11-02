package com.github.dlzhangteng.heymvptemplateplugin.template.fragment

fun basePresenter(
    mRootPackageName: String?,
    mActivityPackageName: String,
    mPageName: String
) = """
package ${mRootPackageName}${mActivityPackageName.ifEmpty { "" }};

import com.sskj.common.base.BasePresenter;

class ${mPageName}Presenter extends BasePresenter<${mPageName}Fragment> {

}
"""
