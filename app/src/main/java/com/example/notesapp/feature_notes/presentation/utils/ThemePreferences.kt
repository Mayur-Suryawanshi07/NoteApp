package com.example.notesapp.feature_notes.presentation.utils

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// File-level DataStore delegate
private val Context.settingsDataStore by preferencesDataStore(name = "settings")

object ThemePreferences {
    private val DARK_MODE_KEY: Preferences.Key<Boolean> = booleanPreferencesKey("dark_mode")

    fun darkModeFlow(context: Context): Flow<Boolean> =
        context.settingsDataStore.data.map { prefs ->
            prefs[DARK_MODE_KEY] ?: false
        }

    suspend fun setDarkMode(context: Context, enabled: Boolean) {
        context.settingsDataStore.edit { prefs ->
            prefs[DARK_MODE_KEY] = enabled
        }
    }
}


