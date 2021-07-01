package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favorite.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritemovie.FavoriteMovieFragment
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritetvshow.FavoriteTvShowFragment
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.movie.MoviesFragment
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.tvshow.TvShowFragment

class FavoriteSectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavoriteTvShowFragment()
            1 -> fragment = FavoriteMovieFragment()
        }
        return fragment as Fragment
    }

}