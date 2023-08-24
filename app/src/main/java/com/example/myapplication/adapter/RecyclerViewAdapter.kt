package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.model.News

class RecyclerViewAdapter () : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var onItemClickListener: ((News)-> Unit)? = null

    fun setOnClickListener(listener: (News)-> Unit){
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = differ.currentList[position]
        with(holder.binding) {
            Glide.with(imageNews).load(news.urlToImage).into(imageNews)
            textTitle.text = news.title
            textAuthor.text = news.author
            textDescription.text = news.description
            textDate.text = news.publishedAt
            holder.itemView.setOnClickListener{
                onItemClickListener?.let {
                    it(news)
                }
            }
        }
    }

    inner class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)


    //установка differ(можно использовать вместо отдельного класса)
    private val differCallback = object : DiffUtil.ItemCallback<News>(){
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return  oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem== newItem
        }

    }
     val differ = AsyncListDiffer(this, differCallback)

}