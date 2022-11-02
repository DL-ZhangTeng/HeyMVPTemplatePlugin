package com.github.dlzhangteng.heymvptemplateplugin.template.activity

fun baseActivity(
    mRootPackageName: String?,
    mActivityPackageName: String,
    mPageName: String
) = """
package ${mRootPackageName}${if (mActivityPackageName.isNullOrEmpty()) "" else ".${mActivityPackageName}"};

import com.sskj.common.base.BaseActivity;
import ${mRootPackageName}.${mPageName}Presenter;
import android.content.Context;
import android.content.Intent;
import ${mRootPackageName}.R;

public class ${mPageName}Activity extends BaseActivity<${mPageName}Presenter> {

    @Override
    public int getLayoutId() {
        return R.layout.activity${getLayoutName(mPageName)};
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
