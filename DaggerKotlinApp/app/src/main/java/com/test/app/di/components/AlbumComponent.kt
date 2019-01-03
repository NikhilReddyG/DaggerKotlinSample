package com.test.app.di.components

import android.content.Context
import com.test.app.di.module.AlbumAdapterModule
import com.test.app.di.qualifier.ActivityContext
import com.test.app.di.scope.ActivityScope
import com.test.app.view.AlbumActivity
import dagger.Component

@ActivityScope
@Component(modules = [AlbumAdapterModule::class], dependencies = [ApplicationComponent::class])
interface AlbumComponent {

    @ActivityContext
    fun getContext(): Context

    fun injectAlbumActivity(mAlbumActivity: AlbumActivity)
}