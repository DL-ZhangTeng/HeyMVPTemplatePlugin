package com.github.dlzhangteng.heymvptemplateplugin.template.activity

fun baseActivity(
    mRootPackageName: String?,
    mActivityPackageName: String,
    mPageName: String,
    mActivityLayoutName: String,
) = """
package ${mRootPackageName}${mActivityPackageName.ifEmpty { "" }};

import com.sskj.common.base.BaseActivity;

import android.content.Context;
import android.content.Intent;
import ${mRootPackageName}.R;

public class ${mPageName}Activity extends BaseActivity<${mPageName}Presenter> {

    @Override
    public int getLayoutId() {
        return R.layout.${mActivityLayoutName};
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

    public static void start(Context context){
        Intent intent=new Intent(context,${mPageName}Activity.class);
        context.startActivity(intent);
    }
}
"""
