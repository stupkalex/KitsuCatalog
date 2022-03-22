package com.stupkalex.kitsucatalog.presentation.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stupkalex.kitsucatalog.R

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ivSmallPoster = itemView.findViewById<ImageView>(R.id.ivSmallPoster)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitleAnimeItem)
}