package com.farukkisik.staticsapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.farukkisik.staticsapp.R
import com.farukkisik.staticsapp.databinding.FeedbackRowBinding
import com.farukkisik.staticsapp.model.FeedbackArray
import com.farukkisik.staticsapp.model.FeedbackItem
import com.farukkisik.staticsapp.utils.ColorUtils

class FeedbackAdapter constructor(var source: FeedbackArray):
    RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackViewHolder {
        val binding: FeedbackRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.feedback_row,
            parent,
            false)

        return FeedbackViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return source.feedbackItems.size
    }

    override fun onBindViewHolder(holder: FeedbackViewHolder, position: Int) {
        val data = source.feedbackItems[position]
        holder.bind(data)
    }

    class FeedbackViewHolder(private val bind: FeedbackRowBinding) : ViewHolder(bind.root) {
        fun bind(obj: FeedbackItem){
            bind.feedbackData = obj
            if (obj.starred){
                bind.feedbackStarredIv.visibility = View.VISIBLE
            } else {
                bind.feedbackStarredIv.visibility = View.GONE
            }
            bind.feedbackPerformanceTv.setTextColor(ColorUtils.getRatedColor(obj.performance))
            bind.feedbackRatingTv.setTextColor(ColorUtils.getRatedColor(obj.rating))

            bind.executePendingBindings()
        }
    }
}

