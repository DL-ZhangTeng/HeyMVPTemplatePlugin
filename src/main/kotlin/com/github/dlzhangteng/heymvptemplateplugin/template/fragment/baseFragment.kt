package com.github.dlzhangteng.heymvptemplateplugin.template.fragment

import com.github.dlzhangteng.heymvptemplateplugin.template.getLayoutName

fun baseFragment(
    mRootPackageName: String?,
    mActivityPackageName: String,
    mPageName: String
) = """
package ${mRootPackageName}${mActivityPackageName.ifEmpty { "" }};

import com.sskj.common.base.BaseFragment;

import android.os.Bundle;
import ${mRootPackageName}.R;

public class ${mPageName}Fragment extends BaseFragment<${mPageName}Presenter> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment${getLayoutName(mPageName)};
    }

    @Override
    public ${mPageName}Presenter getPresenter() {
        return new ${mPageName}Presenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

   public static ${mPageName}Fragment newInstance() {
        ${mPageName}Fragment fragment = new ${mPageName}Fragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }
}

"""
