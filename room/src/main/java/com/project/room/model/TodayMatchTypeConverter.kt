package com.project.room.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MatchTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun matchToString(match: Match): String {
        return gson.toJson(match)
    }

    @TypeConverter
    fun stringToMatch(matchString: String): Match {
        val objectType = object : TypeToken<Match>() {}.type
        return gson.fromJson(matchString, objectType)
    }

}


class MatchesByDateTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun matchesByDateToString(matchesByDate: MatchesByDate): String {
        return gson.toJson(matchesByDate)
    }

    @TypeConverter
    fun stringToMatchesByDate(matchesByDateString: String): MatchesByDate {
        val objectType = object : TypeToken<MatchesByDate>() {}.type
        return gson.fromJson(matchesByDateString, objectType)
    }

}

class AwayTeamTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun awayTeamToString(awayTeam: AwayTeam): String {
        return gson.toJson(awayTeam)
    }

    @TypeConverter
    fun stringToAwayTeam(awayString: String): AwayTeam {
        val objectType = object : TypeToken<AwayTeam>() {}.type
        return gson.fromJson(awayString, objectType)
    }

}


class HomeTeamTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun homeTeamToString(homeTeam: HomeTeam): String {
        return gson.toJson(homeTeam)
    }

    @TypeConverter
    fun stringToHomeTeam(homeString: String): HomeTeam {
        val objectType = object : TypeToken<HomeTeam>() {}.type
        return gson.fromJson(homeString, objectType)
    }

}

class ScoreTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun scoreToString(score: Score): String {
        return gson.toJson(score)
    }

    @TypeConverter
    fun stringToScore(scoreString: String): Score {
        val objectType = object : TypeToken<Score>() {}.type
        return gson.fromJson(scoreString, objectType)
    }

}


class FullTimeTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun fullTimeToString(fullTime: FullTime): String {
        return gson.toJson(fullTime)
    }

    @TypeConverter
    fun stringToFullTime(fullTimeString: String): FullTime {
        val objectType = object : TypeToken<FullTime>() {}.type
        return gson.fromJson(fullTimeString, objectType)
    }

}



class HalfTimeTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun halfTimeToString(halfTime: HalfTime): String {
        return gson.toJson(halfTime)
    }

    @TypeConverter
    fun stringToHalfTime(halfTimeString: String): HalfTime {
        val objectType = object : TypeToken<HalfTime>() {}.type
        return gson.fromJson(halfTimeString, objectType)
    }

}