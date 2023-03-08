package com.project.room

import androidx.room.*
import com.project.room.model.Match

@Dao
interface FootballDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserList(user: List<Match>?)

}