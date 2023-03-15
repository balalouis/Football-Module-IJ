package com.project.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "team_list")
data class RoomTeam(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val crest: String,
)

class RoomTeamTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun roomTeamToString(roomTeam: RoomTeam): String {
        return gson.toJson(roomTeam)
    }

    @TypeConverter
    fun stringToRoomTeam(roomTeamString: String): RoomTeam {
        val objectType = object : TypeToken<RoomTeam>() {}.type
        return gson.fromJson(roomTeamString, objectType)
    }
}