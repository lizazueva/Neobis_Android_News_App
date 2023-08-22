package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.example.myapplication.databinding.FragmentNewsBinding

class NewsFragment : Fragment(), RecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentNewsBinding
    var news = emptyList<News>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.recyclerNews.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerNews.adapter = RecyclerViewAdapter(news, this)
        return binding.root
    }

    override fun onItemClick(news: News) {

        findNavController().navigate(R.id.action_newsFragment_to_detailFragment)
    }
}
