package com.project.room.hilt

import android.content.Context
import androidx.room.Room
import com.project.room.FootballDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideFootballDatabase(@ApplicationContext context: Context): FootballDatabase {
        return Room.databaseBuilder(
            context,
            FootballDatabase::class.java, "football-database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFootballDao(footballDatabase: FootballDatabase) = footballDatabase.footballDao()

}