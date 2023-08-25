package com.example.myapplication.fragments

import android.os.Bundle
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
import com.example.myapplication.databinding.FragmentSaveBinding
import com.example.myapplication.model.News
import com.example.myapplication.viewModel.MyViewModel


class SaveFragment : Fragment() {

    private lateinit var binding: FragmentSaveBinding
    private lateinit var adapter: RecyclerViewAdapter
    lateinit var viewModelNewsSaveFragment: MyViewModel
    private lateinit var originalNewsList: List<News>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveBinding.inflate(inflater, container, false)
        binding.recyclerSave.layoutManager = LinearLayoutManager(requireContext())
        adapter = RecyclerViewAdapter()
        binding.recyclerSave.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelNewsSaveFragment = (activity as MainActivity).myViewModel

        adapter.setOnClickListener { news ->
            val action = SaveFragmentDirections.actionSaveFragment2ToDetailFragment(news)
            findNavController().navigate(action)
        }
        binding.imageSaveBack.setOnClickListener {
            findNavController().navigate(R.id.action_saveFragment2_to_newsFragment)
        }

        viewModelNewsSaveFragment.getSaveNews().observe(viewLifecycleOwner, Observer { news ->
            originalNewsList = news
            adapter.differ.submitList(news)
            adapter.notifyDataSetChanged()
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    adapter.differ.submitList(originalNewsList)
                    adapter.notifyDataSetChanged()
                } else {
                    newText?.let { filterProducts(it) }
                }
                return true
            }
        })

    }

    private fun filterProducts(query: String) {
        val filteredList = mutableListOf<News>()
        for (news in originalNewsList) {
            if (news.title.contains(query, ignoreCase = true)) {
                filteredList.add(news)
            }
        }
        adapter.differ.submitList(filteredList)
        adapter.notifyDataSetChanged()
    }
}