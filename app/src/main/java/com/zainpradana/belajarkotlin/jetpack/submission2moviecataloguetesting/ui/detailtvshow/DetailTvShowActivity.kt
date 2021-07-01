package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.detailtvshow

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.R
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.databinding.ActivityDetailTvShowBinding
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.CustomGlide
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTvShowBinding

    private var isFavorite = false
    lateinit var mTvShow: TvShow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvShowId = intent.getIntExtra(EXTRA_TV_SHOW, 0)
        val factory = ViewModelFactory.getInstance(this)
        val detailTvShowViewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]


        detailTvShowViewModel.getTvShow(tvShowId).observe(this, { tvShow ->
            binding.progressBar.visibility = View.GONE
            setView(tvShow)

            if (tvShow.tvShowSaved != null) {
                isFavorite = tvShow.tvShowSaved!!

                checkFavorite(isFavorite)
            }

            binding.btnFavorite.setOnClickListener {
                Toast.makeText(this, if (!isFavorite) {
                    "Success Add To Favorite"
                } else {
                    "Success Deleted From Favorite"
                }, Toast.LENGTH_SHORT).show()

                isFavorite = !isFavorite

                detailTvShowViewModel.saveTvShow(tvShow, isFavorite)

                checkFavorite(isFavorite)
            }
        })
    }

    private fun setView(tvShow: TvShow?) {
        if (tvShow != null) {
            with(binding) {
                tvDetailTvShowTitle.text = tvShow.tvShowTitle
                tvDetailTvShowDescription.text = tvShow.tvShowDescription
                tvDetailTvShowGenre.text = tvShow.tvShowGenre
                tvDetailTvShowYear.text = tvShow.tvShowYear

                CustomGlide.setImage(applicationContext, tvShow.tvShowPoster, imgDetailTvShowPoster)
//                Glide.with(applicationContext)
//                        .load(tvShow.tvShowPoster)
//                        .apply(RequestOptions().override(150, 150))
//                        .into(imgDetailTvShowPoster)

                CustomGlide.setBlurImage(applicationContext, tvShow.tvShowPoster, imgDetailTvShowPosterBlur)
//                Glide.with(applicationContext)
//                        .load(tvShow.tvShowPoster)
//                        .apply(RequestOptions.bitmapTransform(BlurTransformation(25)))
//                        .into(imgDetailTvShowPosterBlur)

                val actionBar = supportActionBar
                if (actionBar != null) {
                    actionBar.title = getString(R.string.tvshow) + " : " + tvShow.tvShowTitle
                }
            }
        }
    }

    fun checkFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            Glide.with(this).load(R.drawable.ic_favorited).into(binding.btnFavorite)
        } else {
            Glide.with(this).load(R.drawable.ic_favorite).into(binding.btnFavorite)
        }
    }

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }
}