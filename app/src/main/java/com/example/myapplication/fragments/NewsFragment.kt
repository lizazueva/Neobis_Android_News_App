package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.example.myapplication.databinding.FragmentNewsBinding
import com.example.myapplication.retrofit.News
import com.example.myapplication.viewModel.ViewModel

class NewsFragment : Fragment(), RecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: RecyclerViewAdapter

    private val newsViewModel by lazy {ViewModelProvider.of(this).get(ViewModel::class.java)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.recyclerNews.layoutManager = LinearLayoutManager(requireContext())
        adapter = RecyclerViewAdapter(news, this)
        binding.recyclerNews.adapter = adapter
        return binding.root
    }

    override fun onItemClick(news: News) {

        findNavController().navigate(R.id.action_newsFragment_to_detailFragment)
    }
}
