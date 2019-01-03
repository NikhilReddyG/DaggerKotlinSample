package com.test.app.di.module

import com.test.app.di.scope.ActivityScope
import com.test.app.view.AlbumActivity
import com.test.app.view.AlbumAdapter
import dagger.Module
import dagger.Provides

@Module(includes = [AlbumActivityModule::class])
class AlbumAdapterModule(){

    @Provides
    @ActivityScope
    fun getAlbumsList(mClickListener: AlbumAdapter.ClickListener): AlbumAdapter {
        return AlbumAdapter(mClickListener)
    }

    @Provides
    @ActivityScope
    fun setOnClickListener(mAlbumActivity: AlbumActivity): AlbumAdapter.ClickListener {
        return mAlbumActivity
    }
}