package com.test.app.di.module

import android.content.Context
import com.test.app.di.qualifier.ApplicationContext
import com.test.app.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(var mContext: Context) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context {
        return mContext
    }
}