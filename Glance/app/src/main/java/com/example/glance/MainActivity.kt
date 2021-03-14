package com.example.glance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.glance.data.todo.TodoViewModel
import com.example.glance.data.todo.TodoViewModelFactory
import com.example.glance.databinding.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: TopBarBinding

    private val todoViewModel: TodoViewModel by viewModels {
        TodoViewModelFactory((this.applicationContext as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.top_bar)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = host.navController

        val drawer = binding.drawerView
        val toolbar: Toolbar = binding.topAppBar

        val appBarConfiguration = AppBarConfiguration(navController.graph, drawer)
        setSupportActionBar(binding.topAppBar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawerDesc, R.string.closeDrawerDesc)
        drawer.addDrawerListener(toggle)
    }



    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }
}