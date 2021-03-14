package com.example.glance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.glance.databinding.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: TopBarBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setup binding
        binding = DataBindingUtil.setContentView(this, R.layout.top_bar)

        // setup values
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = host.navController
        val drawer = binding.drawerView
        val navigationView: NavigationView = binding.navigationView
        appBarConfiguration = AppBarConfiguration(navController.graph, drawer)

        // setup AppBar
        setSupportActionBar(binding.topAppBar)
        setupActionBarWithNavController(navController, appBarConfiguration)


        // setup navDrawer
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.InboxMenu -> {
                Toast.makeText(this, "Inbox it is then", Toast.LENGTH_SHORT).show()
            }
            R.id.TodayMenu -> {
                Toast.makeText(this, "Today it is then", Toast.LENGTH_SHORT).show()
            }
            R.id.HabitsMenu -> {
                Toast.makeText(this, "Habits it is then", Toast.LENGTH_SHORT).show()
            }
            R.id.ScheduleMenu -> {
                Toast.makeText(this, "Schedule it is then", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
