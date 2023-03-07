package com.project.data.hilt

import com.project.data.CompetitionsRepositoryImpl
import com.project.data.datasource.RemoteDataSource
import com.project.data.datasource.RemoteDataSourceImpl
import com.project.domain.repository.CompetitionsRepository
import com.project.domain.usecases.GetAllMatchUseCases
import com.project.network.hilt.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun provideGetTodayMatchUseCases(competitionsRepository: CompetitionsRepository): GetAllMatchUseCases {
        return GetAllMatchUseCases(competitionsRepository)
    }

    @Provides
    fun provideGetCompetitionsRepository(remoteDataSource: RemoteDataSource): CompetitionsRepository{
        return CompetitionsRepositoryImpl(remoteDataSource)
    }

    @Provides
    fun provideRemoteDataSource(apiService: ApiService):RemoteDataSource{
        return RemoteDataSourceImpl(apiService)
    }

}