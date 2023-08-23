package com.example.myapplication.adapter

import android.util.Size
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.model.News
import com.example.myapplication.utils.DiffUtils

class RecyclerViewAdapter (val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var newsList: List<News> = emptyList()

    interface OnItemClickListener {
        fun onItemClick(news: News)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        lateinit var binding: ItemBinding
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }


    override fun getItemCount(): Int {
        return 50
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position], position, 50)
    }

    class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News, position: Int, size: Int) = with(binding) {
            Glide.with(binding.imageNews).load(news.urlToImage).into(binding.imageNews)
            textTitle.text = news.title
            textAuthor.text = news.author
            textDescription.text = news.description
            textDate.text = news.publishedAt

        }
    }
    fun setData(newList: List<News>) {
        val diffUtil = DiffUtils(newsList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        this.newsList = newList
        diffResult.dispatchUpdatesTo(this)
    }
}