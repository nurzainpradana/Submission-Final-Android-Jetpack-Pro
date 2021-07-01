package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.R
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.databinding.ActivityMainBinding
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favorite.FavoriteActivity
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.home.adapter.SectionsPagerAdapter

class HomeActivity : AppCompatActivity() {

    companion object {
        @StringRes
        val TAB_TITLES = intArrayOf(
                R.string.title_tvshow,
                R.string.title_movies
        )
    }


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionPagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.language_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_change_setting -> {
                val i = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(i)
            }

            R.id.action_favorite -> {
                val i = Intent(this, FavoriteActivity::class.java)
                startActivity(i)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}