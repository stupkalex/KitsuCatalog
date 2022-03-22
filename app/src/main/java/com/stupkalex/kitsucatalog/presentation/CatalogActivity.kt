package com.stupkalex.kitsucatalog.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.stupkalex.kitsucatalog.R
import com.stupkalex.kitsucatalog.databinding.ActivityCatalogBinding
import com.stupkalex.kitsucatalog.presentation.adapters.CatalogAdapter

class CatalogActivity : AppCompatActivity() {

    private lateinit var viewModel: CatalogViewModel
    private lateinit var binding: ActivityCatalogBinding
    private lateinit var adapter: CatalogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatalogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(CatalogViewModel::class.java)
        viewModel.clearDatabase()
        setupRecyclerView()
        viewModel.listAnime.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        adapter = CatalogAdapter()
        adapter.onAnimeItemClickListener = object : CatalogAdapter.OnAnimeItemClickListener {
            override fun onAnimeItemClick(animeId: Int) {
                startActivity(DetailActivity.newIntent(this@CatalogActivity, animeId))
            }
        }
        adapter.onAnimeItemReachEndListener = object : CatalogAdapter.OnAnimeItemReachEndListener{
            override fun onAnimeReachEnd() {
                viewModel.loadData(viewModel.offsetCount)
            }

        }
        binding.rvAnimeCatalog.layoutManager = GridLayoutManager(this, getColumnCount())
        binding.rvAnimeCatalog.adapter = adapter
    }

    private fun getColumnCount(): Int {
        val displayMetrics = DisplayMetrics()
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics)
        val width = (displayMetrics.widthPixels / displayMetrics.density).toInt()
        return if (width / 185 > 2) width / 185 else 2
    }
}