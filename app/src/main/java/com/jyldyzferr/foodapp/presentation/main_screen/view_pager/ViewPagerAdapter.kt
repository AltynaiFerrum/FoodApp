package com.jyldyzferr.foodapp.presentation.main_screen.view_pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jyldyzferr.foodapp.R
import com.jyldyzferr.foodapp.databinding.ItemRecommendationEventBinding
import com.jyldyzferr.foodapp.domain.models.RecommendationsEvent

class ViewPagerAdapter:RecyclerView.Adapter<ViewPagerViewHolder>() {

    private val events = mutableListOf<RecommendationsEvent>()

    fun updateData(newList: List<RecommendationsEvent>){
        events.clear()
        events.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_recommendation_event, parent, false)
        val binding = ItemRecommendationEventBinding.bind(view)
        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
    holder.bind (events[position])
    }

}