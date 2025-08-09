package com.example.notesapp.data.local

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.room.TypeConverter
import java.time.LocalDateTime

class Converters {
//converting type that cannot be understand by room
    @TypeConverter
    fun timeToString(time: LocalDateTime): String {
        return time.toString()
    }
    @TypeConverter
    fun StringToTime(string: String): LocalDateTime {
        return LocalDateTime.parse(string)
    }

    @TypeConverter
    fun fromColor(color: Color): Int {
        return color.toArgb() // Store Color as an ARGB Int
    }

    @TypeConverter
    fun toColor(argb: Int): Color {
        return Color(argb)
    }

}