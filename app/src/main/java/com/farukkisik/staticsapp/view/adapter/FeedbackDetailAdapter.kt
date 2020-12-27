package com.farukkisik.staticsapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.farukkisik.staticsapp.R
import com.farukkisik.staticsapp.databinding.FeedbackDetailRowBinding
import com.farukkisik.staticsapp.model.MapItemModel

class FeedbackDetailAdapter constructor(var source: ArrayList<MapItemModel>):
    RecyclerView.Adapter<FeedbackDetailAdapter.FeedbackDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackDetailViewHolder {
        val binding: FeedbackDetailRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.feedback_detail_row,
            parent,
            false)

        return FeedbackDetailViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return source.size
    }

    override fun onBindViewHolder(holder: FeedbackDetailViewHolder, position: Int) {
        val data = source[position]
        holder.bind(data)
    }

    class FeedbackDetailViewHolder(private val bind: FeedbackDetailRowBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bind(obj: MapItemModel){
            bind.item = obj
            bind.executePendingBindings()
        }
    }
}