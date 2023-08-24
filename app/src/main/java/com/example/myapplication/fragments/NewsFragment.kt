package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.example.myapplication.databinding.FragmentNewsBinding
import com.example.myapplication.utils.Resource
import com.example.myapplication.viewModel.MyViewModel

class NewsFragment : Fragment(){

    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: RecyclerViewAdapter
    lateinit var viewModelNewsFragment: MyViewModel
    val TAG = "NewsFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.recyclerNews.layoutManager = LinearLayoutManager(requireContext())
        adapter = RecyclerViewAdapter()
        binding.recyclerNews.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelNewsFragment = (activity as MainActivity).myViewModel


        observer()

        binding.imageRenew.setOnClickListener{
            reload()
        }
        binding.imageLike.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_saveFragment2)
        }
        adapter.setOnClickListener {news ->
            val action = NewsFragmentDirections.actionNewsFragmentToDetailFragment(news)
            findNavController().navigate(action)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (it.isEmpty()) {
                        reload()
                    } else {
                        viewModelNewsFragment.searchNews(it)
                        observerSearch()
                    }
                }
                return true
            }
        })
    }


    private fun reload(){
        adapter.differ.submitList(listOf())
        viewModelNewsFragment.getNews("us")
    }

    private fun observer(){
        viewModelNewsFragment.news.observe(viewLifecycleOwner, Observer {response ->
            when (response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {newsResponse ->
                        adapter.differ.submitList(newsResponse.articles)
//                        adapter.notifyItemRangeChanged(0, newsResponse.articles.size)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let{message->
                        Log.e(TAG, "Error: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun observerSearch(){
        viewModelNewsFragment.searchNews.observe(viewLifecycleOwner, Observer {response ->
            when (response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {newsResponse ->
                        adapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let{message->
                        Log.e(TAG, "Error: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }
    private  fun hideProgressBar(){
        binding.progressBar.visibility = View.INVISIBLE
    }

    private  fun showProgressBar(){
        binding.progressBar.visibility = View.VISIBLE
    }
}
