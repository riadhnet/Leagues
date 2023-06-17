package com.riadh.leagues.main

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
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
        manageClick()
        showTeamsList()
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

    private fun manageClick() {
        binding.searchBar.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedItem = adapter.getItem(position)
                selectedItem?.let {
                    viewModel.fetchLeagueTeams(it)
                }
            }
    }

    private fun showTeamsList() {
        viewModel.teamsLiveDataList.observe(this) { teamsList ->
            Log.i("list", teamsList.size.toString())
        }
    }


}

