package com.emmanuelamet.customnavb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.emmanuelamet.customnavb.Fragments.FavouriteFragment
import com.emmanuelamet.customnavb.Fragments.HomeFragment
import com.emmanuelamet.customnavb.Fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val favouriteFragment = FavouriteFragment()
        val settingsFragment = SettingsFragment()
        val login = LoginActivity()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btnHome -> makeCurrentFragment(homeFragment)
                R.id.btnFavourite -> makeCurrentFragment(favouriteFragment)
                R.id.btnSettings -> makeCurrentFragment(settingsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper, fragment)
        commit()

    }
}