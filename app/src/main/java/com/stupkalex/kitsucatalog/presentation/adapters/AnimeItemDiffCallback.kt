package com.stupkalex.kitsucatalog.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.stupkalex.kitsucatalog.domain.Anime

class AnimeItemDiffCallback: DiffUtil.ItemCallback<Anime>() {
    override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
        return oldItem == newItem
    }
}