package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.home.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.movie.MoviesFragment
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.tvshow.TvShowFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TvShowFragment()
            1 -> fragment = MoviesFragment()
        }
        return fragment as Fragment
    }

}