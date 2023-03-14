package com.project.room.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class StandingTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun standingToString(standing: Standing): String {
        return gson.toJson(standing)
    }

    @TypeConverter
    fun stringToStanding(standingString: String): Standing {
        val objectType = object : TypeToken<Standing>() {}.type
        return gson.fromJson(standingString, objectType)
    }
}

class TeamTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun teamToString(team: Team): String {
        return gson.toJson(team)
    }

    @TypeConverter
    fun stringToTeam(teamString: String): Team {
        val objectType = object : TypeToken<Team>() {}.type
        return gson.fromJson(teamString, objectType)
    }
}

class TableListConverter{

    private val gson = Gson()

    @TypeConverter
    fun stringToListServer(data: String?): List<Table?> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Table?>?>() {}.type
        return gson.fromJson<List<Table?>>(data, listType)
    }

    @TypeConverter
    fun listServerToString(someObjects: List<Table?>?): String? {
        return gson.toJson(someObjects)
    }
}

class TableTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun tableToString(table: Table): String {
        return gson.toJson(table)
    }

    @TypeConverter
    fun stringToTable(tableString: String): Table {
        val objectType = object : TypeToken<Table>() {}.type
        return gson.fromJson(tableString, objectType)
    }

}