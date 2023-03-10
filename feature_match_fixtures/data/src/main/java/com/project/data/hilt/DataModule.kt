package com.project.data.hilt

import com.project.data.GetAllMatchesRepositoryImpl
import com.project.data.datasource.RemoteDataSourceGetAllMatches
import com.project.data.datasource.RemoteDataSourceGetAllMatchesImpl
import com.project.domain.repository.GetAllMatchesRepository
import com.project.domain.usecases.GetAllMatchUseCases
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun provideGetTodayMatchUseCases(getAllMatchesRepository: GetAllMatchesRepository): GetAllMatchUseCases {
        return GetAllMatchUseCases(getAllMatchesRepository)
    }

    @Provides
    fun provideGetCompetitionsRepository(remoteDataSourceGetAllMatches: RemoteDataSourceGetAllMatches): GetAllMatchesRepository{
        return GetAllMatchesRepositoryImpl(remoteDataSourceGetAllMatches)
    }

    @Provides
    fun provideRemoteDataSource(footballDao: FootballDao,apiService: ApiService):RemoteDataSourceGetAllMatches{
        return RemoteDataSourceGetAllMatchesImpl(footballDao, apiService)
    }

}