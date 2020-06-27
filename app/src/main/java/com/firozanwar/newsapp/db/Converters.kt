package com.firozanwar.newsapp.db

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.Source

class Converters {

    @TypeConverter
    fun fromSourese(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSourese(name: String): Source {
        return Source(name, name)
    }

}