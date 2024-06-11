package com.izharuddin1997.trinitywizard.data.di

import com.izharuddin1997.trinitywizard.data.repository.implementation.MyContactRepositoryImpl
import com.izharuddin1997.trinitywizard.data.repository.interfaces.MyContactRepository
import com.izharuddin1997.trinitywizard.data.source.remote.service.MyContactService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyContactModule {

    @Singleton
    @Provides
    fun provideMyContactRepository(
        service: MyContactService,
    ): MyContactRepository {
        return MyContactRepositoryImpl(service)
    }
}
