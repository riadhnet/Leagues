package com.riadh.leagues.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.riadh.leagues.domain.LeaguesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: LeaguesRepository

    val leaguesLiveDataList: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    fun fetchLeaguesList() {
        viewModelScope.launch {
            val result = repository.getAllLeagues()
            leaguesLiveDataList.value = result?.map { it.strLeague.toString() }
        }
    }

}


