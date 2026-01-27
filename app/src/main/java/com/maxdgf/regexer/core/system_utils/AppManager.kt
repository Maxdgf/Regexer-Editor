package com.maxdgf.regexer.core.system_utils

import android.app.Activity
import android.content.Context
import kotlin.system.exitProcess

class AppManager(
    private val activity: Activity?,
    context: Context
) {
    private val packageManager = context.packageManager // package manager
    private val packageInfo = packageManager.getPackageInfo(context.packageName, 0) // package info

    /**Exits app.*/
    fun breakApp() {
        activity?.finish() // finish activity
        exitProcess(0) // exit process
    }

    /**
     * Returns app version name.
     * @return app version name.
     */
    fun getAppVersionName(): String? = packageInfo.versionName // app version name
}