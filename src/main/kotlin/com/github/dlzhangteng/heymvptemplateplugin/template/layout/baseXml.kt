package com.github.dlzhangteng.heymvptemplateplugin.template.layout

fun baseXml() = """
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:background="@color/common_background"
    android:orientation="vertical">

    <com.sskj.common.view.ToolBarLayout
        app:background_color="@color/common_action_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
    
</LinearLayout>
"""
