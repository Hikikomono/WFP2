package com.example.glance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.glance.data.todo.TodoViewModel
import com.example.glance.data.todo.TodoViewModelFactory
import com.example.glance.databinding.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: TopBarBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val todoViewModel: TodoViewModel by viewModels {
        TodoViewModelFactory((this.applicationContext as TodoApplication).repository)
    }

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
        val navController = findNavController(R.id.nav_host_fragment)
        when (item.itemId) {
            R.id.InboxMenu -> {
                navController.navigate(R.id.action_OverviewFragment_to_TodoListFragment)
                Toast.makeText(this, "Inbox it is then", Toast.LENGTH_SHORT).show()
            }
            R.id.TodayMenu -> {
                navController.navigate(R.id.action_OverviewFragment_to_TodoListFragment)
                Toast.makeText(this, "Today it is then", Toast.LENGTH_SHORT).show()
            }
            R.id.HabitsMenu -> {
                navController.navigate(R.id.action_OverviewFragment_to_TodoListFragment)
                Toast.makeText(this, "Habits it is then", Toast.LENGTH_SHORT).show()
            }
            R.id.ScheduleMenu -> {
                Toast.makeText(this, "WIP", Toast.LENGTH_SHORT).show()
            }
        }
        binding.drawerView.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
