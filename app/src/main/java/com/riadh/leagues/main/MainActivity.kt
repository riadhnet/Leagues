package com.riadh.leagues.main

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.riadh.leagues.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        manageSearch()
        fetchData()

    }


    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun manageSearch() {
        viewModel.leaguesLiveDataList.observe(this) { leaguesList ->
            adapter =
                ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, leaguesList)
            binding.searchBar.setAdapter(adapter)
        }
    }


    private fun fetchData() {
        viewModel.fetchLeaguesList()
    }


}

