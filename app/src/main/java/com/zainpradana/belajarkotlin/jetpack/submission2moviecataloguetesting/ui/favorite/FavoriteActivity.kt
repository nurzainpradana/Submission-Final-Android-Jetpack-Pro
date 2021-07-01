package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.databinding.ActivityFavoriteBinding
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favorite.adapter.FavoriteSectionsPagerAdapter
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.home.HomeActivity
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.home.adapter.SectionsPagerAdapter

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = FavoriteSectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionPagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(HomeActivity.TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }
}