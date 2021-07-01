package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritetvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.databinding.FragmentFavoriteTvShowBinding
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.detailtvshow.DetailTvShowActivity
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritetvshow.adapter.CardViewFavoriteTvShowAdapter
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritetvshow.viewmodel.FavoriteTvShowViewModel
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.tvshow.viewmodel.TvShowViewModel
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.viewmodel.ViewModelFactory
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Status

class FavoriteTvShowFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteTvShowBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val tvShowViewModel = ViewModelProvider(this, factory) [FavoriteTvShowViewModel::class.java]

        tvShowViewModel.getListFavoriteTvShow().observe(viewLifecycleOwner, { listTvShow ->
            if (listTvShow != null){
                binding.progressBar.visibility = View.GONE
                showRecyclerCardView(listTvShow)
            }
        })
    }

    private fun showRecyclerCardView(tvShows: List<TvShow>) {
        with(binding) {
            rvTvshow.setHasFixedSize(true)
            rvTvshow.layoutManager = LinearLayoutManager(context)

            val cardViewTvShowAdapter = CardViewFavoriteTvShowAdapter(tvShows)
            rvTvshow.adapter = cardViewTvShowAdapter

            cardViewTvShowAdapter.setOnItemClickCallback(object : CardViewFavoriteTvShowAdapter.OnItemClickCallback {
                override fun onItemClicked(data: TvShow) {
                    showSelectedTvShow(data)
                    val gotoDetailTvShow = Intent(context, DetailTvShowActivity::class.java)
                    gotoDetailTvShow.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, data.tvShowId)
                    startActivity(gotoDetailTvShow)
                }
            })

        }
    }

    private fun showSelectedTvShow(tvShow: TvShow) {
        Toast.makeText(context, "Kamu memilih " + tvShow.tvShowTitle, Toast.LENGTH_SHORT).show()
    }
}