package com.example.unreal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unreal.navigation.DataStorePreferencesRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LanguageViewModel(
    private val dataStorePreferenceRepository: DataStorePreferencesRepository
) : ViewModel() {
    private val _language = MutableLiveData(1)
    var language: LiveData<Int> = _language

    init {
        viewModelScope.launch {
            dataStorePreferenceRepository.getLanguage.collect {
                _language.value = it
            }
        }
    }

    suspend fun saveLanguage(language: Int) {
        dataStorePreferenceRepository.setLanguage(language)
    }
}