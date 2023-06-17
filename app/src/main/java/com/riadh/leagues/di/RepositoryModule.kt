package com.riadh.leagues.di

import com.riadh.leagues.domain.LeaguesRepository
import com.riadh.leagues.domain.LeaguesRepositoryImp
import com.riadh.leagues.remote.SportApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLeaguesRepository(api: SportApi): LeaguesRepository {
        return LeaguesRepositoryImp(api)
    }
}