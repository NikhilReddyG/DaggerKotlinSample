package com.test.app.app

import android.app.Activity
import android.app.Application
import com.test.app.di.components.ApplicationComponent
import com.test.app.di.components.DaggerApplicationComponent
import com.test.app.di.module.ContextModule

class BaseApplication : Application(){

    internal lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        mApplicationComponent = DaggerApplicationComponent.builder().contextModule(ContextModule(this)).build()
        mApplicationComponent.injectApplication(this)

    }

    companion object {
        fun get(activity: Activity): BaseApplication {
            return activity.application as BaseApplication
        }
    }

    fun getApplicationComponent(): ApplicationComponent {
        return mApplicationComponent
    }
}