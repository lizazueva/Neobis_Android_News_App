package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.retrofit.News
import com.example.myapplication.utils.DiffUtils

class RecyclerViewAdapter (var news: List<News>, val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(product: News)
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
        val currentItem = news[position]
        Glide.with(holder.image).load(currentItem.urlToImage).into(holder.image)
        holder.title.text = currentItem.title
        holder.author.text = currentItem.author
        holder.discription.text = currentItem.description
        holder.date.text = currentItem.publishedAt
        holder.cardItem.setOnClickListener {
            listener.onItemClick(news[position])
        }
    }

    class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.imageNews
        val title: TextView = binding.textTitle
        val author: TextView = binding.textAuthor
        val discription: TextView = binding.textDescription
        val date: TextView = binding.textDate
        val cardItem: CardView = binding.cardNews


    }

    fun setData(newList: List<News>){
        val diffUtil = DiffUtils(news, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        diffResult.dispatchUpdatesTo(this)
    }
}