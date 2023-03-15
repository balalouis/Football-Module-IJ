package com.competition.detail.data.hilt

import com.competition.detail.data.datasource.table.RemoteDataSourceGetTable
import com.competition.detail.data.datasource.table.RemoteDataSourceGetTableImpl
import com.competition.detail.data.datasource.team.RemoteDataSourceGetTeam
import com.competition.detail.data.datasource.team.RemoteDataSourceGetTeamImpl
import com.competition.detail.data.repo.TableRepositoryImpl
import com.competition.detail.data.repo.TeamRepositoryImpl
import com.competition.detail.domain.repo.TableRepository
import com.competition.detail.domain.repo.TeamRepository
import com.competition.detail.domain.usecases.GetAllTableUseCases
import com.competition.detail.domain.usecases.GetAllTeamUseCases
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

    @Provides
    fun provideGetAllTeamUseCases(teamRepository: TeamRepository): GetAllTeamUseCases {
        return GetAllTeamUseCases(teamRepository)
    }

    @Provides
    fun provideGetTeamRepository(remoteDataSourceGetTeam: RemoteDataSourceGetTeam): TeamRepository{
        return TeamRepositoryImpl(remoteDataSourceGetTeam)
    }

    @Provides
    fun provideTeamRemoteDataSource(footballDao: FootballDao, apiService: ApiService):RemoteDataSourceGetTeam{
        return RemoteDataSourceGetTeamImpl(footballDao, apiService)
    }

}