package com.example.unreal.navigation

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.intellij.lang.annotations.Language
import java.util.prefs.Preferences

class DataStorePreferencesRepository (context : Context){

    private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences> = context.createDataStore(name = "languageData")
    private val defaultLangue = 1

    companion object{
        val PRE_LANGUAGE = preferencesKey<Int>("language")
        private var INSTANCE: DataStorePreferencesRepository? = null

        fun getInstance(context: Context): DataStorePreferencesRepository{
            return INSTANCE ?: synchronized(this){
                INSTANCE?.let{
                    return it
                }
                val instance = DataStorePreferencesRepository(context)
                INSTANCE = instance
                instance

            }
        }
    }
  suspend fun setLanguage(language: Int){
      dataStore.edit{ preferences->
          preferences[PRE_LANGUAGE] = language
      }
  }

    val getLanguage: Flow<Int> = dataStore.data
        .map{preferences ->
            preferences[PRE_LANGUAGE]?: defaultLangue
        }
}
