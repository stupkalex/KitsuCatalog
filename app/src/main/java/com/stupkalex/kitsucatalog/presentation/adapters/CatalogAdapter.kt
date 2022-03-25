package com.stupkalex.kitsucatalog.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import com.stupkalex.kitsucatalog.R
import com.stupkalex.kitsucatalog.domain.Anime

class CatalogAdapter : ListAdapter<Anime, ItemViewHolder>(AnimeItemDiffCallback()) {

    var onAnimeItemClickListener: OnAnimeItemClickListener? = null
    var onAnimeItemReachEndListener: OnAnimeItemReachEndListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val animeItem = getItem(position)
        holder.tvTitle.text = animeItem.title
        Picasso.get().load(animeItem.smallPoster).into(holder.ivSmallPoster)
        holder.itemView.setOnClickListener {
            onAnimeItemClickListener?.onAnimeItemClick(animeItem.id)
        }
        if(itemCount >= 20 && position > itemCount -4 && onAnimeItemReachEndListener != null){
            onAnimeItemReachEndListener?.onAnimeReachEnd()
        }

    }

    interface OnAnimeItemClickListener {
        fun onAnimeItemClick(animeId: Int)
    }

    interface OnAnimeItemReachEndListener {
        fun onAnimeReachEnd()
    }
}