package com.test.app.di.module

import android.content.Context
import com.test.app.di.qualifier.ActivityContext
import com.test.app.di.scope.ActivityScope
import com.test.app.view.AlbumActivity
import com.test.mvvmsample.viewmodel.AlbumViewModel
import dagger.Module
import dagger.Provides

@Module
class AlbumActivityModule(var mAlbumActivity: AlbumActivity) {

    var mContext: Context = mAlbumActivity

    @Provides
    @ActivityScope
    fun providesAlbumActivity(): AlbumActivity {
        return mAlbumActivity
    }

    @Provides
    @ActivityScope
    @ActivityContext
    fun provideContext(): Context {
        return mContext
    }

    @Provides
    fun fetchAlbumDetails(): AlbumViewModel {
        return AlbumViewModel()
    }
}