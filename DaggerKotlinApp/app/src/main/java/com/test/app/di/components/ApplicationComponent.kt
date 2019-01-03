package com.test.app.di.components

import android.content.Context
import com.test.app.api.APIInterface
import com.test.app.app.BaseApplication
import com.test.app.di.module.ContextModule
import com.test.app.di.module.RetrofitModule
import com.test.app.di.qualifier.ApplicationContext
import com.test.app.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [ContextModule::class, RetrofitModule::class])
interface ApplicationComponent {

    fun getApiInterface(): APIInterface

    @ApplicationContext fun getContext(): Context

    fun injectApplication(mBaseApplication: BaseApplication)
}