package com.izharuddin1997.trinitywizard.data.di

import android.content.Context
import com.izharuddin1997.trinitywizard.data.source.remote.service.MyContactService
import com.izharuddin1997.trinitywizard.utils.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Singleton
    @Provides
    fun provideAuthService(
        @ApplicationContext context: Context
    ): MyContactService {
        return RetrofitBuilder.build(
            context = context,
            type = MyContactService::class.java
        )
    }
}
