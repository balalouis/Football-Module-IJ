package com.competition.detail.data.hilt

import com.competition.detail.data.datasource.RemoteDataSourceGetTable
import com.competition.detail.data.datasource.RemoteDataSourceGetTableImpl
import com.competition.detail.data.repo.TableRepositoryImpl
import com.competition.detail.domain.repo.TableRepository
import com.competition.detail.domain.usecases.GetAllTableUseCases
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object HiltDetailModule {

    @Provides
    fun provideAllCompetitionUseCases(tableRepository: TableRepository): GetAllTableUseCases {
        return GetAllTableUseCases(tableRepository)
    }

    @Provides
    fun provideGetTableRepository(remoteDataSourceGetTable: RemoteDataSourceGetTable): TableRepository{
        return TableRepositoryImpl(remoteDataSourceGetTable)
    }

    @Provides
    fun provideTableRemoteDataSource(footballDao: FootballDao, apiService: ApiService):RemoteDataSourceGetTable{
        return RemoteDataSourceGetTableImpl(footballDao, apiService)
    }

}