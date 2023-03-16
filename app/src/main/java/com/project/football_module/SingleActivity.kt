package com.project.football_module

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.project.football_module.databinding.ActivitySingleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleActivity : AppCompatActivity(){

    private lateinit var navController: NavController
    private lateinit var binding: ActivitySingleBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navigationSetup()
    }

    private fun navigationSetup(){
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavView,navController)
        appBarSetup(navController)
    }

    private fun appBarSetup(navController: NavController){
        appBarConfiguration =
            AppBarConfiguration(setOf(com.project.presentation.R.id.matchListFragment, com.project.presentation.R.id.competitionListFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == com.competition.detail.R.id.viewPager) {
                supportActionBar?.setHomeAsUpIndicator(com.common.ui.R.drawable.ic_arrow_back_black_24dp)
            }
        }
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
}