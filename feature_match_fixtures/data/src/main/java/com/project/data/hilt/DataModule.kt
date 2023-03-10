package com.project.data.hilt

import com.project.data.datasource.RemoteDataSourceCompetitions
import com.project.data.datasource.RemoteDataSourceCompetitionsImpl
import com.project.data.repo.GetAllMatchesRepositoryImpl
import com.project.data.datasource.RemoteDataSourceGetAllMatches
import com.project.data.datasource.RemoteDataSourceGetAllMatchesImpl
import com.project.data.repo.GetAllCompetitionRepositoryImpl
import com.project.domain.repository.GetAllCompetitionRepository
import com.project.domain.repository.GetAllMatchesRepository
import com.project.domain.usecases.GetAllCompetitionUseCases
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
    fun provideGetAllMatchesRepositoryImpl(remoteDataSourceGetAllMatches: RemoteDataSourceGetAllMatches): GetAllMatchesRepository{
        return GetAllMatchesRepositoryImpl(remoteDataSourceGetAllMatches)
    }

    @Provides
    fun provideRemoteDataSource(footballDao: FootballDao,apiService: ApiService):RemoteDataSourceGetAllMatches{
        return RemoteDataSourceGetAllMatchesImpl(footballDao, apiService)
    }

    @Provides
    fun provideAllCompetitionUseCases(getAllCompetitionRepository: GetAllCompetitionRepository): GetAllCompetitionUseCases {
        return GetAllCompetitionUseCases(getAllCompetitionRepository)
    }

    @Provides
    fun provideGetAllCompetitionRepository(remoteDataSourceCompetitions: RemoteDataSourceCompetitions): GetAllCompetitionRepository{
        return GetAllCompetitionRepositoryImpl(remoteDataSourceCompetitions)
    }

    @Provides
    fun provideCompetitionDataSource(footballDao: FootballDao,apiService: ApiService):RemoteDataSourceCompetitions{
        return RemoteDataSourceCompetitionsImpl(footballDao, apiService)
    }

}