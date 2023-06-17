package com.riadh.leagues.main

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.riadh.leagues.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private lateinit var leaguesAdapter: ArrayAdapter<String>
    private lateinit var imageAdapter: ImageAdapter


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
        binding.teamsList.layoutManager = GridLayoutManager(this, 2)
    }

    private fun manageSearch() {
        viewModel.leaguesLiveDataList.observe(this) { leaguesList ->
            leaguesAdapter =
                ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, leaguesList)
            binding.searchBar.setAdapter(leaguesAdapter)
        }
    }


    private fun fetchData() {
        viewModel.fetchLeaguesList()
    }

    private fun manageClick() {
        binding.searchBar.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedItem = leaguesAdapter.getItem(position)
                selectedItem?.let {
                    viewModel.fetchLeagueTeams(it)
                }
            }
    }

    private fun showTeamsList() {
        viewModel.teamsLiveDataList.observe(this) { teamsList ->
            hideKeyboard()
            imageAdapter = ImageAdapter(teamsList)
            binding.teamsList.adapter = imageAdapter
        }
    }

    //move to util class
    private fun hideKeyboard() {
        this.currentFocus?.let { view ->
            val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


}

