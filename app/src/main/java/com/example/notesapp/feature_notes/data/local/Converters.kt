package com.example.notesapp.feature_notes.data.local

import androidx.room.TypeConverter
import java.time.LocalDateTime

class Converters {
    // Conversions for types Room cannot store directly
    @TypeConverter
    fun timeToString(time: LocalDateTime): String = time.toString()

    @TypeConverter
    fun stringToTime(string: String): LocalDateTime = LocalDateTime.parse(string)
}