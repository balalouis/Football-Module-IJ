package com.project.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.parcelize.Parcelize

@Entity(tableName = "competitions_list_table")
@Parcelize
data class CompetitionsUiState(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    val name: String,
    val currentSeason: CurrentSeason
):Parcelable

@Parcelize
data class CurrentSeason(
    val startDate: String,
    val endDate: String,
):Parcelable

class CurrentSeasonTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun currentSeasonToString(currentSeason: CurrentSeason): String {
        return gson.toJson(currentSeason)
    }

    @TypeConverter
    fun stringToCurrentSeason(currentSeason: String): CurrentSeason {
        val objectType = object : TypeToken<CurrentSeason>() {}.type
        return gson.fromJson(currentSeason, objectType)
    }

}


