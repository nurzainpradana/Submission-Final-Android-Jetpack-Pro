package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.tvshow

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
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.databinding.FragmentTvShowBinding
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.detailtvshow.DetailTvShowActivity
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.tvshow.adapter.CardViewTvShowAdapter
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.tvshow.viewmodel.TvShowViewModel
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.viewmodel.ViewModelFactory
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val tvShowViewModel = ViewModelProvider(this, factory) [TvShowViewModel::class.java]

        tvShowViewModel.getListTvShow().observe(viewLifecycleOwner, { listTvShow ->
            if (listTvShow != null){
                when(listTvShow.status){
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        showRecyclerCardView(listTvShow.data!!)
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun showRecyclerCardView(tvShows: PagedList<TvShow>) {
        with(binding) {
            rvTvshow.setHasFixedSize(true)
            rvTvshow.layoutManager = LinearLayoutManager(context)

            val cardViewTvShowAdapter = CardViewTvShowAdapter(tvShows)
            cardViewTvShowAdapter.submitList(tvShows)
            rvTvshow.adapter = cardViewTvShowAdapter

            cardViewTvShowAdapter.setOnItemClickCallback(object : CardViewTvShowAdapter.OnItemClickCallback {
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